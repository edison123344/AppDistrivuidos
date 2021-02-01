package Proyecto.BancoPrctica.Beans;


import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.primefaces.event.FileUploadEvent;




@Named
@SessionScoped

@ManagedBean

public class BalidarPolizaBean implements Serializable{
	/**
	 * parte por acabar debido a que no funciona los metodos
	 */
	private static final long serialVersionUID = 1L;
	 private UploadedFile uploadedFile;
	    public void handleFileUpload(FileUploadEvent event) {  
	        FacesMessage messages = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");  
	        FacesContext.getCurrentInstance().addMessage(null, messages);  
	    }
	    public void submit() throws IOException {
	       // String fileName = FilenameUtils.getName(uploadedFile.getName());
	        //String contentType = uploadedFile.getContentType();
	        //byte[] bytes = uploadedFile.getBytes();

	        // Now you can save bytes in DB (and also content type?)

	        FacesMessage messages = new FacesMessage("Ok", "Fichero " + uploadedFile.getName() + " subido correctamente.");  
	        FacesContext.getCurrentInstance().addMessage(null, messages);  
	    }

	    public UploadedFile getUploadedFile() {
	        return uploadedFile;
	    }

	    public void setUploadedFile(UploadedFile uploadedFile) {
	        this.uploadedFile = uploadedFile;
	    }}