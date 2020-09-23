package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author luisluna
 */
public class Oferta implements Serializable {
    public final ProductoInt producto;
    public final UsuarioInt ofertante;
    public final double oferta;
    public final Date fecha;
    
    public Oferta(ProductoInt producto, UsuarioInt ofertante, double oferta) {
        this.producto = producto;
        this.ofertante = ofertante;
        this.oferta = oferta;
        this.fecha = new Date();
    }

}
