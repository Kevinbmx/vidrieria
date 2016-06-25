package dao;

import dal.Conexion;
import dto.Usuario;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class UsuarioDaoMySQL extends UsuarioDao {

    @Override
    public int insert(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO usuario(nombreCompleto,nombreUsuario,password,direccion) VALUE (");
//			query.append("'" + obj.getUsuarioId() + "'," );
        query.append("'" + obj.getNombreCompleto() + "',");
        query.append("'" + obj.getNombreUsuario() + "',");
        query.append("'" + obj.getPassword() + "',");
        query.append("'" + obj.getDireccion() + "'");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE usuario SET ");
        query.append("nombreCompleto = '" + obj.getNombreCompleto() + "',");
        query.append("nombreUsuario = '" + obj.getNombreUsuario() + "',");
        query.append("password = '" + obj.getPassword() + "',");
        query.append("direccion = '" + obj.getDireccion() + "' ");
        query.append("WHERE usuarioId = '" + obj.getUsuarioId() + "'");
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM usuario ");
        query.append("WHERE usuarioId = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Usuario get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario WHERE usuarioId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _usuarioId = objResultSet.getInt("usuarioId");
                obj.setUsuarioId(_usuarioId);

                String _nombreCompleto = objResultSet.getString("nombreCompleto");
                obj.setNombreCompleto(_nombreCompleto);

                String _nombreUsuario = objResultSet.getString("nombreUsuario");
                obj.setNombreUsuario(_nombreUsuario);

                String _password = objResultSet.getString("password");
                obj.setPassword(_password);

                String _direccion = objResultSet.getString("direccion");
                obj.setDireccion(_direccion);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> getList() {
        ArrayList<Usuario> registros = new ArrayList<Usuario>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _usuarioId = objResultSet.getInt("usuarioId");
                obj.setUsuarioId(_usuarioId);

                String _nombreCompleto = objResultSet.getString("nombreCompleto");
                obj.setNombreCompleto(_nombreCompleto);

                String _nombreUsuario = objResultSet.getString("nombreUsuario");
                obj.setNombreUsuario(_nombreUsuario);

                String _password = objResultSet.getString("password");
                obj.setPassword(_password);

                String _direccion = objResultSet.getString("direccion");
                obj.setDireccion(_direccion);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

    @Override
    public Usuario getByUserName(String userName) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario WHERE nombreUsuario = '" + userName + "'";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuario obj = getUsuarioFromResultSet(objResultSet);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    private Usuario getUsuarioFromResultSet(ResultSet objResultSet) throws SQLException {
        Usuario obj = new Usuario();
        int _usuarioId = objResultSet.getInt("usuarioId");
        obj.setUsuarioId(_usuarioId);

        String _nombre = objResultSet.getString("nombreCompleto");
        obj.setNombreCompleto(_nombre);

        String _userName = objResultSet.getString("nombreUsuario");
        obj.setNombreUsuario(_userName);

        String _password = objResultSet.getString("password");
        obj.setPassword(_password);

        String _direccion = objResultSet.getString("direccion");
        obj.setDireccion(_direccion);

        return obj;
    }

}
