package Gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Videojuegos extends JFrame {

	JFrame frame;
	JTable table;
	private String categoria;
	private ArrayList<Viideojuego> videojuegos;
	Connection connection=BD.initBD();
	private JScrollPane scrollPane;

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
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 227);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);

		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(categoria.toUpperCase().equals("ACCION")) {
						String query="select * from videojuego where genero ='ACCION'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
		});
		btnNewButton.setBounds(122, 238, 153, 12);
		frame.getContentPane().add(btnNewButton);
//
//		Connection con = BD.initBD();
//		Statement st = BD.usarBD(con);
//		videojuegos = BD.videoJuegoCategoria(st, categoria);

	}

//	private void agregarDatos() {
//
//		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
//
//
//		String datos[] = new String[4];
//		// LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST
//
//		for (Viideojuego videojuego : videojuegos) {
//			datos[0] = videojuego.getGenero();
//			datos[1] = Integer.toString(videojuego.getID());
//			datos[2] = videojuego.getNombre();
//			datos[3] = Double.toString(videojuego.getPrecio());
//			modelo.addRow(datos);
//
//		}
//
//		TableColumn colum1 = null;
//		colum1 = table.getColumnModel().getColumn(0);
//		colum1.setPreferredWidth(60);
//		TableColumn colum2 = null;
//		colum2 = table.getColumnModel().getColumn(1);
//		colum2.setPreferredWidth(5);
//		TableColumn colum3 = null;
//		colum3 = table.getColumnModel().getColumn(2);
//		colum3.setPreferredWidth(40);
//		colum3.setPreferredWidth(10);
//		TableColumn colum4 = null;
//		colum4 = table.getColumnModel().getColumn(3);
//		colum4.setPreferredWidth(10);
//
//	}
//
}
