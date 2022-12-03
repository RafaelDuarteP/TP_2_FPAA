package caminhoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RotaUtils {

	private List<Rota> rotas;
	private int numCaminhoes;

	public RotaUtils(String nomeArquivo) {
		this.rotas = new ArrayList<>();
		File file = new File(nomeArquivo);

		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
			String entrada = reader.readLine();
			this.numCaminhoes = Integer.parseInt(entrada);
			while (entrada != null) {
				entrada = reader.readLine();
				String[] partes = entrada.strip().split(";");
				Rota rota = new Rota(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
				rotas.add(rota);
			}

		} catch (IOException e) {
			System.err.println("Erro " + e.getMessage() + " no arquivo " + nomeArquivo);
		} catch (NumberFormatException e) {
			this.numCaminhoes = 0;
			this.rotas.clear();
		}

	}

	public List<Rota> getRotas() {
		return this.rotas;
	}

	public int getNumCaminhoes() {
		return this.numCaminhoes;
	}

}
