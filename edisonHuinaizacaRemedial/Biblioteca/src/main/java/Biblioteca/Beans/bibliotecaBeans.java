package biblioteca.Beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import biblioteca.Modelo.Autor;
import biblioteca.Modelo.Libro;
import biblioteca.Negocio.bibliotecaON;


@Named
@SessionScoped
public class bibliotecaBeans implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	
	@Inject
	private bibliotecaON bibliotecaON;
	private String nombreLibro;
	private String NombreAutor;
	private int numerosDisponible;
	private String categoria;
	private String estado;
	private Libro libro;
	private List<Libro> librosLista;
	
	
	


	public String getNombreLibro() {
		return nombreLibro;
	}


	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}


	public String getNombreAutor() {
		return NombreAutor;
	}


	public void setNombreAutor(String nombreAutor) {
		NombreAutor = nombreAutor;
	}


	public int getNumerosDisponible() {
		return numerosDisponible;
	}


	public void setNumerosDisponible(int numerosDisponible) {
		this.numerosDisponible = numerosDisponible;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public List<Libro> getLibrosLista() {
		return librosLista;
	}


	public void setLibrosLista(List<Libro> librosLista) {
		this.librosLista = librosLista;
	}
	
	public String IngresarLibro() throws Exception {
		Libro dato =new Libro();
		Autor autor =new Autor();
		autor.setNombre(NombreAutor);
		bibliotecaON.ingresarAutor(autor);
		dato.setAutor(bibliotecaON.busquedaAutor(NombreAutor));
		dato.setCategoria(categoria);
		dato.setEstado("disponible");
		dato.setNombre(nombreLibro);
		dato.setNumero(numerosDisponible);
		if (bibliotecaON.ingreso(dato)!=true) {
			 FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Datos ingresados exitosamente","OK");
				FacesContext.getCurrentInstance().addMessage(null, msm);		
		return "";
		}else {
			FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error ingreso","OK");
			FacesContext.getCurrentInstance().addMessage(null, msm);	
			return"";
		}
	}
public String ListarDatos() {
	    librosLista=bibliotecaON.listarLibros();
		return"";
	}
}
