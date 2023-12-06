package vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private final JButton btn_GestTrenes = new JButton("Gestionar Trenes");
	private final JButton btn_Salir;
	private final JButton btn_Info;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(new ImageIcon("logo.png").getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 423, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Renfo");
		lblNewLabel.setBounds(137, 10, 233, 104);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 42));
		contentPane.add(lblNewLabel);
		btn_GestTrenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_GestTrenes.setBounds(51, 119, 292, 56);
		contentPane.add(btn_GestTrenes);
		
		btn_Info = new JButton("Información Lineas");
		btn_Info.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_Info.setBounds(51, 214, 292, 56);
		contentPane.add(btn_Info);
		
		btn_Salir = new JButton("Salir");
		btn_Salir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_Salir.setBounds(51, 333, 292, 56);
		contentPane.add(btn_Salir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 297, 461, 20);
		contentPane.add(separator);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("logo.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		JLabel lblLogo =  new JLabel(new ImageIcon(myPicture.getScaledInstance(100, 100, Image.SCALE_FAST)));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setBounds(54, 10, 130, 94);
		contentPane.add(lblLogo);
	}

	public JButton getBtn_GestTrenes() {
		return btn_GestTrenes;
	}

	public JButton getBtn_Salir() {
		return btn_Salir;
	}

	public JButton getBtn_Info() {
		return btn_Info;
	}
}
