package modelo;

import java.sql.SQLException;
import java.util.List;

public interface DAO<A,K> {
    int insertar(A elemento) throws SQLException ;
    A buscar(K id) throws SQLException;
    List<A> buscarTodo() throws SQLException;
    boolean modificar(A elemento) throws SQLException;

    boolean eliminar(K id) throws SQLException;
}
