/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.Banco.beans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ups.edu.Banco.Negocio.GestorClienteON;



public class ClienteBEAN {

    private String textoBuscar;
    private String cuenta;
    private String cedulaPersona;
   // private List<Transaciones> listaEstadosCta = new ArrayList<Transaciones>();
    private Date fechaInicio;
    private Date fechaFin;
    private String tipo;

    public ClienteBEAN() {
    }

    @Inject
    private GestorClienteON clienteON;


    @PostConstruct
    public void init() {
     
        textoBuscar = "";
        loadResumenCliente();

        action();
    }

    /**
     * Permite obtener el dato que se pasa a traves de la url para poder manejar
     * en los distintos metodos.
     */
    public void action() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String param = request.getParameter("tipo");
        tipo = param;

    }

    /**
     * Guarda el cliente desde la vista consumiendo la logica de negocio
     * existente.
     *
     * @return
     */
    public String guardarCliente() {

        try {
           
            init();
        } catch (Exception ex) {
            Logger.getLogger(ClienteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Busca los clientes por el codigo que se le pase como parametro desde la
     * vista y se pasa al objeto de negocio.
     *
     * @return
     */
    public String buscaClientees() {
        System.out.println(textoBuscar);
        try {
       //     listaClientees = clienteON.listaClienteesCodigo(textoBuscar);
        } catch (Exception ex) {
            Logger.getLogger(ClienteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    public String loadResumenCliente() {
       
      //  for (Cliente cliente : listaClientes) {
     //       loadResumenCuenta(cliente.getCuentaList().get(0).getNumero());
      //  }
        return null;
    }

    /**
     * Metodo de prueba que carga el resumen del cliente recibe como parametro
     * al numero
     *
     * @param numero
     * @return
     */
    public String loadResumenCuenta(String numero) {
      //  listaCuentasClientes = resumenCuentaON.getResumenCuentaCliente(numero);
        return null;
    }

    /**
     * Metodo de prueba que carga el resumen del cliente Carga el estado de la
     * cuenta
     *
     * @return
     */
    public String loadEstadoCta() {
       // listaEstadosCta = resumenCuentaON.getEstadoCtaByMes(tipo, fechaInicio, fechaFin);
        //System.out.println("llega los paametros >>>>> " + tipo + " fehcIni: " + fechaInicio + " fechaFin: " + fechaFin);
       // for (Transaciones t : listaEstadosCta) {
      //      System.out.println("fechas--" + t.getFecha());
       // }
        return null;
    }

}
