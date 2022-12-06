package caminhoes;

import java.util.List;

public class MetodoGuloso {
	

	public static List<Caminhao> distribuirRotas(RotaUtils utils) {
		List<Caminhao> caminhoes = utils.getCaminhoes();
		List<Rota> rotas = utils.getRotas();
		rotas.sort((o1, o2) -> o1.compareTo(o2));

		while (!rotas.isEmpty()) {
			Rota rotaToAdd = rotas.remove(0);
			caminhoes.get(0).addRota(rotaToAdd);
			caminhoes.sort((o1, o2) -> o1.copareTo(o2));
		}
		
		return caminhoes;
	}
}
