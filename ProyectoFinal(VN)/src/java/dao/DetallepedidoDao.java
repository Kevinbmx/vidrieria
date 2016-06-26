package dao;

import dto.DetallePedido;
import java.util.ArrayList;

public abstract class DetallepedidoDao {

    public abstract int insert(DetallePedido obj) throws Exception;

    public abstract void update(DetallePedido obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<DetallePedido> getList();

    public abstract DetallePedido get(int id);

}
