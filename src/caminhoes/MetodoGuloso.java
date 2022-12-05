package caminhoes;

import java.util.List;

public class MetodoGuloso {
	
	public static void main(String[] args) {
		distribuirRotas("src/caminhoes/entradas/caminhoes_compacto.txt").forEach(c -> System.out.println(c));
	}
	
	static List<Caminhao> distribuirRotas(String nomeArquivo) {
		RotaUtils utils = new RotaUtils(nomeArquivo);

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
