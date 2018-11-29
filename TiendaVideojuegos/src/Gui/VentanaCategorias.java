package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bd.BD;
import logica.Viideojuego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaCategorias {

	private JFrame frmCategorias;
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
		frmCategorias.setBounds(100, 100, 450, 300);
		frmCategorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCategorias.getContentPane().setLayout(null);
		
		JButton btnEstrategia = new JButton(estrategia);
		btnEstrategia.setBounds(311, 137, 113, 34);
		frmCategorias.getContentPane().add(btnEstrategia);
		
		JButton btnLucha = new JButton(lucha);
		btnLucha.setBounds(10, 137, 113, 34);
		frmCategorias.getContentPane().add(btnLucha);
		
		JButton btnAventuras = new JButton(aventuras);
		btnAventuras.setBounds(311, 11, 113, 34);
		frmCategorias.getContentPane().add(btnAventuras);
		
		JButton btnDeportes = new JButton(deportes);
		btnDeportes.setBounds(311, 74, 113, 34);
		frmCategorias.getContentPane().add(btnDeportes);
		
		JButton btnArcade = new JButton(arcade);
		btnArcade.setBounds(10, 74, 113, 34);
		frmCategorias.getContentPane().add(btnArcade);
		
		JButton btnCarreras = new JButton(carreras);
		btnCarreras.setBounds(164, 74, 113, 34);
		frmCategorias.getContentPane().add(btnCarreras);
		
		JButton button_5 = new JButton(accion);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Videojuegos videojuegos = new Videojuegos(accion);
				videojuegos.frame.setVisible(true);
				
			}

			
		});
		button_5.setBounds(10, 17, 113, 34);
		frmCategorias.getContentPane().add(button_5);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.setBounds(164, 216, 113, 34);
		frmCategorias.getContentPane().add(btnSalir);
		connection = BD.initBD("BD");
		statement = BD.CrearTablasBD(connection);
		misVideojuegos = BD.videojuegoSelect(statement);
		
	}
	/*
	private void cargarDeBD() {
		Connection con = BD.initBD( "genero.bd" );
		Statement stat = BD.CrearTablasBD( con );
		ArrayList<String> lG = BD.generoSelect( stat, "" );
		if (lG==null || lG.isEmpty()) return;  // No hay datos en tablas
		Viideojuego miVideojuego = new Viideojuego(lG.get(0));  // Crear videojuego con nombre de BD
		ArrayList<String> lGenEnBD = BD.generoSelect( stat, "" );
		for (String genero : lGenEnBD) {  // Crear generos
			miVideojuego.setGenero(genero);;
		}
	}
	*/
}
