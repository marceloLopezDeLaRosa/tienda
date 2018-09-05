package view;

import java.sql.SQLException;
import java.util.Scanner;

import categor�a.view.Categor�asIO;
import control.Conexi�n;
import view.InputTypes;

public class Men� {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Categor�a");
			System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException 
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		//Productos productos = new Productos(10);
		Conexi�n conexi�n = new Conexi�n("root","","Tienda");

		Categor�asIO categor�asIO = new Categor�asIO(conexi�n, scanner);
		//ProductosIO productosIO = new ProductosIO(productos, categor�as, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					categor�a.view.Men�.men�(scanner, categor�asIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				//producto.view.Men�.men�(scanner, productosIO);
				break;
		
			}
		}
		conexi�n.close();
	}
}
