package factory;

import dal.Configuracion;
import dao.*;
import dto.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FactoryDao {

    protected static FactoryDao instancia;

    public static FactoryDao getFactoryInstance() {
        if (instancia == null) {
            Configuracion config = Configuracion.getConfiguracion();
            if (config.getDbEngine().equals("MySQL"));
            instancia = FactoryDaoMySQL.getFactoryInstance();
        }
        return instancia;
    }

    public abstract CategoriaDao getNewCategoriaDao();

    public abstract DetallepedidoDao getNewDetallepedidoDao();

    public abstract PedidoDao getNewPedidoDao();

    public abstract ProductoDao getNewProductoDao();

    public abstract UsuarioDao getNewUsuarioDao();

    public static void main(String[] args) {
        Usuario usr = new Usuario();
        usr.setNombreCompleto("Juan Perez");
        usr.setDireccion("Av. Beni");
        usr.setNombreUsuario("juan");
        usr.setPassword("123456");
        try {
            FactoryDao.getFactoryInstance().getNewUsuarioDao().insert(usr);
        } catch (Exception ex) {
            Logger.getLogger(FactoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
