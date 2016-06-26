package services;

import dao.DetallepedidoDao;
import dao.PedidoDao;
import dto.ContenedorPedido;
import dto.DetallePedido;
import factory.FactoryDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pedido")
public class ServicioPedido {

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleResponse insertarPedido(ContenedorPedido pedidoCompleto) {

        try {
            PedidoDao daoPedido = FactoryDao.getFactoryInstance().getNewPedidoDao();
            int pedidoId = daoPedido.insert(pedidoCompleto.getPedido());

            DetallepedidoDao daoDetalle = FactoryDao.getFactoryInstance().getNewDetallepedidoDao();
            for (DetallePedido detalle : pedidoCompleto.getDetalle()) {
                detalle.setPedidoId(pedidoId);
                daoDetalle.insert(detalle);
            }

        } catch (Exception ex) {
            return new SimpleResponse(false, "Error al insertar el Pedido");
        }
        return new SimpleResponse();
    }

}
