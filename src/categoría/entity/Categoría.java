package categoría.entity;

public class Categoría {
	
	private int codCategoría;
	private String nombre;
	private String descripción;
	
	public Categoría(int codCategoría, String nombre, String descripción) {
		this.codCategoría = codCategoría;
		this.nombre = nombre;
		this.descripción = descripción;
	}

	public Integer getCodCategoría() {
		return codCategoría;
	}

	public void setCodCategoría(int codCategoría) {
		this.codCategoría = codCategoría;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	@Override
	public String toString() {
		return "Categoría [codCategoría=" + codCategoría + ", nombre=" + nombre + ", descripción=" + descripción + "]";
	}

	/**********************************
	 * Métodos propios de los conjuntos
	 */
	
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Categoría categoría = (Categoría) o;
			if(this.getCodCategoría()==categoría.getCodCategoría()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodCategoría().hashCode();
	}
	

}
