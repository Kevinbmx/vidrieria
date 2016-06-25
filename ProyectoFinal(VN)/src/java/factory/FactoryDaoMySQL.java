package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class FactoryDaoMySQL extends FactoryDao{

	private FactoryDaoMySQL(){
		;
	}

	public static FactoryDao getFactoryInstance(){
		if(instancia==null)
			instancia = new FactoryDaoMySQL();
		return instancia;
	}

	@Override
	public CategoriaDao getNewCategoriaDao(){
		return new CategoriaDaoMySQL();
	}

	@Override
	public DetallepedidoDao getNewDetallepedidoDao(){
		return new DetallepedidoDaoMySQL();
	}

	@Override
	public PedidoDao getNewPedidoDao(){
		return new PedidoDaoMySQL();
	}

	@Override
	public ProductoDao getNewProductoDao(){
		return new ProductoDaoMySQL();
	}

	@Override
	public UsuarioDao getNewUsuarioDao(){
		return new UsuarioDaoMySQL();
	}

}

