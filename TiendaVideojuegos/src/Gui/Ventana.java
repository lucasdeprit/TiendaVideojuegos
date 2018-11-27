package Gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import logica.Pool;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Ventana extends JFrame {
	private JButton aceptar,boton2;
	private JPanel fondo;
	private JPasswordField pass;
	JTextArea nombreUsuario ;
	Pool metodospool = new Pool();
	
	



	

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

//cargar
	public int validar_ingreso() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
	    String usuario = nombreUsuario.getText();
	    String clave = String.valueOf(pass.getPassword());

	    int resultado=0;
	    
	    String SSQL="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave=sha1('"+clave+"')";

	    Connection conect = null;

	    try {
	    	//
	    	String sDriver = "com.mysql.jdbc.Driver";
			Class.forName(sDriver).newInstance();
			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/registros", "root",
					"");
	        Statement st = conect.createStatement();
	        ResultSet rs = st.executeQuery(SSQL);

	        if(rs.next()){

	            resultado=1;

	        }

	    } catch (SQLException ex) {

	        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

	    }finally{


	        try {

	            conect.close();

	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

	        }

	    }

	return resultado;

	}
	
	//

	public Ventana() {
		setFont(null);
		setTitle("Log");
		setBounds(50, 20, 293, 196);
		//setSize(287, 219);
		fondo=new JPanel();
		fondo.setBackground(Color.LIGHT_GRAY);
		setContentPane(fondo);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent click) {
				String nombre;
				String contrasena;
				nombre=nombreUsuario.getText();
				contrasena=pass.getText();
				if(nombre==""|| nombre == null||contrasena.length()<8||contrasena==null||contrasena=="") {
					JOptionPane.showMessageDialog(null, "Nombre y/o contraseña incorrectos", "Error en el Loggin", JOptionPane.WARNING_MESSAGE);
					setVisible(false);
					dispose();
					//VentanaCategorias categorias= new VentanaCategorias();
					//categorias.categorias;
					//categorias.setVisible(true);
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
		
		JLabel Usuariolbl = new JLabel("Usuario:");
		Usuariolbl.setBounds(50, 11, 79, 25);
		fondo.add(Usuariolbl);
		
		JLabel passlbl = new JLabel("Contrase\u00F1a");
		passlbl.setBounds(50, 49, 72, 25);
		fondo.add(passlbl);
		
		
	}
	
		public void actionPerformed(ActionEvent e) {
		}
	}
		


