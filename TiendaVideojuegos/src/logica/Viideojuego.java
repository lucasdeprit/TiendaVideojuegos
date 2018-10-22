package logica;

public class Viideojuego{

	private int  ID;
	private String nombre;
	private int edad;
	private Genero genero;
	private String Marca;
	private String plataforma;
	private String descripcion;
	
	
	
	
	public Viideojuego() {
		super();
		ID = -1;
		this.nombre = "";
		this.edad = -1;
		this.genero = null;
		Marca = "";
		this.plataforma = "";
		this.descripcion = "";
	}


	public Viideojuego(int iD, String nombre, int edad, Genero genero, String marca, String plataforma,
			String descripcion) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		Marca = marca;
		this.plataforma = plataforma;
		this.descripcion = descripcion;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getMarca() {
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
	}
	
	@Override
	public String toString() {
		return "Viideojuego [ID=" + ID + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", Marca="
				+ Marca + ", plataforma=" + plataforma + ", descripcion=" + descripcion + "]";
	}


	
	
	
	
	
}
