package modelo;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


/**
 * La funcion de esta clase es la de ser intermediaria entre la clase Coordinador y las DAO gestinando las excepciones
 * que lanzan las DAO
 */
public class Logica {

	private final LineaDAO lineaDAO;
	private final TrenDAO trenDAO;

	public Logica() {
		this.lineaDAO = new LineaDAO();
		this.trenDAO = new TrenDAO(lineaDAO);
	}

	public Tren validarBusquedaTren(int id) {
		Tren tren = null;
		try {
			tren = trenDAO.buscar(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el acceso a la BDD", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return tren;
	}

	public List<Tren> validarBusquedaTrenTodo() {
		List<Tren> trenes = new ArrayList<>();
		try {
			trenes = trenDAO.buscarTodo();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el acceso a la BDD", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return trenes;
	}

	public List<Tren> validarBusquedaTrenTodoLinea(int idLinea) {
		List<Tren> trenes = new ArrayList<>();
		try {
			trenes = trenDAO.buscarTodo(idLinea);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el acceso a la BDD", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return trenes;
	}

	public Linea validarBusquedaLinea(int id) {
		Linea linea = null;
		try {
			linea = lineaDAO.buscar(id);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No error al acceder a la linea en la BDD", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return linea;
	}

	public int validarRegistro(Tren tren) {
		int resultado = 0;
		try {
			resultado = trenDAO.insertar(tren);
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Ya existe un tren con codigo "+tren.getCod(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el nuevo tren.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public boolean validarElimando(int id) {
		boolean resultado = false;
		try {
			resultado = trenDAO.eliminar(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido eliminat el tren", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public boolean validarModificado(Tren tren) {
		boolean resultado = false;
		try {
			resultado = trenDAO.modificar(tren);
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Ya existe un tren con codigo "+tren.getCod(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido modifcar el tren "+tren.getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public void cerrarConexion() {
		try {
			Conexion.closeConexion();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
