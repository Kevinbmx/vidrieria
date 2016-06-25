package dao;

import dto.Detallepedido;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class DetallepedidoDao {

	public abstract int insert(Detallepedido obj) throws Exception;

	public abstract void update(Detallepedido obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Detallepedido> getList();

	public abstract Detallepedido get(int id);

}

