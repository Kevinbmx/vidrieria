package dao;

import dto.Producto;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class ProductoDao {

    public abstract int insert(Producto obj) throws Exception;

    public abstract void update(Producto obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Producto> getList();

    public abstract Producto get(int id);

    public abstract ArrayList<Producto> getCategoria(int id);

    public abstract  ArrayList<Producto> getlista(String ids);
                
}
