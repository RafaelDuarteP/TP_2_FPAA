package caminhoes;

import java.util.List;

public class ProgramacaoDinamica {

	public static List<Caminhao> distribuirRotas(RotaUtils utils) {
		List<Caminhao> caminhoes = utils.getCaminhoes();
		List<Rota> rotas = utils.getRotas();

		// pega o total de km das rotas e divide pela quantidade de caminhoes e adiciona
		// margem de 1%
		int mediaKm = (int) rotas.stream().mapToInt(Rota::getComprimento).sum() / caminhoes.size();
		mediaKm += mediaKm * 0.01;

		int indexCaminhao = 0;

		while (!rotas.isEmpty()) {

			int numLinhas = rotas.size() + 2;
			int numColunas = mediaKm + 2;

			int[][] matriz = new int[numLinhas][numColunas];
			for (int i = numColunas - 1, valor = mediaKm; i > 0; i--, valor -= 1) {
				matriz[0][i] = valor;
			}
			for (int i = 0; i < numLinhas - 2; i++) {
				matriz[i + 2][0] = rotas.get(i).getComprimento();
			}

			for (int i = 2; i < numLinhas; i++) {
				for (int j = 2; j < numColunas; j++) {
					int valor = matriz[i][0], max = matriz[0][j];
					if (valor < max) {
						int atual = matriz[i - 1][j];

						int indexPraVoltar = valor;

						int novo = valor + matriz[i - 1][j - indexPraVoltar];

						matriz[i][j] = novo > atual ? novo : atual;
					}
				}
			}

			int i = numLinhas - 1, j = numColunas - 1;
			while (i > 1 && j > 1) {
				if (matriz[i][j] > matriz[i - 1][j]) {
					Rota r = rotas.get(i - 2);
					caminhoes.get(indexCaminhao).addRota(r);
					j -= r.getComprimento();
				}
				i--;

			}

			rotas.removeAll(caminhoes.get(indexCaminhao).getRotas());
			indexCaminhao++;
		}

		return caminhoes;

	}

}
