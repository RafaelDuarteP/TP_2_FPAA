package caminhoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RotaUtils {

	private List<Rota> rotas;
	private List<Caminhao> caminhoes;

	public RotaUtils(String nomeArquivo) {
		this.rotas = new ArrayList<>();
		this.caminhoes = new ArrayList<>();
		File file = new File(nomeArquivo);

		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
			String entrada = reader.readLine();
			int numCaminhoes = Integer.parseInt(entrada);
			
			for (int i = 1; i <= numCaminhoes; i++) {
				caminhoes.add(new Caminhao(i));
			}			
			
			entrada = reader.readLine();
			while (entrada != null) {
				String[] partes = entrada.strip().split(";");
				Rota rota = new Rota(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
				rotas.add(rota);
				entrada = reader.readLine();
			}

		} catch (IOException e) {
			System.err.println("Erro " + e.getMessage() + " no arquivo " + nomeArquivo);
		} catch (NumberFormatException e) {
			this.caminhoes.clear();
			this.rotas.clear();
		}

	}

	public List<Rota> getRotas() {
		return this.rotas;
	}

	public List<Caminhao> getCaminhoes() {
		return this.caminhoes;
	}

}
