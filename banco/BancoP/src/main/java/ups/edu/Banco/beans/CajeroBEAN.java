/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.Banco.beans;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


public class CajeroBEAN {

  
    private ArrayList<String> listaOpc;
    private String textoBuscar;
    private double saldo;
    private double valorapagar;
    
 //   private List<Credito> listaCreditos;
  //  private List<Amortizacion> listaAmortizacions;
    
    public CajeroBEAN() {
    }

  
    @PostConstruct
    public void init() {
     
    
        textoBuscar = "";
        saldo = 0;
       // listaCreditos= creditosON.listarCreditos();
      //  listaAmortizacions = new ArrayList<>();
        valorapagar = 0;
    }

    
    public void pagarAmortizacionCuota(){
        
      
    }
    
    public void pagarAmortizacion(){
      
       
    }
    
    public void cargarTabla(){
       
    
    }
    
    public void buscaClientes() {
       
       
    }
   
    public void actualizarCliente() {

    }
    
  

}
