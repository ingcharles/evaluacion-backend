# Changelog

## 26/09/2024

- Se cambia el servidor de aplicaciones, se deja de usar tomcat y se utiliza undertow.
- Se cambia la forma de generar la imagen docker
    - Se quita la forma de crear la imagen, de automática a manual, ahora se debe utilizar el comando mvn package
    - Se añade la fecha de creación de la imagen.
    - Se cambia el gestor para crear la imagen por packeto libérica.
    - Se añade a la configuración de la creación de la imagen las variables de optimización de la jvm con la que se inicializará el contenedor.
    - Se elimina los límites de la JVM -Xms512M -Xmx1G
- Se actualiza el pipeline de gitlab para la generación y almacenamiento de la imagen Docker.
- Se actualiza las versiones de las dependencias utilizadas en los microservicios.
    - Se actualiza la versión de java a la 21
    - Se actualiza la versión de spring boot a la 3.2.2
    - Se actualiza la versión de spring cloud a la 2023.0.0
    - Se actualiza la versión del manejador de excepciones a la 1.7
    - Se actualiza la versión de reddison a la 3.25.2
    - Se actualiza la versión de hikariCP a la 5.0.1
    - Se actualiza la versión del driver de sql ser ver a la 12.4.2.jre11
    - Se actualiza las versiones de los plugin para PMD, Codesmell, Checkstyle, OWASP, Jacoco a las últimas versiones.
- Se actualiza la configuración para la documentación del api rest utilizando openApi.
- Se corrige la utilización de redis.
- Se corrige la utilización del monitoreo de los microservicios.
- Se añade un microservicio que expone un endpoint para la descarga de pdfs, evitando así exponer el api phoenix.
- Se añade un microservicio que administra toda la lógica de las tablas de réplica de la base EWEB, separando las consultas a los procedimientos almacenados de las tablas.
- Se elimina la consulta de número total de registros para la búsqueda inteligente ya que esa búsqueda tarda demasiado.
- Se añade en la búsqueda inteligente el ordenamiento descendente.
- Se añade más validaciones para controlar datos nulos retornados por los procedimientos almacenados, evitando así generar errores en el frontend.
- Se corrige la configuración del servidor Gateway para que se haga un autodescubrimiento de los microservicios.
- Se corrige la forma de deploy individual de cada microservicio, optimizando el tiempo de despliegue.
- Se agrega un mejor control de excepciones.
- Se actualiza la configuración de logs.

## 18/09/2023

- Actualización de la plantilla, a la que se le agrega lo siguiente:

1. Configuración de la cache con Redis.
2. Módulos commons y remote
    * Commons contiene la administración de mensajes
    * Remote contiene la comunicación con otros microservicios a través de feign.
3. Configuración de plugins para revisión de código estático.

## 12/09/2023

- Versión inicial que contiene:

1. Diseño modular basado en arquitectura limpia (hexagonal).
2. Administración automática de excepciones.
3. Ejemplo de servicio rest, servicio ejb y repositorio jpa.
4. Manejo de transacciones.
5. Control de concurrencia para cada entity.
6. Manejo de records en lugar de TOs.
7. Manejo de mappers con mapStruct en lugar de mappers manuales.
8. Configuración de conexión a base de datos y control de pool de conexiones.
9. Validación de PMD, Codesmell, CheckStyle basado en las reglas que se encuentran cargadas en el
   repositorio http://10.1.22.164/analisis-codigo/analisis-codigo.
10. Pipeline de integración continua (CI) de GitLab para :
    a. Integración continua mediante plugins de validaciones de código estático para que se realice la verificación con
    cada ejecución del comando mvn clean install antes de subir el código al GitLab.
    b. Envío del código fuente al servidor SonarQube.
    c. Creación de la imagen Docker basada en el código fuente y envío de imagen Docker al registry.
