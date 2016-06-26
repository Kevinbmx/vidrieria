package dao;

import dto.Producto;
import java.util.ArrayList;

public abstract class ProductoDao {

    public abstract int insert(Producto obj) throws Exception;

    public abstract void update(Producto obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Producto> getList();

    public abstract Producto get(int id);

    public abstract ArrayList<Producto> getCategory(int id);

    public abstract ArrayList<Producto> getListFromIds(String ids);
}
