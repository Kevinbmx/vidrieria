package dao;

import dal.Conexion;
import dto.DetallePedido;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DetallepedidoDaoMySQL extends DetallepedidoDao {

    @Override
    public int insert(DetallePedido obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO detallepedido(productoId,cantidad,precio,subtotal) VALUES (");
        query.append(obj.getPedidoId()).append(",");
        query.append(obj.getProductoId()).append(",");
        query.append(obj.getCantidad()).append(",");
        query.append(obj.getPrecio()).append(",");
        query.append(obj.getSubtotal());
        query.append(")");
        objConexion.ejecutarInsert(query.toString());

        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(DetallePedido obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE detallepedido SET ");
        query.append("productoId = " + obj.getProductoId() + ",");
        query.append("cantidad = " + obj.getCantidad() + ",");
        query.append("precio = " + obj.getPrecio() + ",");
        query.append("subtotal = " + obj.getSubtotal() + " ");
        query.append("WHERE pedidoId = " + obj.getPedidoId());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM detallepedido ");
        query.append("WHERE pedidoId = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public DetallePedido get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM detallepedido WHERE pedidoId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                DetallePedido obj = new DetallePedido();
                int _pedidoId = objResultSet.getInt("pedidoId");
                obj.setPedidoId(_pedidoId);

                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                int _cantidad = objResultSet.getInt("cantidad");
                obj.setCantidad(_cantidad);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                double _subtotal = objResultSet.getDouble("subtotal");
                obj.setSubtotal(_subtotal);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<DetallePedido> getList() {
        ArrayList<DetallePedido> registros = new ArrayList<DetallePedido>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM detallepedido";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                DetallePedido obj = new DetallePedido();
                int _pedidoId = objResultSet.getInt("pedidoId");
                obj.setPedidoId(_pedidoId);

                int _productoId = objResultSet.getInt("productoId");
                obj.setProductoId(_productoId);

                int _cantidad = objResultSet.getInt("cantidad");
                obj.setCantidad(_cantidad);

                double _precio = objResultSet.getDouble("precio");
                obj.setPrecio(_precio);

                double _subtotal = objResultSet.getDouble("subtotal");
                obj.setSubtotal(_subtotal);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

}
