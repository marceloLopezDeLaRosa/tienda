package producto.control;

import producto.entity.Producto;

public class Productos {

	private Producto[] productos;
	private int cantidad;
	private int �ltimo;

	public Productos(int tama�o) {
		productos = new Producto[tama�o];
		cantidad = 0;
		�ltimo = -1;
	}

	/****************************
	 * Ingresar un producto     *
	 ****************************/
	
	public void ingresar(Producto producto) throws  java.lang.ArrayIndexOutOfBoundsException{
		
		productos[++�ltimo] = producto;
		cantidad++;
	}

	/****************************
	 * Devuelve la cantidad de  *
	 * elementos                *
	 ****************************/
	
	
	public int getCantidad() {
		return cantidad;
	}
	

	/****************************
	 * Eliminar un producto     *
	 ****************************/
	
	public void eliminar(int codProducto) {
		int �ndice;
		�ndice = buscar(codProducto);

		if (�ndice > -1) {
			if (�ndice != �ltimo) {
				for (int i = �ndice; i <= �ltimo; i++) {
					productos[i] = productos[i + 1];
				}
			}
			�ltimo--;
			cantidad--;
		}
	}
	
	
	/****************************
	 * Buscar un   producto     *
	 ****************************/

	private int buscar(int codProducto) {
		int �ndice = -1;
		for (int i = 0; i <= �ltimo; i++) {
			if (codProducto == productos[i].getCodProducto()) {
				�ndice = i;
			}
		}
		return �ndice;
	}
	
	
	/****************************
	 * Devuelve el vector de    * 
	 * productos                *
	 ****************************/

	public Producto[] getProductos() {
		return productos;
	}
}
