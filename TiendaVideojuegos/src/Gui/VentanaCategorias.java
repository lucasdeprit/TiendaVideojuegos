package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bd.BD;
import logica.Viideojuego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class VentanaCategorias {

	JFrame frmCategorias;
	private ArrayList<Viideojuego> misVideojuegos;
	private Connection connection;
	private Statement statement;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategorias window = new VentanaCategorias();
					window.frmCategorias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCategorias() {
		initialize();
	}
	
	private static final String accion = "ACCION";
	private static final String estrategia = "ESTRATEGIA";
	private static final String lucha = "LUCHA";
	private static final String aventuras = "AVENTURAS";
	private static final String deportes = "DEPORTES";
	private static final String arcade = "ARCADE";
	private static final String carreras = "CARRERAS";
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCategorias = new JFrame();
		frmCategorias.setTitle("CATEGORIAS");
		frmCategorias.setSize(751, 482);
		frmCategorias.setLocationRelativeTo(null);
		frmCategorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCategorias.getContentPane().setLayout(null);
		
		JButton btnEstrategia = new JButton("");
		btnEstrategia.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/ESTRATEGIA.png")));
		btnEstrategia.setBounds(480, 156, 217, 120);
		frmCategorias.getContentPane().add(btnEstrategia);
		btnEstrategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(estrategia);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton btnLucha = new JButton(lucha);
		btnLucha.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/descarga.jpg")));
		btnLucha.setBackground(Color.WHITE);
		btnLucha.setForeground(Color.WHITE);
		btnLucha.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLucha.setBounds(15, 16, 217, 120);
		frmCategorias.getContentPane().add(btnLucha);
		btnLucha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(lucha);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton btnAventuras = new JButton("");
		btnAventuras.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/AVENTURAS2.jpg")));
		btnAventuras.setBounds(247, 156, 217, 120);
		frmCategorias.getContentPane().add(btnAventuras);
		btnAventuras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(aventuras);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton btnDeportes = new JButton("");
		btnDeportes.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/DEPORTES.png")));
		btnDeportes.setBounds(247, 292, 217, 120);
		frmCategorias.getContentPane().add(btnDeportes);
		btnDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(deportes);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton btnArcade = new JButton("");
		btnArcade.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/ARCADE.jpg")));
		btnArcade.setBounds(247, 16, 217, 120);
		frmCategorias.getContentPane().add(btnArcade);
		btnArcade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(arcade);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton btnCarreras = new JButton("");
		btnCarreras.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/CARRERAS.png")));
		btnCarreras.setForeground(Color.WHITE);
		btnCarreras.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnCarreras.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCarreras.setBounds(15, 152, 217, 120);
		frmCategorias.getContentPane().add(btnCarreras);
		btnCarreras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(carreras);
				videojuegos.frame.setVisible(true);
			}
		});
		
		JButton button_5 = new JButton(accion);
		button_5.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/ACCION.jpg")));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(accion);
				videojuegos.frame.setVisible(true);
			}
		});
		button_5.setBounds(480, 16, 217, 120);
		frmCategorias.getContentPane().add(button_5);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/SALIR2.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.setBounds(595, 307, 119, 103);
		frmCategorias.getContentPane().add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/imagenes/Fondo gris 2.jpg")));
		lblNewLabel.setBounds(-20, -11, 763, 459);
		frmCategorias.getContentPane().add(lblNewLabel);
		connection = BD.initBD();
		statement = BD.CrearTablasBD(connection);
		misVideojuegos = BD.videojuegoSelect(statement);
		
	}
	
}

