package Gui;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import bd.BD;
import logica.Viideojuego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Videojuegos extends JFrame{
	
	JFrame frame;
	JTable table;
	private static Statement st;
	public static List<Viideojuego> listadevideojuegos;
	public static DefaultTableModel modelotablavideojuegos = new DefaultTableModel(null, new String[]{"Genero", "ID", "Nombre" , "Precio"}){boolean[] columnEditables = new boolean[] {
			false,false, false, false};
			public boolean isCellEditable(int row, int column) {
			return columnEditables[column];}};

	/**
	 * Create the application.
	 */
	public Videojuegos() {
		initialize();
	}
	
	private void construirTabla() {
		String titulos[]= {"Genero","ID","Nombre","Precio"};
		String informacion[][]=obtenerMatriz();
		table = new JTable(informacion,titulos);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private String[][]obtenerMatriz(){
		return null;
	}
	private void initialize() {
		frame = new JFrame();
		setResizable(false);
		setSize(460, 296);
		setAutoRequestFocus(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Genero", "ID", "Nombre", "Precio"
			}
		));
		table.setBounds(0, 0, 434, 227);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listadevideojuegos = new ArrayList<>();
				String categoria = "";
				if(categoria == "ACCION") {
				listadevideojuegos = BD.videoJuegoCategoria(st,"ACCION");
				}
				ActualizarTabla();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setBounds(122, 238, 153, 12);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void ActualizarTabla() {
		String [] campos = {null, null, null,null};
		for (int i = 0; i < listadevideojuegos.size(); i++) {
			modelotablavideojuegos.addRow(campos);
			
			Viideojuego videojuegos = listadevideojuegos.get(i);
			
			((JTable) listadevideojuegos).setValueAt(videojuegos.getGenero(), i, 0);
			((JTable) listadevideojuegos).setValueAt(videojuegos.getID(), i, 1);
			((JTable) listadevideojuegos).setValueAt(videojuegos.getNombre(), i, 2);
			((JTable) listadevideojuegos).setValueAt(videojuegos.getPrecio(), i, 3);
			
		}
}
	
}
