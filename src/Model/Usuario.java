package Model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.rmi.*;

/**
 *
 * @author luisluna
 */
public class Usuario implements Serializable, UsuarioInt {

    /*
     * Atributos de la clase
     */
    private String nombre;
    private String usuario;
    private String contrasena;
    private String direccion;
    private String email;
    public LinkedHashSet<ProductoInt> productosComprados;
    //private LinkedHashSet<ProductoInt> productosEnVenta;
    private double saldo;

    private boolean enLinea = false;

    /*
     * Constructor
     * Al crear un objeto de esta clase se tiene que especificar un nombre, usuario y contra
     */
    public Usuario(String nombre, String usuario, String contrasena, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        productosComprados = new LinkedHashSet<>();
        //productosEnVenta = new LinkedHashSet<>();
        saldo = 10000.00;
        this.email = email;

    }

    /*
     * Getters
     * Metodos para consultar valores de los atributos
     */
    public String getNombre() {
        return this.nombre;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public LinkedHashSet<ProductoInt> getProductosComprados() {
        return this.productosComprados;
    }

    public LinkedHashSet<ProductoInt> getProductosEnVenta() {
        return null;
    }

    public boolean getEnLinea() {
        return this.enLinea;
    }

    /*
     * Setters
     * Metodos para cambiar valores de los atributos
     */
    public void setSaldo(double nuevoSaldo) {
        if (nuevoSaldo >= 0.0) {
            this.saldo = nuevoSaldo;

        }
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contra) {
        this.contrasena = contra;
    }

    public void setEnLinea(boolean online) {
        this.enLinea = online;
    }

    public void agregarProductosComprados(ProductoInt p) {
        this.productosComprados.add(p);
    }

    public void agregarProductosEnVenta(ProductoInt p) {
        //this.productosEnVenta.add(p);
    }

    /*
     * Metodos de clase
     * 
     */
    @Override
    public void comprar(ProductoInt producto) throws RemoteException {
        if (producto.getPrecio() <= this.getSaldo()) {
            //Comprar el producto
            producto.setDueno(this);
            this.productosComprados.add(producto);
            // Restar el saldo
            this.setSaldo(getSaldo() - producto.getPrecio());
        }

    }

    public void vender(ProductoInt producto) throws RemoteException {
        //Buscar producto en productosComprados para eliminarlo
        System.out.println("Voy a eliminar un prodcuto del usuario");
        
        productosComprados.remove(producto);
        
        this.setSaldo(getSaldo() + producto.getPrecio());
    }

}
