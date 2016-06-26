package services;

import dao.UsuarioDao;
import dto.Usuario;
import factory.FactoryDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
                + "'nombreUsuario' : '" + usuario.getNombreUsuario() + "',"
                + "'direccion' : '" + usuario.getDireccion()
                + "'}";

        return new SimpleResponse(true, jsonObject);

    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleResponse insertarUsuario(Usuario objUsuario) {
        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
        try {
            dao.insert(objUsuario);
        } catch (Exception ex) {
            return new SimpleResponse(false, "Error al insertar el usuario");
        }
        return new SimpleResponse();
    }
}
