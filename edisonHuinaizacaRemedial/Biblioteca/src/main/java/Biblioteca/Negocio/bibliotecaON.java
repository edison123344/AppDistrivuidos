package biblioteca.Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import biblioteca.DAO.AutorDAO;
import biblioteca.DAO.LibroDAO;
import biblioteca.Modelo.Autor;
import biblioteca.Modelo.Libro;
@Stateless
public class bibliotecaON {
	@Inject
    private LibroDAO libroDAO;
	
	@Inject
	private AutorDAO autorDAO;

public List<Libro> listarLibros() {
	return libroDAO.listaProducto();
}
public List<Libro> listarLibrosCategoria(String Categoria) {
	return libroDAO.listaCategoria(Categoria);
}
public boolean ingreso(Libro libro) throws Exception {
	return libroDAO.CrearLibro(libro);
}
public Autor busquedaAutor(String id){
	return autorDAO.busqueda(id);
}
public void ingresarAutor(Autor autor) throws Exception {
	autorDAO.CrearAutor(autor);
}
public Libro busqueda(String id) {
	return libroDAO.busqueda(id);
}
public void reserva(Libro libro) throws Exception {
	libroDAO.actualizar(libro);
}
}
