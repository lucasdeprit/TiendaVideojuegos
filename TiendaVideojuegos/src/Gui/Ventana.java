package Gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame {
	
	private JTextField Usuariotxt,Passtxt;
	private JButton aceptar,boton2;
	private JPanel fondo;
	private JPasswordField pass;
	JTextArea nombreUsuario ;
	
	public JTextField getUsuariotxt() {
		return Usuariotxt;
	}

	public void setUsuariotxt(JTextField usuariotxt) {
		Usuariotxt = usuariotxt;
	}

	public JTextField getPasstxt() {
		return Passtxt;
	}

	public void setPasstxt(JTextField passtxt) {
		Passtxt = passtxt;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JButton getBoton2() {
		return boton2;
	}

	public void setBoton2(JButton boton2) {
		this.boton2 = boton2;
	}

	public JPanel getFondo() {
		return fondo;
	}

	public void setFondo(JPanel fondo) {
		this.fondo = fondo;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}

	public Ventana() {
		setFont(null);
		setTitle("Log");
		setBounds(50, 20, 293, 196);
		//setSize(287, 219);
		fondo=new JPanel();
		fondo.setBackground(SystemColor.desktop);
		setContentPane(fondo);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Pendiente hilo aqui.
		Usuariotxt= new JTextField();
		Usuariotxt.setEditable(false);
		Usuariotxt.setLocation(50, 10);
		Usuariotxt.setSize(new Dimension(79, 25));
		Usuariotxt.setText("Usuario:");
		fondo.add(Usuariotxt);
		Passtxt= new JTextField();
		Passtxt.setEditable(false);
		Passtxt.setBounds(50, 40, 79, 25);
		Passtxt.setText("Contrase\u00F1a:");
		fondo.add(Passtxt);
		aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				String nombre;
				String contrasena;
				nombre=nombreUsuario.getText();
				contrasena=pass.getText();
				if(nombre==""|| nombre == null||contrasena.length()<8||contrasena==null||contrasena=="") {
					System.out.println("Nombre o contraseña incorrectos vuelva a introducirlos...");
					
				}
				System.out.println(nombre+contrasena);
				
				
				
			}
		});
		aceptar.setBounds(50, 110, 160, 25);
		aceptar.setText("OK");
		fondo.add(aceptar);
		
		pass = new JPasswordField();
		pass.setBounds(164, 40, 91, 24);
		fondo.add(pass);
		
		nombreUsuario=new JTextArea();
		nombreUsuario.setBounds(164, 11, 91, 25);
		fondo.add(nombreUsuario);
		
		
	}
	
		public void actionPerformed(ActionEvent e) {
		}
	}
		


