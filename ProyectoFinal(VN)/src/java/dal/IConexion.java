package dal;

import java.sql.ResultSet;

public interface IConexion {

    public void conectar();

    public void comenzarTransaccion();

    public void terminarTransaccion();

    public void desconectar();

    public ResultSet ejecutar(String query);

    public int ejecutarSimple(String query);

    public int ejecutarInsert(String query);

    public boolean estaConectado();

}
