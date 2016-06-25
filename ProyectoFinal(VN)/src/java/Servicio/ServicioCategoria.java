/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import dao.CategoriaDao;
import dto.Categoria;
import factory.FactoryDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kevin
 */
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
