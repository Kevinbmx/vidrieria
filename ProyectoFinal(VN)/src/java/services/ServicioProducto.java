package services;

import dao.ProductoDao;
import dto.Producto;
import factory.FactoryDao;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/producto")
public class ServicioProducto {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProductos() throws Exception {
        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
        List<Producto> productos = dao.getList();
        return productos;
    }

    @GET
    @Path("/categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProducto(@PathParam("id") int categoriaId) throws Exception {
        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
        List<Producto> productos = dao.getCategory(categoriaId);
        return productos;
    }

    @GET
    @Path("/carrito")
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
