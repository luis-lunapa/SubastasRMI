/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.rmi.*;

/**
 *
 * @author luisluna
 */
public interface ProductoInt extends Remote {

    public Image getImagen() throws RemoteException;

    public double getPrecio() throws RemoteException;

    public String getDescripcion() throws RemoteException;

    public String getNombre() throws RemoteException;

    public UsuarioInt getDueno() throws RemoteException;

    public void setImagen(File f) throws IOException, RemoteException;

    public void setPrecio(double precio) throws Exception, RemoteException;

    public void setDescripcion(String descripcion) throws RemoteException;

    public void setDueno(Usuario dueno) throws RemoteException;

}
