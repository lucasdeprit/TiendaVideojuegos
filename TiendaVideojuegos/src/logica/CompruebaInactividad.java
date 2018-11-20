package logica;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.text.Document;

import org.omg.CORBA.TIMEOUT;

import Gui.VentanaPrincipal;


public class CompruebaInactividad extends  NotifyingThread  {
	static int segundos;
	public static Logger logger = Logger.getLogger(CompruebaInactividad.class.getName()) ;
	public boolean hayActividad;
	public CompruebaInactividad(int segundos) {
		this.segundos = segundos;
	}
	@Override
	public void doRun() {
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	
	

}
