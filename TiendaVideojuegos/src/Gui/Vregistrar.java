package Gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import bd.BD;
import logica.Hilo;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vregistrar extends JFrame{
	private Connection conexion;
	public static Logger logger = Logger.getLogger(Vregistrar.class.getName()) ;
	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblApellidos = new JLabel("Apellidos:");
	JLabel lblEdad = new JLabel("Edad:");
	JLabel lblCorreo = new JLabel("Direccion correo:");
	JLabel lblNick = new JLabel("Nick:");
	JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
	JButton btnAceptar = new JButton("Aceptar");
	JCheckBox checkCondiciones = new JCheckBox("Acepto que mis datos sean guardados en la base de datos");
	private JTextField Nombre;
	private JTextField Apellidos;
	private JTextField Edad;
	private JTextField DireccionCorreo;
	private JTextField Nick;
	private JTextField Contrasena;

	public void Enviar_datos() {
		
		try {
			
			java.sql.Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/registros", "root", "");
			
			
			String nombre = Nombre.getText();
			String apellidos = Apellidos.getText();
			String edad = Edad.getText();
			String correo = DireccionCorreo.getText();
			String nick = Nick.getText();
			String contrasena = Contrasena.getText();
			
			String consulta = "INSERT INTO registros(NOMBRE,APELLIDOS,EDAD,CORREO ELECTRONICO,NICK,CONTRASEÑA) VALUES('"+nombre+ "','"+apellidos+ "', '"+edad+"', '"+correo+ "', '"+nick+ "','"+contrasena+ "')";
			
			Statement stmt = conexion.createStatement();
			
			stmt.executeUpdate(consulta);
			
			JOptionPane.showMessageDialog(null, "Producto agregado");
			
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Producto no agregado");
		}
	}
	
//	public void guardarDatosusuario() {
//		//
//		int edad;
//		String texto = nombretxt.getText();
//	    String nombre = "usuarios.txt";
//	    try{
//	      FileWriter fichero = new FileWriter("C:\\Users\\Joel\\git\\TiendaVideojuegos\\TiendaVideojuegos"+nombre);
//	      //Insertamos el texto creado y si trabajamos
//	      //en Windows terminaremos cada línea con "\r\n"
//	      fichero.write("Nombre:"+texto + "\r\n");
//	      texto=apellidostxt.getText();
//	      fichero.write("Apellidos:"+texto + "\r\n");
//	      texto=correotxt.getText();
//	      fichero.write("Correo:"+texto + "\r\n");
//	      texto=nicktxt.getText();
//	      fichero.write("Nick:"+texto + "\r\n");
//	      texto=passwordField.getText();
//	      fichero.write("Pass:"+texto + "\r\n");
//	    // edad= spinneredad.get;
//	      //cerramos el fichero
//	      fichero.close();
//
//	    }catch(Exception ex){
//	      ex.printStackTrace();
//	    }
//	}
	public Vregistrar() {
		setResizable(false);
		setSize(460,296);
		setAutoRequestFocus(false);
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		lblNombre.setBounds(32, 30, 61, 22);
		getContentPane().add(lblNombre);
		lblApellidos.setBounds(32, 56, 61, 22);
		getContentPane().add(lblApellidos);
		lblEdad.setBounds(32, 87, 43, 22);
		getContentPane().add(lblEdad);
		lblCorreo.setBounds(32, 120, 109, 16);
		getContentPane().add(lblCorreo);
		lblNick.setBounds(32, 147, 56, 16);
		getContentPane().add(lblNick);
		lblContrasea.setBounds(32, 174, 70, 16);
		getContentPane().add(lblContrasea);
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent c) {
//				try {
//					java.sql.Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/registros", "root", "");
//					
//					if(conexion!=null) {
//						System.out.println("Conectado correctamente a la base de datos");
//						System.out.println("Almacenado en base de datos");
//					}
//				}catch(Exception e) {
//					e.getStackTrace();
//					System.out.println("Error al conectar a la base de datos");
//				}
				Enviar_datos();
				
			}
		});
		btnAceptar.setBounds(0, 215, 97, 25);
		getContentPane().add(btnAceptar);
		checkCondiciones.setBounds(94, 215, 373, 25);
		getContentPane().add(checkCondiciones);
		
		Nombre = new JTextField();
		Nombre.setBounds(184, 29, 109, 22);
		getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		Apellidos = new JTextField();
		Apellidos.setBounds(184, 57, 201, 20);
		getContentPane().add(Apellidos);
		Apellidos.setColumns(10);
		
		Edad = new JTextField();
		Edad.setBounds(184, 88, 28, 20);
		getContentPane().add(Edad);
		Edad.setColumns(10);
		
		DireccionCorreo = new JTextField();
		DireccionCorreo.setBounds(184, 118, 201, 20);
		getContentPane().add(DireccionCorreo);
		DireccionCorreo.setColumns(10);
		
		Nick = new JTextField();
		Nick.setColumns(10);
		Nick.setBounds(184, 145, 201, 20);
		getContentPane().add(Nick);
		
		Contrasena = new JTextField();
		Contrasena.setColumns(10);
		Contrasena.setBounds(184, 172, 201, 20);
		getContentPane().add(Contrasena);
		
//		try {
//			java.sql.Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/registros", "root", "");
//			
//			if(conexion!=null) {
//				JOptionPane.showInputDialog(null,"Conectado correctamente a la base de datos");
//			}
//		}catch(Exception e) {
//			e.getStackTrace();
//			JOptionPane.showInputDialog(null,"Error al conectar a la base de datos");
//		}
		
		
		
	}
}
