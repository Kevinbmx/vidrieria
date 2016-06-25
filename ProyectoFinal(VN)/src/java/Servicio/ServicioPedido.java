/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import dao.DetallepedidoDao;
import dao.PedidoDao;
import dto.Detallepedido;
import dto.ListaContenidos;
import factory.FactoryDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kevin
 */
@Path("/pedido")
public class ServicioPedido {

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleResponse insertarPedido(ListaContenidos pedidoCompleto) {

        try {
            PedidoDao daoPedido = FactoryDao.getFactoryInstance().getNewPedidoDao();
            int pedidoId = daoPedido.insert(pedidoCompleto.getPedido());

            DetallepedidoDao daoDetalle = FactoryDao.getFactoryInstance().getNewDetallepedidoDao();
            for (Detallepedido detalle : pedidoCompleto.getDetalle()) {
                detalle.setPedidoId(pedidoId);
                daoDetalle.insert(detalle);
            }

        } catch (Exception ex) {
            return new SimpleResponse(false, "Error al insertar el Pedido");
        }
        return new SimpleResponse();
    }

}
