package logica;

import java.util.HashMap;

public class GestionTienda {

	public static void main(String[] args) {
		//Main para ir probando las clases, metodos,...

		Viideojuego v1 = new Viideojuego(3443,"uncharted 4",18,Genero.ACCIÓN ,"ubisoft","ps4","shooter");
		Viideojuego v2 = new Viideojuego(3442,"uncharted 3",18,Genero.ACCIÓN,"ubisoft","ps4","shooter");
		Viideojuego v3 = new Viideojuego(3441,"uncharted 2",18,Genero.ACCIÓN,"ubisoft","ps3","shooter");
		
		HashMap<Viideojuego, Integer > stock_juegos = new HashMap <Viideojuego, Integer>();
		
		stock_juegos.put(v1,20);
		stock_juegos.put(v2,20);
		stock_juegos.put(v3,20);
		
		GestorStock g1 = new GestorStock(stock_juegos);
		
		
		
		Cliente c1 = new Cliente ("79127270W","lucas",1998,"02/10/98","blabla bilbao",695204123,7887,"luak001","777777Le76");
		Cliente c2 = new Cliente ("79127223J","luis",1996,"15/12/96","blabla madrid",63455434,7886,"lustin","777kiiki777Le76");
		Cliente c3 = new Cliente ("78122334L","MAthew",1995,"07/9/95","blabla barcelona ",695204444,7885,"mateo334","7me llamo76");
	
		System.out.println(v1.toString()+"\n"+v2.toString()+"\n"+v3.toString());
		System.out.println(c1.toString()+"\n"+c2.toString()+"\n"+c3.toString());
		
		System.out.println(g1.buscarJuegoEnStock(v1));
		
		System.out.println(g1.sePuedeComprar(c1,v1));
		
		
		
	}

}
