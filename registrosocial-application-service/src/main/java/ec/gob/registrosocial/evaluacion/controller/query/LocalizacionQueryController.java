/**
*
* Este archivo es la implementación del controlador: LocalizacionQueryControllerImpl
*
* @copyright     registrosocial 03-12-2024
* @author        Carlos Anchundia
* @version       1.0.0
* @date          03-12-2024
* @name          LocalizacionQueryControllerImpl
* @package       registrosocial-application-services
* @subpackage   ec.gob.registrosocial.evaluacion.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 03-12-2024
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.controller.query;

import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/query/localizacion")
@Validated
public interface LocalizacionQueryController {

	/**
	*
	* Método que obtiene los datos de las provincias
	*
	* @name findAllProvincia
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@GetMapping("/findAllProvincia")
	@Operation(summary = "Método que obtiene los datos de las provincias")
	<T> ApiResponseRecord<List<T>> findAllProvincia();

	/**
	*
	* Método que obtiene los datos de los cantones por id provincia
	*
	* @name findCantonByIdProvincia
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@PostMapping("/findCantonByIdProvincia")
	@Operation(summary = "Método que obtiene los datos de los cantones por id provincia")
	<T> ApiResponseRecord<List<T>> findCantonByIdProvincia(@Valid @NotNull @RequestBody LocalizacionRequestRecord request);

	/**
	*
	* Método que obtiene los datos de las parroquias por id cantón
	*
	* @name findParroquiaByIdCanton
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T>
	*/
	@PostMapping("/findParroquiaByIdCanton")
	@Operation(summary = "Método que obtiene los datos de las parroquias por id cantón")
	<T> ApiResponseRecord<List<T>> findParroquiaByIdCanton(@Valid @NotNull @RequestBody LocalizacionRequestRecord request);

}
