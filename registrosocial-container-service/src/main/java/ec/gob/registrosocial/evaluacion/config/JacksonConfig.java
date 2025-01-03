/**
 * Proyecto 02-EJEMPLO-JAVA-MICROSERVICIO.
 *
 * <p>Clase JacksonConfig 25/6/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.registrosocial.evaluacion.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 25/6/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0 $
 * @since 25/6/2024
 */
//@Configuration
public class JacksonConfig {

  //@Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    //JavaTimeModule module = new JavaTimeModule();
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    //module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));

    return mapper;
  }
}
