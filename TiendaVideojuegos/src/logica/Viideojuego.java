package logica;

public class Viideojuego{

	private static int  ID;
	private static String nombre;
	//private int edad;
	private static String genero;
	//private String Marca;
	//private String plataforma;
	//private String descripcion;
	private static double precio;
	
	
	
	
	public Viideojuego() {
		super();
		ID = -1;
		this.genero = null;
		this.nombre = "";
		//this.edad = -1;
		//Marca = "";
		//this.plataforma = "";
		//this.descripcion = "";
		this.precio = -1;
	}


	public Viideojuego(String genero,int iD, String nombre, double precio) {
		super();
		this.genero = genero;
		this.ID = iD;
		this.nombre = nombre;
		this.precio = precio;
		//this.edad = edad;
		//Marca = marca;
		//this.plataforma = plataforma;
		//this.descripcion = descripcion;
	}
	
	
	public static double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public static int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public static String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}*/
	public static String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/*public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}*/


	@Override
	public String toString() {
		return "Viideojuego [genero=" + genero + ",ID=" + ID + ", nombre=" + nombre + ",  precio=" + precio + "]";
	}

	
	
	
	
	
}
