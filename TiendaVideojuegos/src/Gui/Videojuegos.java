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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import bd.BD;
import logica.Viideojuego;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class Videojuegos extends JFrame {

	JFrame frame;
	JTable table;
	private String categoria;
	private ArrayList<Viideojuego> videojuegos;
	Connection connection=BD.initBD();
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNew;
	DefaultListModel DLM = new DefaultListModel ();

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
		setSize(800, 600);
		frame.setSize(1238, 626);
		setAutoRequestFocus(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 784, 535);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);

		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(categoria.toUpperCase().equals("ACCION")) {
						String query="select * from videojuego where genero ='ACCION'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} if(categoria.toUpperCase().equals("CARRERAS")) {
						String query="select * from videojuego where genero ='CONDUCCION'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}if(categoria.toUpperCase().equals("ARCADE")) {
						String query="select * from videojuego where genero ='ARCADE'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}if(categoria.toUpperCase().equals("DEPORTES")) {
						String query="select * from videojuego where genero ='DEPORTES'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(categoria.toUpperCase().equals("AVENTURAS")) {
						String query="select * from videojuego where genero ='AVENTURAS'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}if(categoria.toUpperCase().equals("LUCHA")) {
						String query="select * from videojuego where genero ='LUCHA'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}if(categoria.toUpperCase().equals("ESTRATEGIA")) {
						String query="select * from videojuego where genero ='ESTRATEGIA'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
		});
		btnNewButton.setBounds(82, 538, 198, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("a\u00F1adir al carrito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				list.setModel(DLM);
				String nombreJuego = "";
				DLM.addElement(nombreJuego);
				
				
				
				try {
					File file = new File("recursos//TotalCompraRealizada.txt");
					if(!file.exists()) {
						file.createNewFile();
					}
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i=0; i<table.getRowCount();i++) {
						for(int j=0; j<table.getColumnCount();j++) {
							bw.write(table.getModel().getValueAt(i, j).toString()+"");
						}
						bw.write("\n,________\n,");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Total Compra Realizada");
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(372, 538, 260, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		list = new JList();
		list.setBounds(836, 64, 305, 471);
		frame.getContentPane().add(list);
		
		lblNew = new JLabel("CARRITO:");
		lblNew.setBounds(836, 16, 94, 20);
		frame.getContentPane().add(lblNew);
		
//
//		Connection con = BD.initBD();
//		Statement st = BD.usarBD(con);
//		videojuegos = BD.videoJuegoCategoria(st, categoria);

	}
}
