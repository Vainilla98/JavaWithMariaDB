package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTablaTrenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JLabel lblNombre;
	private final DefaultTableModel tabla;

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public DefaultTableModel getTabla() {
		return tabla;
	}

	/**
	 * Create the frame.
	 */
	public VentanaTablaTrenes() {
		setTitle("Registros trenes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabla = new DefaultTableModel();
		tabla.setColumnIdentifiers(new String[]{"Codigo", "Nombre", "Tipo","Cochera"});
		JTable tbl_trenes = new JTable(tabla);

		tbl_trenes.getColumn("Codigo").setMinWidth(80);
		tbl_trenes.getColumn("Nombre").setMinWidth(180);
		tbl_trenes.getColumn("Tipo").setMinWidth(180);

		tbl_trenes.setBackground(Color.lightGray);
		tbl_trenes.getTableHeader().setBackground(Color.darkGray);
		tbl_trenes.getTableHeader().setForeground(Color.white);
		tbl_trenes.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		tbl_trenes.getTableHeader().setPreferredSize(new Dimension(512,50));
		tbl_trenes.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tbl_trenes.setEnabled(false);

		tbl_trenes.setBounds(10, 106, 512, 426);

		JScrollPane scrollPane = new JScrollPane(tbl_trenes);
		scrollPane.setBounds(10, 106, 512, 426);
		contentPane.add(scrollPane);

		tbl_trenes.getColumn("Codigo").setMaxWidth(20);

		lblNombre = new JLabel();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 30));
		lblNombre.setBounds(50, 13, 472, 83);
		contentPane.add(lblNombre);
	}
}
