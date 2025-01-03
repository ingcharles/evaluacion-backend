/**
 * Proyecto 02-EJEMPLO-JAVA-MICROSERVICIO.
 *
 * <p>Clase StateEnum 10/6/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.registrosocial.evaluacion.enumeration;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DEL RECORD --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 10/6/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0
 * @since 10/6/2024
 */
public enum StateEnum {
  ACTIVO("A"),
  INCATIVO("I"),
  ELIMINADO("X");

  private final String state;

  StateEnum(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
