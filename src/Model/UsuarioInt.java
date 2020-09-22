/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.rmi.*;
import java.util.LinkedHashSet;


/**
 *
 * @author luisluna
 */
public interface UsuarioInt extends Remote {
    
    /*
     * Getters
     * Metodos para consultar valores de los atributos
     */
    
    public String getNombre() throws RemoteException;
    public String getUsuario() throws RemoteException;
    public String getContrasena() throws RemoteException;
    public String getDireccion() throws RemoteException;
    public String getEmail() throws RemoteException;
    public double getSaldo() throws RemoteException;
    public LinkedHashSet<ProductoInt> getProductosComprados () throws RemoteException;
    public LinkedHashSet<ProductoInt> getProductosEnVenta () throws RemoteException;
    public boolean getEnLinea() throws RemoteException;
    
     /*
     * Setters
     * Metodos para cambiar valores de los atributos
     */
    
    public void setSaldo(double nuevoSaldo) throws RemoteException;
    public void setDireccion (String direccion) throws RemoteException;
    public void setEmail(String email) throws RemoteException;
    public void setUsuario(String usuario) throws RemoteException;
    public void setContrasena(String contra) throws RemoteException;
    public void setEnLinea(boolean online) throws RemoteException;
    
    public void agregarProductosComprados(ProductoInt p) throws RemoteException;
    public void agregarProductosEnVenta(ProductoInt p) throws RemoteException;
    
    /*
     * Metodos de clase
     * 
     */
    public void comprar(ProductoInt producto) throws RemoteException;
    public void vender (ProductoInt producto) throws RemoteException; 
    
    
    
}
