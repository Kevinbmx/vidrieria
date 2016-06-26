package services;

import dao.CategoriaDao;
import dto.Categoria;
import factory.FactoryDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categoria")
public class ServicioCategoria {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Categoria> getCategorias() throws Exception {
        CategoriaDao dao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
        List<Categoria> categorias = dao.getList();
        return categorias;
    }

}
