package caminhoes;

import java.util.ArrayList;
import java.util.List;

public class Caminhao {

	private List<Rota> rotas;

	public Caminhao() {
		this.rotas = new ArrayList<>();
	}

	public void addRota(Rota rota) {
		rotas.add(rota);
	}

	public List<Rota> getRotas() {
		return this.rotas;
	}

	public int getTotalKm() {
		return rotas.stream().mapToInt(Rota::getComprimento).sum();
	}

	public int copareTo(Caminhao outro) {
		if (this.getTotalKm() < outro.getTotalKm()) {
			return -1;
		} else if (this.getTotalKm() > outro.getTotalKm()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Caminhao [total KM: ");
		builder.append(this.getTotalKm());
		builder.append(", rotas: ");
		builder.append(this.rotas);
		builder.append("]");
		return builder.toString();
	}

}
