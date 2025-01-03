/**
 * Este archivo es el modelo para recuperar los datos
 *
 * @copyright registrosocial 02-01-2025
 * @author Carlos Anchundia
 * @version 1.0.0
 * @date 02-01-2025
 * @name LocalizacionResponseRecord
 * @package registrosocial-domain-services
 * @subpackage ec.gob.registrosocial.evaluacion.records.response
 * <p>
 * ------------- HISTORIAL DE CAMBIOS ------------
 * 1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 02-01-2025
 * <!-- Añadir nuevas entradas de cambios aquí -->
 */
package ec.gob.registrosocial.evaluacion.records.response;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record LocalizacionResponseRecord(
        String id,
        String nombre)
        implements Serializable {

}
