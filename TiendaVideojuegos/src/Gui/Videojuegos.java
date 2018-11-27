package Gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import bd.BD;
import logica.Viideojuego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Videojuegos extends JFrame{
	
	JFrame frame;
	JTable table;
	private String categoria ;
	private ArrayList<Viideojuego> videojuegos;
	/**
	 * Create the application.
	 */
	public Videojuegos(String categoria) {
		initialize();
		this.categoria = categoria;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setResizable(false);
		setSize(460, 296);
		frame.setSize(460, 296);
		setAutoRequestFocus(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table = new JTable();
		
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(0, 0, 434, 227);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarDatos();
			}
		});
		btnNewButton.setBounds(122, 238, 153, 12);
		frame.getContentPane().add(btnNewButton);
		
		
		Connection con = BD.initBD("videojuego");
		Statement st = BD.usarBD(con);
		videojuegos = BD.videoJuegoCategoria(st, categoria);
		
		
	}
	
	private void agregarDatos(){



		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		
		String datos[] = new String[4];
		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
		

		for (Viideojuego videojuego : videojuegos) {
			
		} {
			
			datos[0] = Viideojuego.getGenero();
			datos[1] = Integer.toString(Viideojuego.getID());
			datos[2] = Viideojuego.getNombre();
			datos[3] = Double.toString(Viideojuego.getPrecio());
			modelo.addRow(datos);
		
		modelo.addRow(datos);
		}
		TableColumn colum1 = null;
		colum1 = table.getColumnModel().getColumn(0);
		colum1.setPreferredWidth(60);
		TableColumn colum2 = null;
		colum2 = table.getColumnModel().getColumn(1);
		colum2.setPreferredWidth(5);
		TableColumn colum3 = null;
		colum3 = table.getColumnModel().getColumn(2);
		colum3.setPreferredWidth(40);
		colum3.setPreferredWidth(10);
		TableColumn colum4 = null;
		colum4 = table.getColumnModel().getColumn(3);
		colum4.setPreferredWidth(10);


		} 
	
	
}
