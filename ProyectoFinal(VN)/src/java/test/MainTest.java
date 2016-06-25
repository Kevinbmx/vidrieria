package test;

import dal.Conexion;
import dao.CategoriaDao;
import dao.ProductoDao;

import dao.UsuarioDao;
import dto.Categoria;
import dto.Producto;
import dto.Usuario;
import factory.FactoryDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTest {

    public static void main(String[] args) {

        try {
            
            
//            UsuarioDao objDao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//            Usuario obj = new Usuario();
////            obj.setNombreUsuario("kevinsdfad");
////            obj.setNombreCompleto("kevin Delgadillo Salazarasdf");
////            obj.setPassword("123");
////            obj.setDireccion("calle por alla");
//            obj.setUsuarioId(1);
////            objDao.insert(obj);
////            objDao.update(obj);
//            objDao.delete(1);
//            obj = objDao.get(1);
//            System.out.println("contra: "+obj.getNombreUsuario());
//            
//            
            
            
            ProductoDao objDao =  FactoryDao.getFactoryInstance().getNewProductoDao();
            Producto obj =  new Producto();
            
            obj.setNombre("camisa");
            obj.setDescripcion("manga larga");
            obj.setPrecio(250);
            obj.setCategoriaId(1);
            obj.setImagen("hola.com");
            objDao.insert(obj);
            obj = objDao.get(1);
            System.out.println(" nombre : "+ obj.getNombre());


            
            
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
