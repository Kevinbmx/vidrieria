package dal;

import java.sql.Connection;


public abstract class Conexion implements IConexion {

    protected String host;

    protected String dataBase;

    protected String instance;

    protected String port;
   
    protected String userName;

    protected String password;

    protected Connection objConnection;

    protected static Conexion objSingleton;


    public static Conexion getOrCreate() {
        if (objSingleton == null) {
            Configuracion config = Configuracion.getConfiguracion();
            if (config.getDbEngine().equals("MySQL")) {
                objSingleton = ConexionMySQL.getOrCreate();
            }/*
             if (config.getDbEngine().equals("Oracle")) {
             objSingleton = ConexionOracle.getOrCreate();
             }
             if (config.getDbEngine().equals("SQLServer")) {
             objSingleton = ConexionOracle.getOrCreate();
             }
             if (config.getDbEngine().equals("PostgreSQL")) {
             objSingleton = ConexionPostgreSQL.getOrCreate();
             }
             */

        }
        objSingleton.conectar();
        return objSingleton;
    }


    public String getDataBase() {
        return dataBase;
    }

    public String getHost() {
        return host;
    }

 
    public String getInstance() {
        return instance;
    }


    public String getPassword() {
        return password;
    }

  
    public String getPort() {
        return port;
    }


    public String getUsername() {
        return userName;
    }
}
