package services;

import dao.DetallepedidoDao;
import dao.PedidoDao;
import dao.ProductoDao;
import dao.UsuarioDao;
import dto.DetallePedido;
import dto.Pedido;
import dto.Producto;
import factory.FactoryDao;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/detallePedido")
public class ServicioDetallePedido {

    @Path("/insertardetallepedido")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleResponse insertardetallePedido(DetallePedido detallepedido) {
        DetallepedidoDao dao = FactoryDao.getFactoryInstance().getNewDetallepedidoDao();
        try {
            dao.insert(detallepedido);
        } catch (Exception ex) {
            return new SimpleResponse(false, "Error al insertar el pedido");
        }
        return new SimpleResponse();
    }

    @GET
    @Path("/detalle")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProductoCarrito(@QueryParam("ids") String ids) {
        List<Producto> result = null;

        FactoryDao factory = FactoryDao.getFactoryInstance();
        ProductoDao objDao = factory.getNewProductoDao();
        try {
            result = objDao.getListFromIds(ids);
        } catch (Exception e) {
            result = new LinkedList<>();
        }

        return result;
    }
}
