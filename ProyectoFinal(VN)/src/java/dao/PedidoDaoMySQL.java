package dao;

import dal.Conexion;
import dto.Pedido;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class PedidoDaoMySQL extends PedidoDao {

	@Override
	public int insert(Pedido obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			int id = 0;
			StringBuilder query = new StringBuilder("INSERT INTO pedido VALUES (");
			query.append("`" + obj.getPedidoId() + "`," );
			query.append("`" + obj.getUsuarioId() + "`," );
			query.append("`" + obj.getFecha() + "`," );
			query.append("`" + obj.getTotal() + "` " );
			query.append(")");
			id = objConexion.ejecutarInsert(query.toString());
			if(id == 0)
				throw new Exception("El registro no pudo ser insertado");
			objConexion.desconectar();
			return id;
	}
	@Override
	public void update(Pedido obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			StringBuilder query = new StringBuilder("UPDATE pedido SET ");
			query.append("usuarioId = `" + obj.getUsuarioId() + "`,");
			query.append("fecha = `" + obj.getFecha() + "`,");
			query.append("total = `" + obj.getTotal() + "` ");
			query.append("WHERE pedidoId = `" + obj.getPedidoId() + "`");
			int upd = objConexion.ejecutarSimple(query.toString());
			if(upd == 0)
				throw new Exception("El registro no pudo ser actualizado");

			objConexion.desconectar();
	}
	@Override
	public void delete(int id){
		Conexion objConexion = Conexion.getOrCreate();
		StringBuffer query = new StringBuffer("DELETE FROM pedido ");
		query.append("WHERE pedidoId = " + id);
		objConexion.ejecutarSimple(query.toString());
		objConexion.desconectar();
	}

	@Override
	public Pedido get(int id){
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM pedido WHERE pedidoId = " + id;
			ResultSet objResultSet = objConexion.ejecutar(query);
			if(objResultSet.next()){
				Pedido obj = new Pedido();
				int _pedidoId = objResultSet.getInt("pedidoId");
				obj.setPedidoId(_pedidoId);
				
				int _usuarioId = objResultSet.getInt("usuarioId");
				obj.setUsuarioId(_usuarioId);
				
				String _fecha = objResultSet.getString("fecha");
				obj.setFecha(_fecha);
				
				double _total = objResultSet.getDouble("total");
				obj.setTotal(_total);
				
				return obj;
			}
		}catch(Exception ex){
			;
		}
		return null;
	}

	@Override
	public ArrayList<Pedido> getList(){
		ArrayList<Pedido>  registros = new ArrayList<Pedido>();
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM pedido";
			ResultSet objResultSet = objConexion.ejecutar(query);
			while(objResultSet.next()){
				Pedido obj = new Pedido();
				int _pedidoId = objResultSet.getInt("pedidoId");
				obj.setPedidoId(_pedidoId);
				
				int _usuarioId = objResultSet.getInt("usuarioId");
				obj.setUsuarioId(_usuarioId);
				
				String _fecha = objResultSet.getString("fecha");
				obj.setFecha(_fecha);
				
				double _total = objResultSet.getDouble("total");
				obj.setTotal(_total);
				
				registros.add(obj);
			}
		}catch(Exception ex){
			;
		}
		return registros;
	}

}

