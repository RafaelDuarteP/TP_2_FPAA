package temperatura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemperaturasUtils {
	
	List<Periodo> periodos;

	public List<Periodo> getPeriodos() {
		return periodos;
	}
	public TemperaturasUtils(String nomeArquivo) {
		this.periodos = new ArrayList<>();
		File file = new File(nomeArquivo);

		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
			String entrada = reader.readLine();
			while (entrada != null) {
				Periodo periodo = new Periodo();
				String[] partes = entrada.strip().split(";");
				
				for (String string : partes) {
					int temp = Integer.parseInt(string);
					periodo.add(temp);
				}
				periodos.add(periodo);
				
				entrada = reader.readLine();
			}

		} catch (IOException e) {
			System.err.println("Erro " + e.getMessage() + " no arquivo " + nomeArquivo);
		} catch (NumberFormatException e) {
			this.periodos.clear();
		}
	}
	
	
}
