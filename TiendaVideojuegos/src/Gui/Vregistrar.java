package Gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Vregistrar extends JFrame {

	public Connection conexion;

	public static Logger logger = Logger.getLogger(Vregistrar.class.getName());

	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblApellidos = new JLabel("Apellidos:");
	JLabel lblEdad = new JLabel("Edad:");
	JLabel lblCorreo = new JLabel("Direccion correo:");
	JLabel lblNick = new JLabel("Nick:");
	JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
	JButton btnAceptar = new JButton("");
	JCheckBox checkCondiciones = new JCheckBox("Acepto que mis datos sean guardados en la base de datos");
	private JTextField Nombre;
	private JTextField Apellidos;
	private JTextField Edad;
	private JTextField DireccionCorreo;
	private JTextField Nick;
	private JPasswordField contrasenya;
	private JPasswordField passwordField;
	private JTextField textField;

	public void Enviar_datos() {

		try {

			String sDriver = "com.mysql.jdbc.Driver";
			Class.forName(sDriver).newInstance();
			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root",
					"");

			if (conexion != null) {

				JOptionPane.showMessageDialog(null, "Conectado correctamente a la base de datos");

				PreparedStatement stmt = conexion.prepareStatement("INSERT INTO login VALUES(?,?,?,?,?,?)");

				stmt.setString(1, Nombre.getText());
				stmt.setString(2, Nick.getText());
				stmt.setString(3, contrasenya.getText());
				stmt.setString(4, Apellidos.getText());
				stmt.setString(5, DireccionCorreo.getText());
				stmt.setInt(6, Integer.parseInt(Edad.getText()));

				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO");
			}

		} catch (Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO");
		}
	}

	public Vregistrar() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vregistrar.class.getResource("/imagenes/Logo.jpg")));

		setSize(701, 432);

		setLocationRelativeTo(null);
		setAutoRequestFocus(false);
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		lblNombre.setBounds(10, 38, 61, 22);
		getContentPane().add(lblNombre);
		lblApellidos.setBounds(10, 71, 61, 22);
		getContentPane().add(lblApellidos);
		lblEdad.setBounds(10, 104, 43, 22);
		getContentPane().add(lblEdad);
		lblCorreo.setBounds(10, 137, 98, 16);
		getContentPane().add(lblCorreo);
		lblNick.setBounds(10, 164, 56, 16);
		getContentPane().add(lblNick);
		lblContrasea.setBounds(10, 191, 70, 16);
		getContentPane().add(lblContrasea);

		Nombre = new JTextField();
		Nombre.setBounds(105, 38, 109, 22);
		getContentPane().add(Nombre);
		Nombre.setColumns(10);

		Apellidos = new JTextField();
		Apellidos.setBounds(105, 72, 201, 20);
		getContentPane().add(Apellidos);
		Apellidos.setColumns(10);

		Edad = new JTextField();
		Edad.setBounds(105, 105, 28, 20);
		getContentPane().add(Edad);
		Edad.setColumns(10);

		DireccionCorreo = new JTextField();
		DireccionCorreo.setBounds(105, 135, 201, 20);
		getContentPane().add(DireccionCorreo);
		DireccionCorreo.setColumns(10);

		Nick = new JTextField();
		Nick.setColumns(10);
		Nick.setBounds(105, 164, 201, 20);
		getContentPane().add(Nick);

		contrasenya = new JPasswordField();
		contrasenya.setBounds(105, 189, 201, 21);
		getContentPane().add(contrasenya);

		JLabel label = new JLabel("Nick:");
		label.setForeground(SystemColor.text);
		label.setBounds(377, 137, 70, 16);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setForeground(SystemColor.text);
		label_1.setBounds(377, 191, 70, 16);
		getContentPane().add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(451, 133, 201, 25);
		getContentPane().add(textField);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 349, 403);
		getContentPane().add(panel);
		panel.setLayout(null);

		String path = "https://us.123rf.com/450wm/faysalfarhan/faysalfarhan1611/faysalfarhan161100569/65438707-registrarse-editar-icono-de-correo-bot%C3%B3n-cuadrado-naranja.jpg?ver=6";
		URL url = new URL(path);
		BufferedImage image = ImageIO.read(url);
		checkCondiciones.setBounds(0, 232, 349, 25);
		panel.add(checkCondiciones);
		checkCondiciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnAceptar.setBounds(38, 281, 278, 77);
		panel.add(btnAceptar);

		btnAceptar.setOpaque(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent c) {
				if (checkCondiciones.isSelected()) {
					Enviar_datos();
				} else {
					logger.warning("No has aceptado las condiciones");
				}

			}
		});
		JLabel imagen1 = new JLabel("");
		imagen1.setBounds(0, 0, 349, 403);
		imagen1.setHorizontalAlignment(SwingConstants.CENTER);
		imagen1.setIcon(new ImageIcon(image));
		panel.add(imagen1);

		JPanel panel2 = new JPanel();
		panel2.setBounds(348, 0, 342, 403);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		String path2 = "https://i.kinja-img.com/gawker-media/image/upload/s--t6HCNHV9--/c_scale,f_auto,fl_progressive,q_80,w_800/1392977328615460129.jpg";
		URL url2 = new URL(path2);
		BufferedImage image2 = ImageIO.read(url2);

		passwordField = new JPasswordField();
		passwordField.setBounds(105, 189, 201, 21);
		panel2.add(passwordField);

		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setIcon(new ImageIcon(Vregistrar.class.getResource("/imagenes/LOGIN.png")));
		btnIniciarSesion.setBounds(61, 299, 219, 58);
		panel2.add(btnIniciarSesion);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sDriver = "com.mysql.jdbc.Driver";
					Class.forName(sDriver).newInstance();
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto",
							"root", "");

					if (conexion != null) {

						JOptionPane.showMessageDialog(null, "Conectado correctamente a la base de datos");

						PreparedStatement stmt = conexion
								.prepareStatement("SELECT * FROM login WHERE usuario=? and contrasenia=? ");
						stmt.setString(1, textField.getText());
						stmt.setString(2, passwordField.getText());
						ResultSet rs = stmt.executeQuery();
						int count = 0;
						while (rs.next()) {
							count = count + 1;
						}
						if (count == 1) {
							JOptionPane.showMessageDialog(null, "INICIO DE SESION CORRECTO");
							rs.close();
							stmt.close();

							VentanaCategorias categorias = new VentanaCategorias();
							categorias.frmCategorias.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "INICIO DE SESION INCORRECTO");

						}

					}

				} catch (Exception p) {
					p.getStackTrace();
					JOptionPane.showMessageDialog(null, "NO CONECTADO A LA BASE DE DATOS");
				}
			}
		});
		JLabel imagen2 = new JLabel("");
		imagen2.setBounds(0, -26, 457, 439);
		imagen2.setIcon(new ImageIcon(image2));
		panel2.add(imagen2);

	}
}
