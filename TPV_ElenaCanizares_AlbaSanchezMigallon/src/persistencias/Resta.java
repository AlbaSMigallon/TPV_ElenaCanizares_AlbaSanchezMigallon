package persistencias;

import java.util.HashMap;

public class Resta {

	public static HashMap<String, Integer> restarCantidades(HashMap<String, Integer> cantidadesMap) {
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

				// CALCULAMOS LA RESTA Y ACTUALIZAMOS EL HASHMAP
				int resta = valorExistente - valor;
				resultado.put(clave, resta);
			} else {
				// SI NO, PONEMOS EL VALOR ORIGINAL
				resultado.put(clave, valor);
			}
		}

		// DEVOVEMOS EL HASHMAP DESPUES DE RESTAR
		return resultado;
	}

}
