package logica;

public class Cliente {

	private String DNI;
	private String nombre;
	private int año_nac;
	private String fecha_nac;
	private String direccion;
	private int telefono;
	private int num_cuenta;
	private String nom_usu;
	private String contrasenya;
	
	
	
	public Cliente() {
		super();
		DNI = "";
		this.nombre = "";
		this.año_nac = -1;
		this.fecha_nac = "";
		this.direccion = "";
		this.telefono = -1;
		this.num_cuenta = -1;
		this.nom_usu = "";
		this.contrasenya = "";
	}
	
	
	public Cliente(String dNI, String nombre, int año_nac, String fecha_nac, String direccion, int telefono,
			int num_cuenta, String nom_usu, String contrasenya) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.año_nac = año_nac;
		this.fecha_nac = fecha_nac;
		this.direccion = direccion;
		this.telefono = telefono;
		this.num_cuenta = num_cuenta;
		this.nom_usu = nom_usu;
		this.contrasenya = contrasenya;
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
	public int getAño_nac() {
		return año_nac;
	}
	public void setAño_nac(int año_nac) {
		this.año_nac = año_nac;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", año_nac=" + año_nac + ", fecha_nac=" + fecha_nac
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", num_cuenta=" + num_cuenta + ", nom_usu="
				+ nom_usu + ", contrasenya=" + contrasenya + "]";
	}	
	
}
