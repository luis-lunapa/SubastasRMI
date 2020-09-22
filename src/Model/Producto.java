package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author luisluna
 */
public class Producto implements Serializable, ProductoInt{

    /*
     * Atributos de la clase
     */
    private final String nombre;
    private String descripcion;
    private UsuarioInt dueno;
    private double precio;
    private Image imagen;

    /*
     * Constructor
     * Al crear un objeto de esta clase se tiene que especificar un nombre, usuario y contra
     */
    public Producto(String nombre, UsuarioInt dueno, double precio) {
        this.nombre = nombre;
        this.dueno = dueno;
        this.precio = precio;
        imagen = null;

    }

    /*
     * Getters
     * Metodos para consultar valores de los atributos
     */
    public Image getImagen() {
        return this.imagen;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public UsuarioInt getDueno() {
        return this.dueno;
    }

    /*
     * Setters
     * Metodos para cambiar valores de los atributos
     */
    public void setImagen(File f) throws IOException {
        this.imagen = ImageIO.read(f);
        
    }

    
    public void setPrecio(double precio) throws Exception {
        if (precio >= 0.0) {
            this.precio = precio;
        } else {
            throw new Exception("El precio no puede ser negativo");
        }
        
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        
    }
    
    public void setDueno (Usuario dueno) {
        this.dueno = dueno;
    }
    
    @Override
    public boolean equals(Object o) {
        try {
            ProductoInt p = (ProductoInt) o;
            if (p.getNombre().equals(this.getNombre())) {
                return true;
            } 
        } catch (RemoteException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }



}
