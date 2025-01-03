/**
*
* Este archivo es el modelo para recuperar los datos
*
* @copyright     registrosocial 03-12-2024
* @author        Carlos Anchundia
* @version       1.0.0
* @date          03-12-2024
* @name          LocalizacionException
* @package       registrosocial-domain-services
* @subpackage   ec.gob.registrosocial.evaluacion.exceptions
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 03-12-2024
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.registrosocial.evaluacion.exceptions;

public class LocalizacionException extends GeneralException {
public LocalizacionException(String message) { super(message); }
public LocalizacionException(String message, Throwable cause) { super(message, cause); }

}
