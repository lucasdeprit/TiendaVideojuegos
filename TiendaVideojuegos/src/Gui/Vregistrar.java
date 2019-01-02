package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import bd.BD;
import logica.CompruebaInactividad;
import logica.NotifyingThread;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vregistrar extends JFrame {

	public Connection conexion;

	public static Logger logger = Logger.getLogger(Vregistrar.class.getName());


	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblApellidos = new JLabel("Apellidos:");
	JLabel lblEdad = new JLabel("Edad:");
	JLabel lblCorreo = new JLabel("Direccion correo:");
	JLabel lblNick = new JLabel("Nick:");
	JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
	JButton btnAceptar = new JButton("REGISTRARME");
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
			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto" , "root" , "");

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

	public Vregistrar() {
		setResizable(false);
		setSize(696, 432);
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent c) {
				if (checkCondiciones.isSelected()) {
					Enviar_datos();
				}
				else {
					logger.warning("No has aceptado las condiciones");
				}
				
			}
		});
		btnAceptar.setBounds(76, 292, 135, 59);
		getContentPane().add(btnAceptar);
		checkCondiciones.setBounds(10, 240, 373, 25);
		getContentPane().add(checkCondiciones);

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
		label.setBounds(376, 220, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setBounds(362, 262, 70, 16);
		getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(440, 260, 201, 21);
		getContentPane().add(passwordField);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {

							String sDriver = "com.mysql.jdbc.Driver";
							Class.forName(sDriver).newInstance();
							java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto" , "root" , "");

							if (conexion != null) {

								JOptionPane.showMessageDialog(null, "Conectado correctamente a la base de datos");

								PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM login WHERE usuario=? and contrasenia=? ");
								stmt.setString(1, textField.getText() );
								stmt.setString(2, passwordField.getText() );
								ResultSet rs = stmt.executeQuery();
								int count = 0;
								while(rs.next()) {
									count= count + 1;
								}
								if(count==1) {
									JOptionPane.showMessageDialog(null, "INICIO DE SESION CORRECTO");
								}else {
									JOptionPane.showMessageDialog(null, "INICIO DE SESION INCORRECTO");
								}
								rs.close();
								stmt.close();
							}

						} catch (Exception p) {
							p.getStackTrace();
							JOptionPane.showMessageDialog(null, "NO CONECTADO A LA BASE DE DATOS");
						}
			}
		});
			
		btnIniciarSesion.setBounds(451, 292, 135, 59);
		getContentPane().add(btnIniciarSesion);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(440, 218, 201, 20);
		getContentPane().add(textField);


	}
		}
