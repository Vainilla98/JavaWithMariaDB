package controlador;

import modelo.Conexion;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * La función de esta clase es modificar el funcionamiento del boton 'x'. Antes de que se cerrase la pagina, pulsando 'x'
 * cerramos la conexion con el servidor
 */
public class CerrarConexionOnX extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e){
            try {
                if (Conexion.getConexion() != null || !Conexion.getConexion().isClosed()){
                    Conexion.closeConexion();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errror al cerrar la conexion", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            System.exit(0);
        }
}
