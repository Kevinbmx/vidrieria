/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import dao.UsuarioDao;
import dto.Usuario;
import factory.FactoryDao;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kevin
 */
@Path("/usuario")
public class ServicioUsuario {

    @POST
    @Path("/autenticacion")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public SimpleResponse autenticar(@FormParam("username") String username,
            @FormParam("password") String password) {
        FactoryDao factory = FactoryDao.getFactoryInstance();
        UsuarioDao dao = factory.getNewUsuarioDao();

        Usuario usuario = dao.getByUserName(username);
        if (usuario == null) {
            return new SimpleResponse(false, "Nombre de usuario o contraseña incorrecta");
        }

        if (!usuario.getPassword().equals(password)) {
            return new SimpleResponse(false, "Nombre de usuario o contraseña incorrecta");
        }

        String jsonObject = "{"
                + "'usuarioId' : " + usuario.getUsuarioId() + ","
                + "'nombreCompleto' : '" + usuario.getNombreCompleto() + "',"
                + "'nombreUsuario' : " + usuario.getNombreUsuario()+"',"
                + "'direccion' : "+usuario.getDireccion()
                + "}";

        return new SimpleResponse(true, jsonObject);

    }

}
