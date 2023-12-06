package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LineaDAO implements DAO<Linea,Integer>{
    @Override
    public int insertar(Linea elemento) throws SQLException {

        return 0;
    }

    @Override
    public Linea buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM t_lineas WHERE cod_linea = ?";
        Connection con = Conexion.getConexion();
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1,id);
        ResultSet salida = sentencia.executeQuery();
        if (salida.next()){
            return new Linea(salida.getInt(1),salida.getString(2));
        }
        return null;
    }

    @Override
    public List<Linea> buscarTodo() throws SQLException {
        return null;
    }

    @Override
    public boolean modificar(Linea elemento) throws SQLException {
        return false;
    }

    @Override
    public boolean eliminar(Integer id) throws SQLException {
        return false;
    }
}
