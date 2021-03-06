package dao;

import dal.Conexion;
import dto.Producto;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ProductoDaoMySQL extends ProductoDao {

    @Override
    public int insert(Producto obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO producto VALUES (");
        query.append("'").append(obj.getProductoId()).append("',");
        query.append("'").append(obj.getNombre()).append("',");
        query.append("'").append(obj.getDescripcion()).append("',");
        query.append(obj.getPrecio()).append(",");
        query.append(obj.getCategoriaId()).append(",'");
        query.append(obj.getImagen());
        query.append("')");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Producto obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE producto SET ");
        query.append("nombre = '").append(obj.getNombre()).append("',");
        query.append("descripcion = '").append(obj.getDescripcion()).append("',");
        query.append("precio = ").append(obj.getPrecio()).append(",");
        query.append("categoriaId = ").append(obj.getCategoriaId());
        query.append("imagen = '").append(obj.getImagen()).append("',");;
        query.append(" WHERE productoId = ").append(obj.getProductoId());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuilder query = new StringBuilder("DELETE FROM producto ");
        query.append("WHERE productoId = ").append(id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Producto get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM producto WHERE productoId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Producto obj = new Producto();
                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                int _categoriaId = objResultSet.getInt("categoriaId");
                obj.setCategoriaId(_categoriaId);

                String _imagen = objResultSet.getString("imagen");
                obj.setImagen(_imagen);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Producto> getList() {
        ArrayList<Producto> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM producto";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Producto obj = new Producto();
                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                int _categoriaId = objResultSet.getInt("categoriaId");
                obj.setCategoriaId(_categoriaId);

                String _imagen = objResultSet.getString("imagen");
                obj.setImagen(_imagen);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

    @Override
    public ArrayList<Producto> getCategory(int id) {
        ArrayList<Producto> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM producto WHERE categoriaId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Producto obj = new Producto();
                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                int _categoriaId = objResultSet.getInt("categoriaId");
                obj.setCategoriaId(_categoriaId);

                String _imagen = objResultSet.getString("imagen");
                obj.setImagen(_imagen);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

    @Override
    public ArrayList<Producto> getListFromIds(String ids) {
        ArrayList<Producto> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM producto WHERE productoId IN (" + ids + ")";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Producto obj = new Producto();
                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                int _categoriaId = objResultSet.getInt("categoriaId");
                obj.setCategoriaId(_categoriaId);

                String _imagen = objResultSet.getString("imagen");
                obj.setImagen(_imagen);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

}
