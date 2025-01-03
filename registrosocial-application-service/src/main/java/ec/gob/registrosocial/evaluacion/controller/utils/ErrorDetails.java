/**
 * Proyecto cj-bandejas.
 *
 * <p>Clase ErrorDetails 24/09/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.registrosocial.evaluacion.controller.utils;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 24/09/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0 $
 * @since 24/09/2024
 */
@Getter
@Setter
public class ErrorDetails {

  private LocalDateTime timestamp;
  private String message;
  private String details;

  public ErrorDetails(LocalDateTime timestamp, String message, String details) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
}
