package Model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author luisluna
 */
public class Subasta implements Serializable, SubastaInt {

    /*
     * Atributos de la clase
     */
    private double precio;
    private ProductoInt producto;
    private final Date inicioSubasta;
    private Date finSubasta;
    private LinkedList<Oferta> ofertas;
    
    private boolean activa = true;

    /*
     * Constructor
     * Al crear un objeto de esta clase se tiene que especificar un nombre, usuario y contra
     */
    public Subasta(double precio, ProductoInt producto, Date finSubasta) {
        this.precio = precio;
        this.producto = producto;
        this.inicioSubasta = new Date();
        this.finSubasta = finSubasta;
        this.ofertas = new LinkedList<>();

    }

    /*
     * Getters
     * Metodos para consultar valores de los atributos
     */
    
    public double getPrecio() {
        return this.precio;
        
    }
    public ProductoInt getProducto() {
        return this.producto;
    }
    
    public Date getInicioSubasta() {
        return this.inicioSubasta;
    }

    public Date getFinSubasta() {
        return this.finSubasta;
    }
    
    public LinkedList<Oferta> getOfertas () {
        return this.ofertas;
    }
    

    /*
     * Setters
     * Metodos para cambiar valores de los atributos
     */
    public void terminarSubasta() throws RemoteException {
        UsuarioInt ganador;
        Oferta o;
        
        this.finSubasta = new Date();
        // Checar quien gano la subasta
        if (!this.ofertas.isEmpty()) {
            o = (Oferta) this.ofertas.getLast();
            
            ganador = o.ofertante;
            ganador.comprar(o.producto);

        }
    }

    /*
     * Metodos de clase
     * 
     */
    @Override
    public boolean ofertar(UsuarioInt usuario, double oferta) throws Exception {
        boolean ofertaPuesta = false;

        Oferta o = new Oferta(this.producto, usuario, oferta);

        if (!this.ofertas.isEmpty()) {
            
            if (oferta > this.ofertas.getLast().oferta) {
                Cliente.Cliente.stub.agregarOfertas(o, this);
                ofertaPuesta = true;
                
            } else {
                
                throw new Exception("La oferta debe ser mayor a la anterior");
            }

        } else {
            Cliente.Cliente.stub.agregarOfertas(o, this);
            ofertaPuesta = true;
        }
        System.err.println("Numero de ofertas en esta subasta: (Subasta.ofertar())" + this.ofertas.size());

        return ofertaPuesta;
    }
    
    public void agregarOferta(Oferta o) {
        this.ofertas.add(o);
    }
    
    @Override
     public double getUltimaOferta() {
         if (!this.ofertas.isEmpty()) {
            return this.ofertas.getLast().oferta;
         } else {
             return -1.0;
         }
     }
    
    

}
