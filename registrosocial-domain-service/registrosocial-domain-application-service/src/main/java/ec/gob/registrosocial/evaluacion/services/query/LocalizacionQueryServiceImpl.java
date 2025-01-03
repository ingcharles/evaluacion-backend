/**
*
* Este archivo es la implementación del controlador: LocalizacionQueryControllerImpl
*
* @copyright     registrosocial 02-01-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          02-01-2025
* @name          LocalizacionQueryControllerImpl
* @package       adminAllPaginateservices
* @subpackage   ec.gob.registrosocial.evaluacion.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.services.query;

import ec.gob.registrosocial.evaluacion.ports.inputs.query.LocalizacionQueryService;
import ec.gob.registrosocial.evaluacion.ports.outputs.query.LocalizacionQueryRepository;
import ec.gob.registrosocial.evaluacion.records.request.LocalizacionRequestRecord;
import ec.gob.registrosocial.evaluacion.records.response.LocalizacionResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocalizacionQueryServiceImpl implements LocalizacionQueryService {

	private final LocalizacionQueryRepository localizacionQueryRepository;

	/**
	*
	* Método que obtiene los datos de las provincias
	*
	* @name findAllLocalizacion
	* @return List<LocalizacionResponseRecord>
	*/
	@Override
	public List<LocalizacionResponseRecord> findAllProvincia() {
		return localizacionQueryRepository.findAllProvincia();
	}

	/**
	*
	* Método que obtiene los datos de los cantones por id provincia
	*
	* @name findAllPaginateLocalizacion
	* @param request
	* @return Page<LocalizacionResponseRecord>
	*/
	@Override
	public List<LocalizacionResponseRecord> findCantonByIdProvincia(LocalizacionRequestRecord request) {
		return localizacionQueryRepository.findCantonByIdProvincia(request);
	}

	/**
	*
	* Método que obtiene los datos de las prarroquias por id canton
	*
	* @name findParroquiaByIdCanton
	* @param request
	* @return LocalizacionResponseRecord
	*/
	@Override
	public List<LocalizacionResponseRecord>  findParroquiaByIdCanton(LocalizacionRequestRecord request) {
		return localizacionQueryRepository.findParroquiaByIdCanton(request);
	}

}
