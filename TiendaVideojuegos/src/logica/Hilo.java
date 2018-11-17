package logica;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import Gui.VentanaPrincipal;


public class Hilo extends JFrame  {
	static int segundos = 0;
	public static Logger logger = Logger.getLogger(Hilo.class.getName()) ;
public static void espera() {
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
		// TODO: handle exception
	}
}
	
	public static void conteo() {
		for(segundos = 0 ; segundos <6;segundos++) {
			logger.setLevel(Level.INFO);
			logger.info(""+segundos);
			espera();
			if (segundos== 5) {
				logger.warning("Fin del hilo");
				
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		conteo();
	}
	

}
