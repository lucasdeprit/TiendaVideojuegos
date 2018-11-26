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

	private JFrame frame;
	private JTable table;
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
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
		table.setBounds(10, 11, 414, 216);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
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
