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

public class VentanaCategorias {

	private JFrame frmCategorias;
	private Viideojuego miVideojuego;
	
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCategorias = new JFrame();
		frmCategorias.setTitle("CATEGORIAS");
		frmCategorias.setBounds(100, 100, 450, 300);
		frmCategorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCategorias.getContentPane().setLayout(null);
		
		JButton btnEstrategia = new JButton("ESTRATEGIA");
		btnEstrategia.setBounds(311, 137, 113, 34);
		frmCategorias.getContentPane().add(btnEstrategia);
		
		JButton btnLucha = new JButton("LUCHA");
		btnLucha.setBounds(10, 137, 113, 34);
		frmCategorias.getContentPane().add(btnLucha);
		
		JButton btnAventuras = new JButton("AVENTURAS");
		btnAventuras.setBounds(311, 11, 113, 34);
		frmCategorias.getContentPane().add(btnAventuras);
		
		JButton btnDeportes = new JButton("DEPORTES");
		btnDeportes.setBounds(311, 74, 113, 34);
		frmCategorias.getContentPane().add(btnDeportes);
		
		JButton btnArcade = new JButton("ARCADE");
		btnArcade.setBounds(10, 74, 113, 34);
		frmCategorias.getContentPane().add(btnArcade);
		
		JButton btnCarreras = new JButton("CARRERAS");
		btnCarreras.setBounds(164, 74, 113, 34);
		frmCategorias.getContentPane().add(btnCarreras);
		
		JButton button_5 = new JButton("ACCION");
		button_5.setBounds(10, 17, 113, 34);
		frmCategorias.getContentPane().add(button_5);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSalir.setBounds(164, 216, 113, 34);
		frmCategorias.getContentPane().add(btnSalir);
	}
	
	private void cargarDeBD() {
		// tarea 3
		Connection con = BD.initBD( "genero.bd" );
		Statement stat = BD.CrearTablasBD( con );
		ArrayList<String> lH = BD.generoSelect( stat, "" );
		if (lH==null || lH.isEmpty()) return;  // No hay datos en tablas
		miVideojuego = new Viideojuego( lH.get(0) );  // Crear hotel con nombre de BD
		ArrayList<String> lHabsEnBD = BD.habitacionSelect( stat, miHotel, "" );
		for (String hab : lHabsEnBD) {  // Crear habitaciones
			miVideojuego.addHabitacion( hab );
			ArrayList<RangoFechas> lResEnBD = BD.reservaSelect( stat, miHotel, hab, "" );
			for (RangoFechas rf : lResEnBD) {  // Crear reservas
				miHotel.addReserva( hab, rf );
			}
		}
	}
}
