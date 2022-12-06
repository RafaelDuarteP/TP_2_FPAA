package caminhoes;

public class Rota implements Comparable<Rota> {

	private int id;
	private int comprimento;

	public Rota(int id, int comprimento) {
		this.id = id;
		this.comprimento = comprimento;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	@Override
	public int compareTo(Rota outra) {
		if (this.comprimento < outra.comprimento)
			return 1;
		if (this.comprimento > outra.comprimento)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "\tRota " + this.id + ", comprimento: " + this.comprimento;
	}

}
