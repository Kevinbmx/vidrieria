/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author kevin
 */
public class ListaContenidos {

    private Pedido pedido;
    private List<Detallepedido> detalle;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Detallepedido> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detallepedido> detalle) {
        this.detalle = detalle;
    }

    
}
