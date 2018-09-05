package categor�a.control;

import java.util.HashSet;
import java.util.Iterator;

import categor�a.entity.Categor�a;
import categor�a.entity.NoExisteCategor�a;

public class Categor�as {

	private HashSet<Categor�a> categor�as;

	public Categor�as() {
		categor�as = new HashSet<Categor�a>();
	}

	/****************************
	 * Ingresar una Categor�a *
	 ****************************/

	public void ingresar(Categor�a categor�a) throws java.lang.ArrayIndexOutOfBoundsException {

		categor�as.add(categor�a);
	}

	/****************************
	 * Eliminar una Categor�a
	 * 
	 * @throws NoExisteCategor�a *
	 ****************************/

	public void eliminar(int codCategor�a) throws NoExisteCategor�a {
		Categor�a categor�a;
		categor�a = buscar(codCategor�a);
		categor�as.remove(categor�a);
	}

	/****************************
	 * Buscar una Categor�a
	 * 
	 * @throws NoExisteCategor�a *
	 ****************************/

	public Categor�a buscar(int codCategor�a) throws NoExisteCategor�a {
		Categor�a categor�a;
		Categor�a resultado = null;
		for (Iterator<Categor�a> iterator = categor�as.iterator(); iterator.hasNext();) {
			categor�a = iterator.next();
			if (categor�a.getCodCategor�a().equals(codCategor�a)) {
				resultado = categor�a;
			}
		}
		if (resultado == null) {
			throw new NoExisteCategor�a();
		}
		return resultado;
	}


	/****************************
	 * Devuelve el vector de * Categor�as *
	 ****************************/

	public HashSet<Categor�a> getCategor�as() {
		return categor�as;
	}
	
	

}
