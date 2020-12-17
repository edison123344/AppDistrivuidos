/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.Banco.beans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

public class AdministradorBEAN {

   // private List<Solicitud> listaSolicitudes;
    private String textoBuscar;
    private double saldo;
    private String respuesta;
    private String resCedula;
    private String resTipo;
    private List<String> opciones;
    private String estado = "";

    public AdministradorBEAN() {
    }

    

    @PostConstruct
    public void init() {
        opciones = Arrays.asList("CAMBIAR ESTADO", "APROBAR", "NEGAR");
        estado = "CAMBIAR ESTADO";
    
        textoBuscar = "";
        saldo = 0;
    }

    public String cambiarEstado() {
       
        return "";
    }

    public String openPdf() {
       
        return "";
    }

    public String formaRes(String r) {
      
        return "";
    }
}
