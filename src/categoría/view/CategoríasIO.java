package categor�a.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import categor�a.entity.Categor�a;
import categor�a.entity.NoExisteCategor�a;
import control.Conexi�n;
import producto.entity.Producto;
import view.InputTypes;

public class Categor�asIO {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor
	 * 
	 * @param productos *
	 ****************************/

	public Categor�asIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar categor�as *
	 ****************************/

	public void add() {
		Categor�a categor�a = Categor�aIO.ingresar(scanner);
		String sql = "Insert into Categor�a (nombre, descripci�n) " + "values(?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, categor�a.getNombre());
			conexi�n.getSentencia().setString(2, categor�a.getDescripci�n());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			;
		}
	}

	/****************************
	 * Eliminar categor�as
	 * 
	 * @throws NoExisteCategor�a *
	 ****************************/

	public void delete() throws NoExisteCategor�a {
		int codCategor�a = InputTypes.readInt("C�digo de categor�a: ", scanner);
		String sql = "delete " + "from categor�a " + "where c�digo = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codCategor�a);
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			;
		}
	}

	/****************************
	 * Modificar categor�as
	 * 
	 * @throws NoExisteCategor�a
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteCategor�a, SQLException {
		ResultSet resultSet;
		Categor�a categor�a;
		String nombre;
		String descripci�n;
		int codCategor�a = InputTypes.readInt("C�digo de categor�a: ", scanner);
		String sql = "select * from categor�a where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCategor�a);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			categor�a = new Categor�a(codCategor�a, nombre, descripci�n);
		} else {
			throw new NoExisteCategor�a();
		}

		System.out.println(categor�a);
		Men�.men�Modificar(scanner, categor�a);

		sql = "update categor�a set nombre = ?, descripci�n = ? where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, categor�a.getNombre());
		conexi�n.getSentencia().setString(2, categor�a.getDescripci�n());
		conexi�n.getSentencia().setInt(3, categor�a.getCodCategor�a());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar categor�as
	 * 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Categor�a categor�a;
		String sql = "select * from categor�a ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			categor�a = new Categor�a(resultSet.getInt("c�digo"), 
					resultSet.getString("nombre"),
					resultSet.getString("descripci�n"));
			System.out.println(categor�a);
		}
	}

	/****************************
	 * Listar categor�as .
	 * 
	 * @throws NoExisteCategor�a 
	 * @throws SQLException *
	 ****************************/

	public void listProducts() throws NoExisteCategor�a, SQLException {
		ResultSet resultSet;
		Categor�a categor�a;
		String nombre;
		String descripci�n;
		int codCategor�a = InputTypes.readInt("C�digo de categor�a: ", scanner);
		String sql = "select * from categor�a where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCategor�a);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			categor�a = new Categor�a(codCategor�a, nombre, descripci�n);
		} else {
			throw new NoExisteCategor�a();
		}
		System.out.println(categor�a);
		
		Producto producto;
		Double precio;
		int codProducto;
		
		sql = "select * from producto where c�digoCategor�a = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCategor�a);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("c�digo");
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			precio = resultSet.getDouble("precio");
			producto = new Producto(codProducto, nombre, precio, descripci�n,codCategor�a);
			System.out.println(producto);
		} else {
			throw new NoExisteCategor�a();
		}

	}


}
