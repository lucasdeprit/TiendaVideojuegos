package logica;

import java.util.HashMap;

public class GestorStock implements SePuedeComprar{

	
	
	private HashMap<Viideojuego, Integer > stock_juegos;
	
	
	public GestorStock(HashMap<Viideojuego, Integer> stock_juegos) {
		super();
		this.stock_juegos = stock_juegos;
	}

	public HashMap<Viideojuego, Integer> getStock_juegos() {
		return stock_juegos;
	}

	public void setStock_juegos(HashMap<Viideojuego, Integer> stock_juegos) {
		this.stock_juegos = stock_juegos;
	}
	
	@Override
	public String toString() {
		return "GestorStock [stock_juegos=" + stock_juegos + "]";
	}
	

	
	//metodos para la gestión del stock
	
	
	

	public int  buscarJuegoEnStock (Viideojuego v){
		
		int i = stock_juegos.get(v);
		
		return i;
	
	}
	
	@Override
	public boolean sePuedeComprar(Cliente c , Viideojuego v) {
		// se comprueba que el cliente cumpla ciertos requisitos para comprar el juego
		//tambien se comprueba si e juego se encuentra en stock
		if(buscarJuegoEnStock(v)>= 1){
			
			return true;
		}
		return false;
	}


	@Override
	public boolean sePuedeAlquilar(Cliente c) {
		// se comprueba que el cliente cumpla los requisitos minimos para poder alquilar cierto juego
		//como pueden ser: Tener la suscripcion, tener la edad adecuada para el juego,...
			return true;
		
	}
	
	
	
	
}
