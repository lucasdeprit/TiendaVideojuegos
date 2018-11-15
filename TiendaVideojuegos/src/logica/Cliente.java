package logica;

public class Cliente {

	private String DNI;
	private String nombre;
	private int num_cuenta;
	private String nom_usu;
	private String contrasenya;
	
	
	public Cliente(String dNI, String nombre, int num_cuenta, String nom_usu, String contrasenya) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.num_cuenta = num_cuenta;
		this.nom_usu = nom_usu;
		this.contrasenya = contrasenya;
	}

	public Cliente() {
		super();
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNum_cuenta() {
		return num_cuenta;
	}
	public void setNum_cuenta(int num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	public String getNom_usu() {
		return nom_usu;
	}
	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", num_cuenta=" + num_cuenta + ", nom_usu=" + nom_usu
				+ ", contrasenya=" + contrasenya + "]";
	}

	
	

}
