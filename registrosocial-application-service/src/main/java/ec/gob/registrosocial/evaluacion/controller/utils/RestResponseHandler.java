/**
 * Proyecto cj-bandejas.
 *
 * <p>Clase RestResponseHandler 24/09/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.registrosocial.evaluacion.controller.utils;

import ec.gob.registrosocial.evaluacion.records.response.ApiResponseRecord;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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
@Component
public class RestResponseHandler {
  // Método para manejar la respuesta de "no contenido" con mensaje por defecto
  public <T> ApiResponseRecord<List<T>> handleListNoContent() {
    return new ApiResponseRecord<>(
        HttpStatus.NO_CONTENT.value(), true, "No hay registros", new ArrayList<>());
  }

  // Método para manejar la respuesta de "no contenido" con mensaje por defecto
  public <T> ApiResponseRecord<T> handleNoContent() {
    return new ApiResponseRecord<>(HttpStatus.NO_CONTENT.value(),
        true,
        "No hay registros",
        (T) List.of());
  }

  // Método para manejar la respuesta de "no contenido" con mensaje
  public <T> ApiResponseRecord<List<T>> handleNoContent(String message) {
    return new ApiResponseRecord<>(HttpStatus.NO_CONTENT.value(), true, message, new ArrayList<>());
  }

  // Método para manejar la respuesta cuando hay una lista de datos disponibles
  public <T> ApiResponseRecord<List<T>> handleListContent(List<T> result) {
    return new ApiResponseRecord<>(
        HttpStatus.OK.value(),
        true,
        "Lista obtenida exitosamente", // Mensaje predeterminado
        result // Resultados obtenidos
        );
  }

  // Método para manejar la respuesta cuando una hay lista de datos disponibles y con mensaje
  public <T> ApiResponseRecord<List<T>> handleListContent(String message, List<T> result) {
    return new ApiResponseRecord<>(
        HttpStatus.OK.value(),
        true,
        message, // Mensaje predeterminado
        result // Resultados obtenidos
        );
  }

  // Método para manejar la respuesta cuando un objeto de datos disponibles
  public <T> ApiResponseRecord<T> handleContent(T result) {
    return new ApiResponseRecord<>(
        HttpStatus.OK.value(),
        true,
        "Lista obtenida exitosamente", // Mensaje predeterminado
        result // Resultados obtenidos
        );
  }

  // Método para manejar la respuesta cuando un objeto de datos disponibles y con mensaje
  public <T> ApiResponseRecord<T> handleContent(String message, T result) {
    return new ApiResponseRecord<>(
        HttpStatus.OK.value(),
        true,
        message, // Mensaje predeterminado
        result // Resultados obtenidos
        );
  }

  // Método para manejar la respuesta de error interno del servidor
  public <T> ApiResponseRecord<List<T>> handleListInternalServerError() {
    return new ApiResponseRecord<>(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        false,
        "Error interno del servidor", // Mensaje opcional
        null // No hay datos
        );
  }

  // Método para manejar la respuesta de error interno del servidor
  public <T> ApiResponseRecord<T> handleInternalServerError() {
    return new ApiResponseRecord<>(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        false,
        "Error interno del servidor", // Mensaje opcional
        null // No hay datos
        );
  }
}
