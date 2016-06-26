package dao;

import dto.Pedido;
import java.util.ArrayList;

public abstract class PedidoDao {

    public abstract int insert(Pedido obj) throws Exception;

    public abstract void update(Pedido obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Pedido> getList();

    public abstract Pedido get(int id);

}
