/**
*
* Este archivo es la implementación del controlador: LocalizacionQueryControllerImpl
*
* @copyright     registrosocial 02-01-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          02-01-2025
* @name          LocalizacionQueryControllerImpl
* @package       registrosocial-application-services
* @subpackage    ec.gob.registrosocial.evaluacion.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.controller.query.impl;

import ec.gob.registrosocial.evaluacion.ports.inputs.query.LocalizacionQueryService;
import ec.gob.registrosocial.evaluacion.controller.query.LocalizacionQueryController;
import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.ApiResponseRecord;
import ec.gob.registrosocial.evaluacion.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocalizacionQueryControllerImpl implements LocalizacionQueryController {

	private final RestResponseHandler restResponseHandler;
	private final LocalizacionQueryService localizacionQueryService;

	/**
	*
	* Método que obtiene los datos de las provincias
	*
	* @name findAllLocalizacion
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@Override
	public <T> ApiResponseRecord<List<T>> findAllProvincia() {
		try {
			List<T> resultLocalizacion = (List<T>) localizacionQueryService.findAllProvincia();
			if (resultLocalizacion.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultLocalizacion);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}


	/**
	*
	* Método que obtiene los datos de los cantones por id provincia
	*
	* @name findCantonByIdProvincia
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<List<T>> 
	*/
	@Override
	public <T> ApiResponseRecord<List<T>> findCantonByIdProvincia(LocalizacionRequestRecord request) {
		try {
			List<T> resultLocalizacion = (List<T>) localizacionQueryService.findCantonByIdProvincia(request);
			if (resultLocalizacion.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultLocalizacion);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}


	/**
	 *
	 * Método que obtiene los datos de las parroquias por id cantón
	 *
	 * @name findParroquiaByIdCanton
	 * @param request
	 * parameter input request
	 * @return <T> ApiResponseRecord<T> 
	 */
	@Override
	public <T> ApiResponseRecord<List<T>> findParroquiaByIdCanton(LocalizacionRequestRecord request) {
		try {
			List<T> resultLocalizacion = (List<T>) localizacionQueryService.findParroquiaByIdCanton(request);
			if (resultLocalizacion.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultLocalizacion);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}


}
