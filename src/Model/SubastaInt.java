/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.rmi.*;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author luisluna
 */
public interface SubastaInt extends Remote {

    public double getPrecio() throws RemoteException;

    public ProductoInt getProducto() throws RemoteException;

    public Date getInicioSubasta() throws RemoteException;

    public Date getFinSubasta() throws RemoteException;

    public LinkedList<Oferta> getOfertas() throws RemoteException;

    public void terminarSubasta() throws RemoteException;

    public boolean ofertar(UsuarioInt usuario, double oferta) throws Exception, RemoteException;
    
    public double getUltimaOferta() throws RemoteException;
    
    public void agregarOferta(Oferta o) throws RemoteException;

}
