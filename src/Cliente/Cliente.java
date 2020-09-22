/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Server.ServidorMetodos;
import Model.*;
import Cliente.View.*;
import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisluna
 */
public class Cliente implements Remote, Serializable, ClienteMetodos {

    public static final String APPNAME = "Subastas UBay";
    public static ServidorMetodos stub;
    public static final SimpleDateFormat SDFNUM = new SimpleDateFormat("dd/MM/yyyy");

    public static UsuarioInt usuario;

    public static Registry reg;

    private static ClienteMetodos stubCliente;
    
    public static VentanaPrincipal vp = null;
    
    public static final String direccion = "127.0.0.1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (System.getSecurityManager() == null) {
            //System.setSecurityManager(new SecurityManager());
        }
        // TODO code application logic here
        Cliente c1 = new Cliente();

       
        
        String host = "rmi://" + Cliente.direccion + ":2345/UBay";
        //System.setSecurityManager(new SecurityManager());
        try {
            stub = (ServidorMetodos) Naming.lookup(host);

            Cliente.reg = LocateRegistry.getRegistry(Cliente.direccion, 2345);
                 

            //Registrar cliente para callback
            Cliente.stubCliente = (ClienteMetodos) UnicastRemoteObject.exportObject(c1, 0);
            Cliente.stub.registrarCliente(Cliente.stubCliente);

            //c1.registrarConServidor();
            Login l1 = new Login();
            //l1.cliente = c1;
            l1.setVisible(true);

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

        /*
         * Codigo para mostrar la venta (Cliente)
         *
         */
    }

    @Override
    public void actualizarVentana() {
        System.out.print("Actualizando Ventana");
        System.out.println(this.vp);
        
        if (this.vp != null) {
            this.vp.actualizarTodo();
        }
    }

    @Override
    public void registrarConServidor() throws RemoteException {
        Cliente.stub.registrarCliente(this);
    }

    public static void exit() {

        System.out.println("Unbinding user");
        try {
            Cliente.printListBinded();
            Cliente.stub.cerrarSesion(Cliente.usuario.getUsuario());

            System.out.println("------------------------");
            Cliente.printListBinded();

            Cliente.stub.eliminarCliente(Cliente.stubCliente);

        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Utilidades.showMessage("Vuelve Pronto !");
        System.exit(0);

    }

    public static void printListBinded() throws Exception {

        for (String s : Cliente.reg.list()) {
            System.out.println(s);
        }
    }
    
  
  
}
