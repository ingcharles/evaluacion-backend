/**
 *
 * Este archivo es la implementación del controlador: LocalizacionQueryService
 *
 * @copyright     registrosocial 02-01-2025
 * @author        Carlos Anchundia
 * @version       1.0.0
 * @date          02-01-2025
 * @name          LocalizacionQueryService
 * @package       registrosocial-domain-services
 * @subpackage   ec.gob.registrosocial.evaluacion.controller.query.impl
 *
 *    ------------- HISTORIAL DE CAMBIOS ------------
 *          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
 *    <!-- Añadir nuevas entradas de cambios aquí -->
 *
 */
package ec.gob.registrosocial.evaluacion.ports.inputs.query;

import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.LocalizacionResponseRecord;

import java.util.List;

public interface LocalizacionQueryService {

	/**
	 *
	 * Método que obtiene los datos de las provincias
	 *
	 * @name findAllLocalizacion
	 * @return List<LocalizacionResponseRecord>
	 */
	List<LocalizacionResponseRecord> findAllProvincia();

	/**
	 *
	 * Método que obtiene los datos de los cantones por id provincia
	 *
	 * @name findAllPaginateLocalizacion
	 * @param request
	 * parameter input request
	 * @return Page<LocalizacionResponseRecord>
	 */
	List<LocalizacionResponseRecord> findCantonByIdProvincia(LocalizacionRequestRecord request);

	/**
	 *
	 * Método que obtiene los datos de las parroquias por id cantón
	 *
	 * @name findByIdLocalizacion
	 * @param request
	 * parameter input request
	 * @return LocalizacionResponseRecord
	 */
	List<LocalizacionResponseRecord> findParroquiaByIdCanton(LocalizacionRequestRecord request);

}
