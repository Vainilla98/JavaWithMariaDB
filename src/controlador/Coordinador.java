package controlador;

import modelo.*;
import vista.GestionarTrenes;
import vista.VentanaInfoLineas;
import vista.VentanaPrincipal;
import vista.VentanaTablaTrenes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Coordinador implements ActionListener {
    private Logica logica;
    private final VentanaPrincipal miVentanaPrincipal;
    private final GestionarTrenes miVentanagestionarTrenes;
    private final VentanaInfoLineas miVentanaInfoLineas;
    private final VentanaTablaTrenes ventanaTablaTrenes;

    public Coordinador() {
        //Se instancian las clases - instancias únicas
        this.miVentanaPrincipal = new VentanaPrincipal();
        this.miVentanagestionarTrenes = new GestionarTrenes();
        this.miVentanaInfoLineas = new VentanaInfoLineas();
        this.ventanaTablaTrenes = new VentanaTablaTrenes();

    }

    public void iniciarVista() {
        this.logica = new Logica();

        // Iniciar vistaPrincipal y configurar secundarias
        configuracionInicialVentanas();
    }

    /**
     *  Se carga y se muestra la ventana principal y se añaden escuchadores a todos los botones de todas las pantallas
     */
    public void configuracionInicialVentanas() {
        miVentanaPrincipal.setLocationRelativeTo(null);
        miVentanaPrincipal.setVisible(true);

        miVentanaPrincipal.getBtn_GestTrenes().addActionListener(this);
        miVentanaPrincipal.getBtn_Info().addActionListener(this);
        miVentanaPrincipal.getBtn_Salir().addActionListener(this);
        miVentanaPrincipal.addWindowListener(new CerrarConexionOnX());


        // Botones de Ventana Info Lineas
        miVentanaInfoLineas.getBtn_buscar().addActionListener(this);
        miVentanaInfoLineas.getBtn_salir().addActionListener(this);
        miVentanaInfoLineas.getBtn_verTrenes().addActionListener(this);

        // Botones de Ventana Gestionar Trenes
        miVentanagestionarTrenes.getBtn_buscar().addActionListener(this);
        miVentanagestionarTrenes.getBtn_eliminar().addActionListener(this);
        miVentanagestionarTrenes.getBtn_insertar().addActionListener(this);
        miVentanagestionarTrenes.getBtn_modificar().addActionListener(this);
        miVentanagestionarTrenes.getBtn_cargar().addActionListener(this);
        miVentanagestionarTrenes.getBtn_salir().addActionListener(this);
    }

    public void mostrarVentanaInfoLineas() {
        miVentanaInfoLineas.setLocationRelativeTo(miVentanaPrincipal);
        miVentanaInfoLineas.setVisible(true);
    }

    public void mostrarVentanaGestinarTrenes() {
        miVentanagestionarTrenes.setLocationRelativeTo(miVentanaPrincipal);
        miVentanagestionarTrenes.setVisible(true);

        miVentanagestionarTrenes.cambiarEstadoBotones(true);
    }

    private int validarNumero(String cadena, Component mensajeError){
        try {
            return Integer.parseInt(cadena);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(mensajeError, "Introduce un numero entero válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ventana Principal
        if (e.getSource() == miVentanaPrincipal.getBtn_GestTrenes()) {
            mostrarVentanaGestinarTrenes();
        }
        if (e.getSource() == miVentanaPrincipal.getBtn_Info()) {
             mostrarVentanaInfoLineas();
        }
        if (e.getSource() == miVentanaPrincipal.getBtn_Salir()) {
            logica.cerrarConexion();
            System.exit(0);
        }

        // Vetnana Gestionar Trenes
        if (e.getSource() == miVentanagestionarTrenes.getBtn_buscar()) {
            bucarTrenes();
        }
        if (e.getSource() == miVentanagestionarTrenes.getBtn_eliminar()) {
            eliminarTren();
        }
        if (e.getSource() == miVentanagestionarTrenes.getBtn_insertar()) {
            Tren tren = combrobarBoxes();
            if (tren != null){
                insertarTren(tren);
            }
        }
        if (e.getSource() == miVentanagestionarTrenes.getBtn_cargar()) {
            cargarDatos();
        }
        if (e.getSource() == miVentanagestionarTrenes.getBtn_modificar()) {
            modificarDatos();
        }
        if (e.getSource() == miVentanagestionarTrenes.getBtn_salir()) {
            miVentanagestionarTrenes.limpiarCampos();
            miVentanagestionarTrenes.dispose();
        }

        // Ventana Info Lineas
        if (e.getSource() == miVentanaInfoLineas.getBtn_buscar()) {
            infoLinea();
        }
        if (e.getSource() == miVentanaInfoLineas.getBtn_verTrenes()) {
            buscarTren();
        }
        if (e.getSource() == miVentanaInfoLineas.getBtn_salir()) {
            miVentanaInfoLineas.limpiarCampos();
            miVentanaInfoLineas.dispose();
        }
    }

    private void eliminarTren() {
        String cadena = miVentanagestionarTrenes.getTbx_cod().getText();
        if (cadena.isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getBtn_eliminar(), "El Ingresa algo en id", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int codOriginal = validarNumero(cadena, miVentanagestionarTrenes.getBtn_eliminar());
            boolean borrado = logica.validarElimando(codOriginal);
            if (borrado){
                JOptionPane.showMessageDialog(miVentanagestionarTrenes.getBtn_eliminar(), "Registro borrado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                miVentanagestionarTrenes.limpiarCampos();
            }
        }
    }

    private void modificarDatos() {
        miVentanagestionarTrenes.cambiarEstadoBotones(true);
        logica.validarModificado(combrobarBoxes());
        JOptionPane.showMessageDialog(miVentanagestionarTrenes.getBtn_modificar(), "Registro modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
        miVentanagestionarTrenes.limpiarCampos();
    }
    private void cargarDatos() {
        int codOriginal;
        List<Tren> trenes= logica.validarBusquedaTrenTodo();
        if (!trenes.isEmpty()){
            List<Integer> lista = new ArrayList<>(trenes.size());
            for (Tren e:trenes ) {
                lista.add(e.getCod());
            }
            ImageIcon icono = null;
            try {
                BufferedImage myPicture = ImageIO.read(new File("logo.png"));
                icono = new ImageIcon(myPicture.getScaledInstance(300, 300, Image.SCALE_FAST));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Object codObj =  JOptionPane.showInputDialog(miVentanagestionarTrenes.getBtn_cargar(), "Introduce el codigo del tren a modificar.\nEsta acción inabilitará el resto de botones hasta que se modifique el registro o hasta que se pulse el botón de salir.",
                    "Elija el código a modificar", JOptionPane.QUESTION_MESSAGE,
                    icono, lista.toArray(),
                    lista.get(1));
            if (codObj != null){
                String cod = codObj.toString();
                codOriginal = Integer.parseInt(cod);
                miVentanagestionarTrenes.getTbx_cod().setText(codOriginal+"");
                miVentanagestionarTrenes.getTbx_cod().setEnabled(false);
                bucarTrenes();

                miVentanagestionarTrenes.cambiarEstadoBotones(false);
            }
        } else {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getBtn_insertar(), "No hay trenes en la Base de DATOS", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void insertarTren(Tren tren) {
        if (logica.validarRegistro(tren) != 0){
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getBtn_insertar(), "Registro insertado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
            miVentanagestionarTrenes.limpiarCampos();
        }
    }

    /**
     * Combrueba que todos los input de los TextField introducidos por el usuario sean válidos
     *
     * @return Si todos los campos son correctos el tren creado
     */
    private Tren combrobarBoxes() {
        int codigo, linea, cochera;
        Linea lin;
        if (miVentanagestionarTrenes.getTbx_cod().getText().isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "El campo CODIGO no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if ((codigo = validarNumero(miVentanagestionarTrenes.getTbx_cod().getText(),miVentanagestionarTrenes.getTbx_cod())) == -1){
            return null;
        }
        if (miVentanagestionarTrenes.getTxb_nombre().getText().isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTxb_nombre(), "El campo NOMBRE no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (miVentanagestionarTrenes.getTxb_tipo().getText().isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTxb_tipo(), "El campo TIPO no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (miVentanagestionarTrenes.getTxb_linea().getText().isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTxb_linea(), "El campo LINEA no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if ((linea = validarNumero(miVentanagestionarTrenes.getTxb_linea().getText(),miVentanagestionarTrenes.getTxb_linea())) == -1){
            return null;
        } else if (logica.validarBusquedaLinea(linea) == null){
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTxb_linea(), "No hay registros con linea "+linea+" en la tabla 't_lineas'", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (miVentanagestionarTrenes.getTxb_cochera().getText().isBlank()) {
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTxb_cochera(), "El campo COCHERA no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        } else if ((cochera = validarNumero(miVentanagestionarTrenes.getTxb_cochera().getText(),miVentanagestionarTrenes.getTxb_cochera())) == -1){
            return null;
        }
        lin = logica.validarBusquedaLinea(linea);
        return new Tren(codigo,miVentanagestionarTrenes.getTxb_nombre().getText(),miVentanagestionarTrenes.getTxb_tipo().getText(),lin,cochera);
    }

    private void infoLinea() {
        int codigo;
        if (miVentanaInfoLineas.getTxb_codLinea().getText().isBlank()){
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "Introduce algun código", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if ((codigo = validarNumero(miVentanaInfoLineas.getTxb_codLinea().getText(),miVentanaInfoLineas.getTxb_codLinea())) != -1) {
            Linea linea = logica.validarBusquedaLinea(codigo);
            if (linea != null){
                miVentanaInfoLineas.getTfl_nombre().setText(linea.getNombre());
                miVentanaInfoLineas.getTfl_nTrenes().setText(logica.validarBusquedaTrenTodoLinea(linea.getCodLinea()).size()+"");
            } else
                JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "No existe linea con codigo "+codigo, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void buscarTren() {
        int codigo;
        if (miVentanaInfoLineas.getTxb_codLinea().getText().isBlank()){
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "Introduce algun código", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if ((codigo = validarNumero(miVentanaInfoLineas.getTxb_codLinea().getText(),miVentanaInfoLineas.getTxb_codLinea())) != -1) {
            Linea linea = logica.validarBusquedaLinea(codigo);
            if (linea != null){
                mostrarVistaTabla(linea);
            } else
                JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "No existe linea con codigo "+codigo, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarVistaTabla(Linea linea) {
        ventanaTablaTrenes.dispose();
        ventanaTablaTrenes.setVisible(true);
        ventanaTablaTrenes.getLblNombre().setText(linea.getNombre());
        List<Tren> lista = logica.validarBusquedaTrenTodoLinea(linea.getCodLinea());
        if (!lista.isEmpty()){
            ventanaTablaTrenes.setVisible(true);
            for (Tren tren: lista) {
                ventanaTablaTrenes.getTabla().addRow(new String[]{tren.getCod()+"",tren.getNombre(),tren.getTipo(),tren.getCodCochera()+""} );
            }
        }
    }

    private void bucarTrenes() {
        int codigo;
        if (miVentanagestionarTrenes.getTbx_cod().getText().isBlank()){
            JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "Introduce algun código", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if ((codigo = validarNumero(miVentanagestionarTrenes.getTbx_cod().getText(), miVentanagestionarTrenes.getTbx_cod())) != -1) {
            Tren tren = logica.validarBusquedaTren(codigo);
            if (tren != null){
                gestionCambiarCampos(tren.getNombre(), tren.getCodCochera(), tren.getLinea().getCodLinea(),tren.getTipo());
            } else {
                JOptionPane.showMessageDialog(miVentanagestionarTrenes.getTbx_cod(), "No existe registro de tren con código "+codigo, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void gestionCambiarCampos(String nombre, int cochera, int linea, String tipo) {
        miVentanagestionarTrenes.getTxb_nombre().setText(nombre);
        miVentanagestionarTrenes.getTxb_cochera().setText(cochera+"");
        miVentanagestionarTrenes.getTxb_linea().setText(linea+"");
        miVentanagestionarTrenes.getTxb_tipo().setText(tipo);
    }
}
