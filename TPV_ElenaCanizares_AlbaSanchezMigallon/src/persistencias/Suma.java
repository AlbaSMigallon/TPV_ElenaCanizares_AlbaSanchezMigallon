package persistencias;

import java.util.HashMap;

public class Suma {

	public static HashMap<String, Integer> sumarCantidades(HashMap<String, Integer> cantidadesMap) {
		// CREAMOS HASHMAP PARA EL RESULTADO
		HashMap<String, Integer> resultado = new HashMap<>();

		// ENTRAMOS
		for (HashMap.Entry<String, Integer> entrada : cantidadesMap.entrySet()) {
			// OBTENEMOS LA CLAVE Y EL VALOR
			String clave = entrada.getKey();
			int valor = entrada.getValue();

			// COMPROBAR SI TENEMOS CLAVE ANTES
			if (resultado.containsKey(clave)) {
				// OBTENEMOS VALOR DE LA CLAVE
				int valorExistente = resultado.get(clave);

				// CALCULAMOS LA SUMA Y ACTUALIZAMOS EL HASHMAP
				int suma = valorExistente + valor;
				resultado.put(clave, suma);
			} else {
				// SI NO, PONEMOS EL VALOR ORIGINAL
				resultado.put(clave, valor);
			}
		}

		// DEVOVEMOS EL HASHMAP DESPUES DE SUMAR
		return resultado;
	}

}
