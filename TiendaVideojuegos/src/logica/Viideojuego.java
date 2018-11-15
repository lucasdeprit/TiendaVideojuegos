package logica;

public class Viideojuego{

	private int  ID;
	private String nombre;
	//private int edad;
	private String genero;
	//private String Marca;
	//private String plataforma;
	//private String descripcion;
	private double precio;
	
	
	
	
	public Viideojuego() {
		super();
		ID = -1;
		this.nombre = "";
		//this.edad = -1;
		this.genero = null;
		//Marca = "";
		//this.plataforma = "";
		//this.descripcion = "";
		this.precio = -1;
	}


	public Viideojuego(int iD, String nombre, String genero, double precio) {
		super();
		ID = iD;
		this.nombre = nombre;
		//this.edad = edad;
		this.genero = genero;
		//Marca = marca;
		//this.plataforma = plataforma;
		//this.descripcion = descripcion;
		this.precio = precio;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
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
	public String getGenero() {
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
		return "Viideojuego [ID=" + ID + ", nombre=" + nombre + ", genero=" + genero + " , precio=" + precio +"]";
	}


	
	
	
	
	
}
