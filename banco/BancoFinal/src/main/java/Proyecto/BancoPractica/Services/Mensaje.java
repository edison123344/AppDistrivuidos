package Proyecto.BancoPractica.Services;
/**
 * 
 * @author edison
 *
 */
public class Mensaje {
	/**
	 * clase usada para captar errores en las trnsacciones REST
	 */
private String code;
private String message;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
