package caminhoes;

import java.util.ArrayList;
import java.util.List;

public class Caminhao {

	private List<Rota> rotas;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Caminhao(int id) {
		this.rotas = new ArrayList<>();
		setId(id);
	}

	public void addRota(Rota rota) {
		rotas.add(rota);
	}

	public void removeRota(Rota rota) {
		rotas.remove(rota);
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
		builder.append("- Caminhao ").append(this.id).append(", total KM: ");
		builder.append(this.getTotalKm());
		builder.append("\n\t- rotas: ");
		builder.append(this.rotas);
		return builder.toString();
	}

}
