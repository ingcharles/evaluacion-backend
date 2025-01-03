/**
*
* Este archivo es la interfaz del repositorio: Localizacion
*
* @copyright     registrosocial 02-01-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          02-01-2025
* @name          LocalizacionRepository
* @package       registrosocial-domain-services
* @subpackage   ec.gob.registrosocial.evaluacion.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.ports.outputs.query;

import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.LocalizacionResponseRecord;

import java.util.List;

public interface LocalizacionQueryRepository {

	/**
	*
	* Método que obtiene los datos por id de la tabla tbl_accion
	*
	* @name findAllProvincia
	* @return List<LocalizacionResponseRecord>
	*/
	 List<LocalizacionResponseRecord> findAllProvincia();

	/**
	*
	* Método que obtiene los datos por id de la tabla tbl_accion
	*
	* @name findCantonByIdProvincia
	* @param request
		* parameter input request
	* @return List<LocalizacionResponseRecord>
	*/
	List<LocalizacionResponseRecord> findCantonByIdProvincia(LocalizacionRequestRecord request);

	/**
	*
	* Método que obtiene los datos por id de la tabla tbl_accion
	*
	* @name findByIdLocalizacion
	* @param request
		* parameter input request
	* @return List<LocalizacionResponseRecord>
	*/
	List<LocalizacionResponseRecord> findParroquiaByIdCanton(LocalizacionRequestRecord request);


}
