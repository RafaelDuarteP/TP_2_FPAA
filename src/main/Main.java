package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import caminhoes.Backtracking;
import caminhoes.Caminhao;
import caminhoes.MetodoGuloso;
import caminhoes.ProgramacaoDinamica;
import caminhoes.RotaUtils;
import temperatura.DivisaoEConquista;
import temperatura.TemperaturasUtils;

@SuppressWarnings("unused")
public class Main {

	private static final String PATH_CAMINHOES = "src/caminhoes/entradas/";
	private static final String PATH_TEMPERATURA = "src/temperatura/entradas/";

	private static final String[] ARQU_CAMINHOES = { "caminhoes_compacto.txt", "caminhoes_disperso.txt",
			"caminhoes_longo.txt" };
	private static final String[] ARQU_TEMPERATURA = { "temperaturas.txt", "temperaturasExtremo.txt" };

	private static BufferedWriter writer;
	private static final StringBuilder builder =new StringBuilder();

	public static void main(String[] args){

		caminhoes();
		temperaturas();
		loggar(builder.toString());
		System.out.println("fim");

	}


	private static void loggar(String string) {
		File arqFile = new File("resultados/readme.md");
		try {
			arqFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(arqFile));
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	private static void temperaturas() {

		long inicio = 0, fim = 0;
		builder.append("# Temperaturas\n");
		
		for (int i = 0; i < ARQU_TEMPERATURA.length; i++) {
			String arquivo = PATH_TEMPERATURA + ARQU_TEMPERATURA[i];
			TemperaturasUtils utils = new TemperaturasUtils(arquivo);
			inicio = System.currentTimeMillis();
			String resposta = DivisaoEConquista.calculaClima(utils);
			fim = System.currentTimeMillis();
			builder.append("### ").append(ARQU_TEMPERATURA[i]).append("\n\n").append("Tempo: ").append(fim - inicio).append("\n\n");
			builder.append(resposta);
			builder.append("\n\n");

		}
	}
	
	private static void caminhoes() {
		long inicio = 0, fim = 0;		
		builder.append("# Caminhoes\n");
		
		builder.append("## Metodo Dinamico :\n");
		for (int i = 0; i < ARQU_CAMINHOES.length; i++) {
			String arquivo = PATH_CAMINHOES + ARQU_CAMINHOES[i];
			RotaUtils utils = new RotaUtils(arquivo);
			inicio = System.currentTimeMillis();
			List<Caminhao> caminhaos = ProgramacaoDinamica.distribuirRotas(utils);
			fim = System.currentTimeMillis();
			builder.append("### ").append(ARQU_CAMINHOES[i]).append("\n\n").append("Tempo: ").append(fim - inicio).append("\n\n");
			caminhaos.forEach(c -> builder.append(c).append("\n\n"));
			builder.append("\n\n");

		}
		
		builder.append("## Metodo Guloso :\n");
		for (int i = 0; i < ARQU_CAMINHOES.length; i++) {
			String arquivo = PATH_CAMINHOES + ARQU_CAMINHOES[i];
			RotaUtils utils = new RotaUtils(arquivo);
			inicio = System.currentTimeMillis();
			List<Caminhao> caminhaos = MetodoGuloso.distribuirRotas(utils);
			fim = System.currentTimeMillis();
			builder.append("### ").append(ARQU_CAMINHOES[i]).append("\n\n").append("Tempo: ").append(fim - inicio).append("\n\n");
			caminhaos.forEach(c -> builder.append(c).append("\n\n"));
			builder.append("\n\n");

		}
		
//		builder.append("## Backtracking :\n");
//		for (int i = 0; i < ARQU_CAMINHOES.length; i++) {
//			String arquivo = PATH_CAMINHOES + ARQU_CAMINHOES[i];
//			RotaUtils utils = new RotaUtils(arquivo);
//			inicio = System.currentTimeMillis();
//			List<Caminhao> caminhaos = Backtracking.distribuirRotas(utils);
//			fim = System.currentTimeMillis();
//			builder.append("### ").append(ARQU_CAMINHOES[i]).append("\n\n").append("Tempo: ").append(fim - inicio).append("\n\n");
//			caminhaos.forEach(c -> builder.append(c).append("\n\n"));
//			builder.append("\n\n");
//
//		}
	}

}
