package logica;

import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.JFrame;

import Gui.VentanaPrincipal;

public class Hilo extends JFrame  {
	static int segundos = 0;
public static void espera() {
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
		// TODO: handle exception
	}
}
	
	public static void conteo(VentanaPrincipal v) {
		for(segundos = 0 ; segundos <6;segundos++) {
			System.out.println(segundos);
			espera();
			if (segundos== 5) {
				v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		
		
	}
	

}
