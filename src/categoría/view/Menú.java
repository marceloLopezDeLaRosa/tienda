package categor�a.view;

import java.sql.SQLException;
import java.util.Scanner;

import categor�a.entity.Categor�a;
import categor�a.entity.NoExisteCategor�a;
import view.InputTypes;

public class Men� {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Categor�a");
			System.out.println("2. Listar Categor�as ");
			System.out.println("3. Eliminar Categor�a ");
			System.out.println("4. Modificar Categor�a ");
			System.out.println("5. Productos por Categor�a ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException *
	 ****************************/

	public static void men�(Scanner scanner, Categor�asIO categor�asView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categor�asView.add();
				break;
			case 2:
				categor�asView.list();
				break;
			case 3:
				try {
					categor�asView.delete();
				} catch (NoExisteCategor�a e) {
					System.out.println("No existe categor�a!");
				}
				break;

			case 4:
				try {
					categor�asView.update();
				} catch (NoExisteCategor�a e) {
					System.out.println("No existe categor�a!");
				}
				break;

			case 5:
				try {
					categor�asView.listProducts();
				} catch (NoExisteCategor�a e) {
					System.out.println("No existe categor�a!");
				}
				break;
			}
		}
	}

	/*****
	 * nuevo
	 */

	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("2. Modificar descripci�n ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Categor�a categor�a) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categor�a.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				categor�a.setDescripci�n(InputTypes.readString("Ingrese la nueva descripc�on: ", scanner));
				break;
			}
		}
	}

}
