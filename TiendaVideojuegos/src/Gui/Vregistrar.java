package Gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Vregistrar extends JFrame{
	private JPasswordField passwordField;
	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblApellidos = new JLabel("Apellidos:");
	JTextArea nombretxt = new JTextArea();
	JTextArea apellidostxt = new JTextArea();
	JSpinner spinneredad = new JSpinner();
	JLabel lblEdad = new JLabel("Edad:");
	JLabel lblCorreo = new JLabel("Direccion correo:");
	JLabel lblNick = new JLabel("Nick:");
	JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
	JTextArea nicktxt = new JTextArea();
	JTextArea correotxt = new JTextArea();
	JButton btnAceptar = new JButton("Aceptar");
	JCheckBox checkCondiciones = new JCheckBox("Acepto que mis datos sean guardados en la base de datos");
	public void guardarDatosusuario() {
		//
		int edad;
		String texto = nombretxt.getText();
	    String nombre = "usuarios.txt";
	    try{
	      FileWriter fichero = new FileWriter("C:\\Users\\Aitor Morais\\git\\TiendaVideojuegos\\TiendaVideojuegos"+nombre);
	      //Insertamos el texto creado y si trabajamos
	      //en Windows terminaremos cada línea con "\r\n"
	      fichero.write("Nombre:"+texto + "\r\n");
	      texto=apellidostxt.getText();
	      fichero.write("Apellidos: "+texto + "\r\n");
	      texto=correotxt.getText();
	      fichero.write("Correo: "+texto + "\r\n");
	      texto=nicktxt.getText();
	      fichero.write("Nick: "+texto + "\r\n");
	      texto=passwordField.getText();
	      fichero.write("Pass: "+texto + "\r\n");
	    // edad= spinneredad.get;
	      //cerramos el fichero
	      fichero.close();

	    }catch(Exception ex){
	      ex.printStackTrace();
	    }
	}
	public Vregistrar() {
		setResizable(false);
		setSize(460,296);
		setAutoRequestFocus(false);
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		lblNombre.setBounds(32, 30, 61, 22);
		getContentPane().add(lblNombre);
		lblApellidos.setBounds(32, 56, 61, 22);
		getContentPane().add(lblApellidos);
		nombretxt.setBounds(184, 30, 109, 22);
		getContentPane().add(nombretxt);
		apellidostxt.setBounds(184, 56, 109, 22);
		getContentPane().add(apellidostxt);
		spinneredad.setModel(new SpinnerNumberModel(3, 3, 100, 1));
		spinneredad.setBounds(214, 178, 30, 22);
		getContentPane().add(spinneredad);
		lblEdad.setBounds(32, 178, 43, 22);
		getContentPane().add(lblEdad);
		lblCorreo.setBounds(32, 91, 109, 16);
		getContentPane().add(lblCorreo);
		lblNick.setBounds(32, 120, 56, 16);
		getContentPane().add(lblNick);
		lblContrasea.setBounds(23, 149, 70, 16);
		getContentPane().add(lblContrasea);
		nicktxt.setBounds(184, 117, 106, 16);
		getContentPane().add(nicktxt);
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 146, 124, 19);
		getContentPane().add(passwordField);
		correotxt.setBounds(184, 88, 109, 19);
		getContentPane().add(correotxt);
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent c) {
				guardarDatosusuario();
			}
		});
		btnAceptar.setBounds(0, 215, 97, 25);
		getContentPane().add(btnAceptar);
		checkCondiciones.setBounds(94, 215, 373, 25);
		getContentPane().add(checkCondiciones);
	}
	
	
}
