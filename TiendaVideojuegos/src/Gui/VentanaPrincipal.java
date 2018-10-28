package Gui;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JButton boton, boton2;
	
	public VentanaPrincipal() throws IOException {
		super();
		configurarVentana();
		inicializarComponentes();
	}

	private void configurarVentana() {
		this.setTitle(" Ventana Principal ");
		this.setSize(500 , 500 );
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void inicializarComponentes() throws IOException {
	getContentPane().setLayout(null);
	
	JPanel panelimagen = new JPanel();
	panelimagen.setBounds(0, 0, 494, 471);
	getContentPane().add(panelimagen);
	panelimagen.setLayout(null);
	boton2 = new JButton();
	boton2.setBounds(260, 430, 200, 30);
	panelimagen.add(boton2);
	boton2.setText("Registrarse");
	boton2.addActionListener(this);
	boton = new JButton();
	boton.setBounds(35, 430, 200, 30);
	panelimagen.add(boton);
	boton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent click) {
			Ventana inicio= new Ventana();
			inicio.setResizable(false);
			inicio.setVisible(true);
		}
	});
	boton.setText("Iniciar Sesion");
	String path = "http://sae7berita-info.com/wp-content/uploads/2018/06/Asus-ROG-republic-of-gamers-logo-1068x668.jpg";
	URL url = new URL(path);
	BufferedImage image = ImageIO.read(url);
	JLabel mostrar_imagen = new JLabel("");
	mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
	mostrar_imagen.setIcon(new ImageIcon(image));
	mostrar_imagen.setBounds(0, 0, 494, 471);
	//mostrar_imagen.setVisible(true);
	//mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
	panelimagen.add(mostrar_imagen);
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, " Inicio de Sesion " +   ".");
		
	}
	public static void main(String[] args) throws IOException {
		VentanaPrincipal V = new VentanaPrincipal(); // creamos la ventana	
		V.setVisible(true);							 // hacemos la ventana visible
	}
}

