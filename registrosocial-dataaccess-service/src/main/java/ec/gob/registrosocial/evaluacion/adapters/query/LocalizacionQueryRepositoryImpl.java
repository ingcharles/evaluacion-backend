/**
*
* Este archivo es la implementación del query repository: LocalizacionRepositoryImpl
*
* @copyright     registrosocial 02-01-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          02-01-2025
* @name          LocalizacionQueryRepositoryImpl
* @package       registrosocial-dataaccess-services
* @subpackage    ec.gob.registrosocial.evaluacion.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.adapters.query;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ec.gob.registrosocial.evaluacion.exceptions.LocalizacionException;
import ec.gob.registrosocial.evaluacion.ports.outputs.query.LocalizacionQueryRepository;
import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.LocalizacionResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocalizacionQueryRepositoryImpl implements LocalizacionQueryRepository {

	@Value("${app.data.json-url}")
	private String jsonUrl;

	/**
	*
	* Método que obtiene los datos de las provincias
	*
	* @name findAllLocalizacion
	* @return List<LocalizacionResponseRecord>
	*/
	@Override
	public List<LocalizacionResponseRecord> findAllProvincia() {
		return loadJsonData(jsonUrl,"provincias",null);
	}

	/**
	*
	* Método que obtiene los datos de los cantones por id provincia
	*
	* @name findCantonByIdProvincia
	* @param request
	* @return List<LocalizacionResponseRecord>
	*/
	@Override
	public List<LocalizacionResponseRecord> findCantonByIdProvincia(LocalizacionRequestRecord request) {
		return loadJsonData(jsonUrl,"cantones",request.id());
	}

	/**
	*
	* Método que obtiene los datos de las parroquias por id canton
	*
	* @name findByIdLocalizacion
	* @param request
	* @return LocalizacionResponseRecord 
	*/
	@Override
	public List<LocalizacionResponseRecord> findParroquiaByIdCanton(LocalizacionRequestRecord request) {
		return loadJsonData(jsonUrl,"parroquias",request.id());
	}

	/**
	 *
	 * Método para conectar a la api y obtener los datos json
	 *
	 * @name sendHttpRequest
	 * @param url
	 * @return String
	 */
	private String sendHttpRequest(String url) {
		String responseString = "";
		try (HttpClient client = HttpClient.newHttpClient()) {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.header("Accept", "application/json")
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.body());
			if (response.statusCode() != 200) {
				throw new LocalizacionException("Error al obtener datos del JSON: " + response.body());
			}
			responseString = response.body();
		} catch (IOException | InterruptedException e) {
			throw new LocalizacionException("Error al conectar con la API" + e.getMessage());
		}
		return responseString;
	}

	/**
	 *
	 * Método mapear los datos de provincia, cantón y parroquia
	 *
	 * @name loadJsonData
	 * @param url
	 * @param tipo
	 * @param id
	 * @return List<LocalizacionResponseRecord>
	 */
	public List<LocalizacionResponseRecord> loadJsonData(String url, String tipo, String id) {
		String jsonResponse = sendHttpRequest(url);
		List<LocalizacionResponseRecord> localizaciones = new ArrayList<>();
		JsonObject rootNode = JsonParser.parseString(jsonResponse).getAsJsonObject();
		switch (tipo){
			case "provincias":
				rootNode.entrySet().forEach(entry -> {
					JsonObject provinceObject = entry.getValue().getAsJsonObject();
					Optional.ofNullable(provinceObject.get("provincia"))
					.map(JsonElement::getAsString)
					.ifPresent(provinceName -> {
						localizaciones.add(new LocalizacionResponseRecord(entry.getKey(), provinceName));
					});
				});
				break;
				case "cantones":
					Optional.ofNullable(rootNode.getAsJsonObject(id))
						.map(provinciasObject -> provinciasObject.getAsJsonObject(tipo)) // Obtenemos los cantones
						.ifPresent(cantonesObject ->
								cantonesObject.entrySet().forEach(entry -> {
									String cantonName = entry.getValue().getAsJsonObject().get("canton").getAsString();
									localizaciones.add(new LocalizacionResponseRecord(entry.getKey(), cantonName));
								})
						);
				break;
				case "parroquias":
					rootNode.entrySet().stream()
						.map(Map.Entry::getValue) // Obtenemos el JsonObject de cada provincia
						.map(JsonElement::getAsJsonObject)
						.map(provinciasObject -> provinciasObject.getAsJsonObject("cantones"))
						.forEach(cantonesObject -> {
							cantonesObject.entrySet().stream()
									.filter(cantonEntry -> cantonEntry.getKey().equals(id))
									.map(Map.Entry::getValue)
									.map(JsonElement::getAsJsonObject)
									.filter(cantonObject -> cantonObject.has(tipo) && !cantonObject.get(tipo).isJsonNull())
									.map(cantonObject -> cantonObject.getAsJsonObject(tipo))
									.forEach(parroquiasObject -> {
										parroquiasObject.entrySet().forEach(entry -> {
											LocalizacionResponseRecord record = new LocalizacionResponseRecord(entry.getKey(), entry.getValue().getAsString());
											localizaciones.add(record);
										});
									});
						});

				break;
				default:
					break;
		}
		return localizaciones;
	}
}
