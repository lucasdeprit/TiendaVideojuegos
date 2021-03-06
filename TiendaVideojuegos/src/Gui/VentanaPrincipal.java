package Gui;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logica.CompruebaInactividad;
import logica.NotifyingThread;
import logica.ThreadCompleteListener;
import java.awt.Toolkit;;

public class VentanaPrincipal extends JFrame implements ActionListener, ThreadCompleteListener {
	private JButton boton2;
	NotifyingThread hilo;
	boolean hayActividad;
	static VentanaPrincipal V;

	public VentanaPrincipal() throws IOException {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/Logo.jpg")));
		configurarVentana();
		inicializarComponentes();
	}

	private void configurarVentana() {
		this.setTitle(" Ventana Principal ");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void inicializarComponentes() throws IOException {
		getContentPane().setLayout(null);

		JPanel panelimagen = new JPanel();
		panelimagen.setBounds(0, 0, 494, 471);
		getContentPane().add(panelimagen);
		panelimagen.setLayout(null);
		boton2 = new JButton();
		boton2.setBounds(143, 430, 200, 30);
		panelimagen.add(boton2);
		boton2.setText("ENTRAR");
		boton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				Vregistrar registro;
				try {
					registro = new Vregistrar();
					registro.setVisible(true);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// registro.setResizable(false);

				hayActividad = true;
			}
		});
		;
		String path = "http://sae7berita-info.com/wp-content/uploads/2018/06/Asus-ROG-republic-of-gamers-logo-1068x668.jpg";
		URL url = new URL(path);
		BufferedImage image = ImageIO.read(url);
		JLabel mostrar_imagen = new JLabel("");
		mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		mostrar_imagen.setIcon(new ImageIcon(image));
		mostrar_imagen.setBounds(0, 0, 494, 471);
		// mostrar_imagen.setVisible(true);
		// mostrar_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		panelimagen.add(mostrar_imagen);
		hilo = new CompruebaInactividad(10);
		hilo.addListener(this); // add ourselves as a listener
		hilo.start(); // Start the Thread

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				hilo.interrupt();
			}
		});

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, " Inicio de Sesion " + ".");

	}

	public static void main(String[] args) {

		try {
			V = new VentanaPrincipal();
			V.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// creamos la ventana
		// conteo(V);
		// hacemos la ventana visible

	}

	@Override
	public void notifyOfThreadComplete(Thread thread) {

		if (!hayActividad) {
			V.dispose();
			System.out.println(hayActividad);
		} else {
			V.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}
}