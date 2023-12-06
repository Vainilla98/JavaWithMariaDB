package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class VentanaInfoLineas extends JFrame {

	private JPanel contentPane;
	private JTextField txb_codLinea;
	private JTextField tfl_nTrenes;
	private JTextField tfl_nombre;
	private JButton btn_buscar;
	private JButton btn_verTrenes;
	private JButton btn_salir;


	/**
	 * Create the frame.
	 */
	public VentanaInfoLineas() {
		setIconImage(new ImageIcon("logo.png").getImage());
		setResizable(false);
		setTitle("Informacion Lineas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(10, 29, 132, 32);
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btn_buscar);
		
		btn_verTrenes = new JButton("Ver Trenes");
		btn_verTrenes.setBounds(165, 29, 132, 32);
		btn_verTrenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btn_verTrenes);
		
		btn_salir = new JButton("Salir");
		btn_salir.setBounds(369, 29, 132, 32);
		btn_salir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btn_salir);
		
		JLabel lblNewLabel = new JLabel("Código Linea");
		lblNewLabel.setBounds(49, 81, 90, 32);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		txb_codLinea = new JTextField();
		txb_codLinea.setBounds(144, 81, 136, 25);
		txb_codLinea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txb_codLinea.setColumns(10);
		contentPane.add(txb_codLinea);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(85, 191, 57, 22);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		
		tfl_nombre = new JTextField();
		tfl_nombre.setBounds(147, 188, 185, 25);
		tfl_nombre.setEnabled(false);
		tfl_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfl_nombre.setColumns(10);
		contentPane.add(tfl_nombre);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de Trenes");
		lblNewLabel_2.setBounds(10, 221, 132, 22);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		
		tfl_nTrenes = new JTextField();
		tfl_nTrenes.setBounds(147, 218, 49, 25);
		tfl_nTrenes.setEnabled(false);
		contentPane.add(tfl_nTrenes);
		tfl_nTrenes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfl_nTrenes.setColumns(10);
	}

	public JTextField getTxb_codLinea() {
		return txb_codLinea;
	}

	public JTextField getTfl_nTrenes() {
		return tfl_nTrenes;
	}

	public JTextField getTfl_nombre() {
		return tfl_nombre;
	}

	public JButton getBtn_buscar() {
		return btn_buscar;
	}

	public JButton getBtn_verTrenes() {
		return btn_verTrenes;
	}

	public JButton getBtn_salir() {
		return btn_salir;
	}

	public void limpiarCampos() {
		txb_codLinea.setText("");
	}
}
