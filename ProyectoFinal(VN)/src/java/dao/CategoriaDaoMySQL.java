package dao;

import dal.Conexion;
import dto.Categoria;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class CategoriaDaoMySQL extends CategoriaDao {

	@Override
	public int insert(Categoria obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			int id = 0;
			StringBuilder query = new StringBuilder("INSERT INTO categoria (nombreCategoria) VALUES (");
//			query.append("`" + obj.getCategoriaId() + "`," );
			query.append("'" + obj.getNombreCategoria() + "'" );
			query.append(")");
			id = objConexion.ejecutarInsert(query.toString());
			if(id == 0)
				throw new Exception("El registro no pudo ser insertado");
			objConexion.desconectar();
			return id;
	}
	@Override
	public void update(Categoria obj) throws Exception {
		Conexion objConexion = Conexion.getOrCreate();

			StringBuilder query = new StringBuilder("UPDATE categoria SET ");
			query.append("nombreCategoria = '" + obj.getNombreCategoria() + "' ");
			query.append("WHERE categoriaId = '" + obj.getCategoriaId() + "'");
			int upd = objConexion.ejecutarSimple(query.toString());
			if(upd == 0)
				throw new Exception("El registro no pudo ser actualizado");

			objConexion.desconectar();
	}
	@Override
	public void delete(int id){
		Conexion objConexion = Conexion.getOrCreate();
		StringBuffer query = new StringBuffer("DELETE FROM categoria ");
		query.append("WHERE categoriaId = " + id);
		objConexion.ejecutarSimple(query.toString());
		objConexion.desconectar();
	}

	@Override
	public Categoria get(int id){
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM categoria WHERE categoriaId = " + id;
			ResultSet objResultSet = objConexion.ejecutar(query);
			if(objResultSet.next()){
				Categoria obj = new Categoria();
				int _categoriaId = objResultSet.getInt("categoriaId");
				obj.setCategoriaId(_categoriaId);
				
				String _nombreCategoria = objResultSet.getString("nombreCategoria");
				obj.setNombreCategoria(_nombreCategoria);
				
				return obj;
			}
		}catch(Exception ex){
			;
		}
		return null;
	}

	@Override
	public ArrayList<Categoria> getList(){
		ArrayList<Categoria>  registros = new ArrayList<Categoria>();
		try{
			Conexion objConexion = Conexion.getOrCreate();
			String query = "SELECT * FROM categoria";
			ResultSet objResultSet = objConexion.ejecutar(query);
			while(objResultSet.next()){
				Categoria obj = new Categoria();
				int _categoriaId = objResultSet.getInt("categoriaId");
				obj.setCategoriaId(_categoriaId);
				
				String _nombreCategoria = objResultSet.getString("nombreCategoria");
				obj.setNombreCategoria(_nombreCategoria);
				
				registros.add(obj);
			}
		}catch(Exception ex){
			;
		}
		return registros;
	}

}

