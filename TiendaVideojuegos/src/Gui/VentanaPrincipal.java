package Gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JLabel texto;
	private JButton boton, boton2;
	
	public VentanaPrincipal() {
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
	
	private void inicializarComponentes() {
	boton = new JButton();
	boton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent click) {
			Ventana inicio= new Ventana();
			inicio.setResizable(false);
			inicio.setVisible(true);
		}
	});
	boton.setBounds(39, 406, 200, 30);
	boton2 = new JButton();
	boton2.setBounds(260, 406, 200, 30);
	boton.setText("Iniciar Sesion");
	boton2.setText("Registrarse");
	boton2.addActionListener(this);
	getContentPane().setLayout(null);
	getContentPane().add(boton);
	getContentPane().add(boton2);
	
	JPanel panelimagen = new JPanel();
	panelimagen.setBounds(0, 0, 494, 471);
	getContentPane().add(panelimagen);
	panelimagen.setLayout(null);
	// crear los componentes
	
	texto = new JLabel();
	texto.setBounds(190, 175, 100, 25);
	panelimagen.add(texto);
	texto.setBackground(Color.WHITE);
	texto.setForeground(Color.WHITE);
	texto.setFont(new Font("Tahoma", Font.PLAIN, 24));
	texto.setHorizontalAlignment(SwingConstants.CENTER);
	
	// configuramos los componentes
	
	texto.setText("INICIO");
	
	JLabel mostrar_imagen = new JLabel("");
	mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
	mostrar_imagen.setIcon(new ImageIcon("C:\\Users\\Aitor Morais\\git\\TiendaVideojuegos\\TiendaVideojuegos\\src\\Gui\\Gui_imagenes\\HC_videojuegos-050917-1.jpg"));
	mostrar_imagen.setBounds(0, 0, 494, 471);
	//mostrar_imagen.setVisible(true);
	//mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
	panelimagen.add(mostrar_imagen);
	
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, " Inicio de Sesion " +   ".");
		
	}

	
	public static void main(String[] args) {
		VentanaPrincipal V = new VentanaPrincipal(); // creamos la ventana	
		V.setVisible(true);							 // hacemos la ventana visible
	}
}
