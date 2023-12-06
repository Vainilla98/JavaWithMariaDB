package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class GestionarTrenes extends JFrame {

	private JPanel contentPane;
	private JTextField tbx_cod;
	private JTextField txb_nombre;
	private JTextField txb_tipo;
	private JTextField txb_linea;
	private JTextField txb_cochera;
	private JButton btn_salir;
	private JButton btn_modificar;
	private JButton btn_eliminar;
	private JButton btn_insertar;
	private JButton btn_buscar;
	private JButton btn_cargar;

	/**
	 * Create the frame.
	 */
	public GestionarTrenes() {
		setTitle("Gestion de Trenes");
		setResizable(false);
		setIconImage(new ImageIcon("logo.png").getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código Tren");
		lblNewLabel.setBounds(23, 92, 86, 42);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);


		btn_buscar = new JButton("Buscar");
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_buscar.setBounds(10, 22, 139, 35);
		contentPane.add(btn_buscar);
		

		btn_insertar = new JButton("Insertar");
		btn_insertar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_insertar.setBounds(159, 22, 139, 35);
		contentPane.add(btn_insertar);
		

		btn_modificar = new JButton("Modificar");
		btn_modificar.setEnabled(false);
		btn_modificar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_modificar.setBounds(457, 22, 139, 35);
		contentPane.add(btn_modificar);
		

		btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_eliminar.setBounds(308, 22, 139, 35);
		contentPane.add(btn_eliminar);
		

		btn_salir = new JButton("Salir");
		btn_salir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_salir.setBounds(674, 22, 139, 35);
		contentPane.add(btn_salir);
		
		tbx_cod = new JTextField();
		tbx_cod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbx_cod.setBounds(123, 99, 136, 25);
		contentPane.add(tbx_cod);
		tbx_cod.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblNombre.setBounds(23, 131, 86, 42);
		contentPane.add(lblNombre);
		
		txb_nombre = new JTextField();
		txb_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txb_nombre.setColumns(10);
		txb_nombre.setBounds(123, 138, 228, 25);
		contentPane.add(txb_nombre);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblTipo.setBounds(23, 170, 86, 42);
		contentPane.add(lblTipo);
		
		txb_tipo = new JTextField();
		txb_tipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txb_tipo.setColumns(10);
		txb_tipo.setBounds(123, 177, 228, 25);
		contentPane.add(txb_tipo);
		
		JLabel lblLinea = new JLabel("Linea");
		lblLinea.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblLinea.setBounds(23, 209, 86, 42);
		contentPane.add(lblLinea);
		
		txb_linea = new JTextField();
		txb_linea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txb_linea.setColumns(10);
		txb_linea.setBounds(123, 216, 228, 25);
		contentPane.add(txb_linea);
		
		JLabel lblCochera = new JLabel("Cochera");
		lblCochera.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblCochera.setBounds(23, 248, 86, 42);
		contentPane.add(lblCochera);
		
		txb_cochera = new JTextField();
		txb_cochera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txb_cochera.setColumns(10);
		txb_cochera.setBounds(123, 255, 228, 25);
		contentPane.add(txb_cochera);
		
		btn_cargar = new JButton("Cargar");
		btn_cargar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cargar.setBounds(483, 67, 86, 35);
		contentPane.add(btn_cargar);
	}

	public void limpiarCampos() {
		tbx_cod.setText("");
		txb_cochera.setText("");
		txb_linea.setText("");
		txb_nombre.setText("");
		txb_tipo.setText("");
	}

	public void cambiarEstadoBotones(boolean estado) {
		tbx_cod.setEnabled(estado);
		btn_buscar.setEnabled(estado);
		btn_eliminar.setEnabled(estado);
		btn_insertar.setEnabled(estado);

		btn_modificar.setEnabled(!estado);
		btn_cargar.setEnabled(estado);
	}

	public JButton getBtn_cargar() {
		return btn_cargar;
	}
	public JTextField getTbx_cod() {
		return tbx_cod;
	}

	public JTextField getTxb_nombre() {
		return txb_nombre;
	}

	public JTextField getTxb_tipo() {
		return txb_tipo;
	}

	public JTextField getTxb_linea() {
		return txb_linea;
	}

	public JTextField getTxb_cochera() {
		return txb_cochera;
	}

	public JButton getBtn_salir() {
		return btn_salir;
	}

	public JButton getBtn_modificar() {
		return btn_modificar;
	}

	public JButton getBtn_eliminar() {
		return btn_eliminar;
	}

	public JButton getBtn_insertar() {
		return btn_insertar;
	}

	public JButton getBtn_buscar() {
		return btn_buscar;
	}
}
