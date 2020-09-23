
package Server;
import Cliente.*;
import java.rmi.*;
import Model.*;
import Cliente.View.*;

import java.util.LinkedList;
/**
 *
 * @author luisluna
 */
public interface ServidorMetodos extends Remote {
    
    
    public void registrarUsuario (Usuario u) throws RemoteException;
    public UsuarioInt inciarSesion (String user, String pass) throws RemoteException;
    public void cerrarSesion (String user) throws RemoteException;
    
    
    public void productos () throws RemoteException;
    public LinkedList<UsuarioInt> getUsuarios() throws RemoteException;
    public LinkedList<SubastaInt> subastas () throws RemoteException;
    public void crearSubastas (SubastaInt sub) throws RemoteException;
    
    public void agregarOfertas(Oferta o, SubastaInt s) throws RemoteException;
    
    public void decirHola() throws RemoteException;
    
    public void registrarCliente(ClienteMetodos cliente) throws RemoteException;
    public void eliminarCliente(ClienteMetodos cliente) throws RemoteException;
    public void mandarActualizacionAClientes() throws RemoteException;
    
    public void comprarProducto(ProductoInt producto, UsuarioInt comprador) throws RemoteException;
    public void vender (ProductoInt producto, UsuarioInt vendedor) throws RemoteException;
    
    public void eliminarSubasta(SubastaInt subasta) throws RemoteException;
    
    
        
    
    
    
}
