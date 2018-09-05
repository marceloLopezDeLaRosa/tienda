package producto.view;

import java.util.Scanner;

import categor�a.control.Categor�as;
import categor�a.entity.NoExisteCategor�a;

import producto.entity.Producto;
import view.InputTypes;

public class ProductoIO {

	/****************************
	 * Registro de producto 
	 * @throws NoExisteCategor�a *
	 ****************************/

	public static Producto ingresar(Scanner scanner,Categor�as categor�as) throws NoExisteCategor�a {
				
		int codProducto = InputTypes.readInt("Ingrese el c�digo del producto", scanner);
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);
		
		
		
		int codCategor�a = InputTypes.readInt("C�digo Categor�a: ", scanner);
		
		categor�as.buscar(codCategor�a);
		
		return new Producto(codProducto, nombreProducto, precio, descripci�n, codCategor�a);

	}

}
