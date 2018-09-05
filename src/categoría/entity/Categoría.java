package categor�a.entity;

public class Categor�a {
	
	private int codCategor�a;
	private String nombre;
	private String descripci�n;
	
	public Categor�a(int codCategor�a, String nombre, String descripci�n) {
		this.codCategor�a = codCategor�a;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
	}

	public Integer getCodCategor�a() {
		return codCategor�a;
	}

	public void setCodCategor�a(int codCategor�a) {
		this.codCategor�a = codCategor�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	@Override
	public String toString() {
		return "Categor�a [codCategor�a=" + codCategor�a + ", nombre=" + nombre + ", descripci�n=" + descripci�n + "]";
	}

	/**********************************
	 * M�todos propios de los conjuntos
	 */
	
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Categor�a categor�a = (Categor�a) o;
			if(this.getCodCategor�a()==categor�a.getCodCategor�a()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodCategor�a().hashCode();
	}
	

}
