package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class FactoryDao {

	protected static FactoryDao instancia;
	public static FactoryDao getFactoryInstance(){
		if(instancia == null){
			Configuracion config = Configuracion.getConfiguracion();
			if(config.getDbEngine().equals("MySQL"));
				instancia = FactoryDaoMySQL.getFactoryInstance();
		}
		return instancia;
	}

	public abstract CategoriaDao getNewCategoriaDao();

	public abstract DetallepedidoDao getNewDetallepedidoDao();

	public abstract PedidoDao getNewPedidoDao();

	public abstract ProductoDao getNewProductoDao();

	public abstract UsuarioDao getNewUsuarioDao();

}

