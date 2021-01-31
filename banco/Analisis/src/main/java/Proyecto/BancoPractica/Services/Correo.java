package Proyecto.BancoPractica.Services;


import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Proyecto.BancoPractica.Modelo.Usuario;
@Stateless
public class Correo {
public String correo(Usuario usuario) {
	
	 Properties propiedad = new Properties();
     propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
     propiedad.setProperty("mail.smtp.starttls.enable", "true");
     propiedad.setProperty("mail.smtp.port", "587");
     propiedad.setProperty("mail.smtp.auth", "true");
     
     Session sesion = Session.getDefaultInstance(propiedad);
     
     String correoEnvia = "edisonezequiel1995@gmail.com";
     String contrasena = "cAwxyx-xawny3-dunkam";
     String destinatario = usuario.getPersona().getCorreo();
     String asunto ="Clave Cuenta";
     String mensaje ="Su cuenta a sido creada su clave es "+usuario.getPassword()+"Su nombre es:"+usuario.getPersona().getNombre();
     
     
     MimeMessage mail = new MimeMessage(sesion);
     
     try {
         mail.setFrom(new InternetAddress (correoEnvia));
         mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
         mail.setSubject(asunto);
         mail.setText(mensaje);
         
         
         Transport transporte = sesion.getTransport("smtp");
         transporte.connect(correoEnvia,contrasena);
         transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
         transporte.close();
         
         return  "Correo enviado";
         
         
         
         
         
     } catch (AddressException ex) {
         return ex.getMessage();
     } catch (MessagingException ex) {
    	 return ex.getMessage();
     }

}
public String correoGeneral(String correo , String txt) {
	
	 Properties propiedad = new Properties();
    propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
    propiedad.setProperty("mail.smtp.starttls.enable", "true");
    propiedad.setProperty("mail.smtp.port", "587");
    propiedad.setProperty("mail.smtp.auth", "true");
    
    Session sesion = Session.getDefaultInstance(propiedad);
    
    String correoEnvia = "edisonezequiel1995@gmail.com";
    String contrasena = "cAwxyx-xawny3-dunkam";
    String destinatario = correo;
    String asunto ="Clave Cuenta";
    String mensaje =txt;
    
    
    MimeMessage mail = new MimeMessage(sesion);
    
    try {
        mail.setFrom(new InternetAddress (correoEnvia));
        mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mail.setSubject(asunto);
        mail.setText(mensaje);
        
        
        Transport transporte = sesion.getTransport("smtp");
        transporte.connect(correoEnvia,contrasena);
        transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
        transporte.close();
        
        return  "Correo enviado";
        
        
        
        
        
    } catch (AddressException ex) {
        return ex.getMessage();
    } catch (MessagingException ex) {
   	 return ex.getMessage();
    }

}
}
