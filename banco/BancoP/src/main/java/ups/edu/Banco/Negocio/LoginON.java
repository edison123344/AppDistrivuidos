package ups.edu.Banco.Negocio;

import ups.edu.Banco.DAO.UsuarioDAO;
import ups.edu.Banco.Modelo.Usuario;

public class LoginON {

	private UsuarioDAO usuario;
	
public Usuario login(String email ,String password) throws Exception {
	    Usuario usr=usuario.loginUsuario(email, password);
	 // if(UsuarioDAO.read(usuario.)!=null)
	      return usr;
}
public Usuario registroIngreso() {
	return null;
}
}
