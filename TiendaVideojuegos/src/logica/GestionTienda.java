             package logica;

import java.util.HashMap;

public class GestionTienda {

	public static void main(String[] args) {
		//Main para ir probando las clases, metodos,...

		Viideojuego v1 = new Viideojuego(3443,"uncharted 4","ACCIÓN" ,60);
		Viideojuego v2 = new Viideojuego(3442,"uncharted 3","ACCION",25);
		Viideojuego v3 = new Viideojuego(3441,"uncharted 2","ACCION",15);
		HashMap<Viideojuego, Integer > stock_juegos = new HashMap <Viideojuego, Integer>();
		
		stock_juegos.put(v1,20);
		stock_juegos.put(v2,20);
		stock_juegos.put(v3,20);
		
		GestorStock g1 = new GestorStock(stock_juegos);
		
		
		
		Cliente c1 = new Cliente ("79127270W","lucas",1998,"02/10/98","blabla bilbao");
		Cliente c2 = new Cliente ("79127223J","luis",1996,"15/12/96","blabla madrid");
		Cliente c3 = new Cliente ("78122334L","MAthew",1995,"07/9/95","blabla barcelona ");
	
		System.out.println(v1.toString()+"\n"+v2.toString()+"\n"+v3.toString());
		System.out.println(c1.toString()+"\n"+c2.toString()+"\n"+c3.toString());
		
		System.out.println(g1.buscarJuegoEnStock(v1));
		
		System.out.println(g1.sePuedeComprar(c1,v1));
		
		System.out.println("CAMBIO DE PRUEBA");
		
	}

	
	
}
