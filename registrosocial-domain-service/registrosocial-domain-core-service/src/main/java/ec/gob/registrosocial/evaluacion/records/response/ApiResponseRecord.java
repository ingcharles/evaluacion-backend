/**
 * Proyecto cj-bandejas.
 *
 * <p>Clase ApiResponseRecord 23/09/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.registrosocial.evaluacion.records.response;

import java.io.Serializable;
import lombok.Builder;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DEL RECORD --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 23/09/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0
 * @since 23/09/2024
 */

@Builder
public record ApiResponseRecord<T>(
    Integer statusCode,
    Boolean status,
    String message,
    T data
    ) implements Serializable {

}
