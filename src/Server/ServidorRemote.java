/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.ProductoInt;
import Model.UsuarioInt;
import javax.ejb.Remote;

/**
 *
 * @author luisluna
 */
@Remote
public interface ServidorRemote {

    void agregarProductoEnVenta(ProductoInt producto);
    
}
