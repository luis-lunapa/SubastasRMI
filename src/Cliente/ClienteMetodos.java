/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.rmi.*;

/**
 *
 * @author luisluna
 */
public interface ClienteMetodos extends Remote {
     public void actualizarVentana() throws RemoteException;
     public void registrarConServidor() throws RemoteException;
    
}
