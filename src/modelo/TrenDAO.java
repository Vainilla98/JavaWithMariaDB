package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrenDAO implements DAO<Tren,Integer> {

    private final LineaDAO lineaDAO;

    public TrenDAO(LineaDAO lineaDAO) {
        this.lineaDAO = lineaDAO;
    }

    @Override
    public int insertar(Tren elemento) throws SQLException {
        String sql = "INSERT INTO t_trenes (cod_tren, nombre, tipo, cod_linea, cod_cochera) VALUES (?, ?, ?, ?, ?)";
        Connection con = Conexion.getConexion();
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1,elemento.getCod());
        sentencia.setString(2,elemento.getNombre());
        sentencia.setString(3,elemento.getTipo());
        sentencia.setInt(4,elemento.getLinea().getCodLinea());
        sentencia.setInt(5,elemento.getCodCochera());
        int res = sentencia.executeUpdate();
        sentencia.close();
        return res;
    }

    @Override
    public Tren buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM t_trenes WHERE cod_tren = ?";
        Connection con = Conexion.getConexion();
        PreparedStatement sentencia = con.prepareStatement(sql);
        Tren tren = null;
        sentencia.setInt(1,id);
        ResultSet salida = sentencia.executeQuery();
        if (salida.next()){
            Linea linea = lineaDAO.buscar(salida.getInt(4));
            tren = new Tren(salida.getInt(1),salida.getString(2),salida.getString(3),linea,salida.getInt(5));
        }
        sentencia.close();
        return tren;
    }

    @Override
    public List<Tren> buscarTodo() throws SQLException {
        List<Tren> lista = new ArrayList<>();
        String sql = "SELECT * FROM t_trenes";
        Connection con = Conexion.getConexion();

        PreparedStatement sentencia = con.prepareStatement(sql);
        ResultSet salida = sentencia.executeQuery();
        while (salida.next()){
            Linea dir = lineaDAO.buscar(salida.getInt(4));
            lista.add(new Tren(salida.getInt(1),salida.getString(2),salida.getString(3),dir,salida.getInt(5)));
        }
        return lista;
    }

    public List<Tren> buscarTodo(Integer linea) throws SQLException {
        List<Tren> lista = new ArrayList<>();
        String sql = "SELECT * FROM t_trenes WHERE cod_linea = "+linea;

        Connection con = Conexion.getConexion();
        PreparedStatement sentencia = con.prepareStatement(sql);
        ResultSet salida = sentencia.executeQuery();
        while (salida.next()){
            Linea dir = lineaDAO.buscar(salida.getInt(4));
            lista.add(new Tren(salida.getInt(1),salida.getString(2),salida.getString(3),dir,salida.getInt(5)));
        }
        return lista;
    }

    @Override
    public boolean modificar(Tren elemento) throws SQLException {
        Connection con = Conexion.getConexion();
        // cod_tren, nombre, tipo, cod_linea, cod_cochera
        String sql = "UPDATE t_trenes SET nombre=?, tipo=?, cod_linea = ?, cod_cochera = ? WHERE cod_tren = ?";
        PreparedStatement sentencia = con.prepareStatement(sql);

        sentencia.setString(1, elemento.getNombre());
        sentencia.setString(2, elemento.getTipo());
        sentencia.setInt(3, elemento.getLinea().getCodLinea());
        sentencia.setInt(4, elemento.getCodCochera());

        sentencia.setInt(5, elemento.getCod());

        int res = sentencia.executeUpdate();
        sentencia.close();
        return res != 0;
    }

    @Override
    public boolean eliminar(Integer id) throws SQLException {
        Connection con = Conexion.getConexion();
        String sql = "DELETE FROM t_trenes WHERE cod_tren = ?";
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1,id);
        int res = sentencia.executeUpdate();
        sentencia.close();
        return res != 0;
    }
}
