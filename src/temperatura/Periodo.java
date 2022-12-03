package temperatura;

public class Periodo {

	private int[] temperaturas;
	private int pos;

	public Periodo() {
		temperaturas = new int[365];
		pos = 0;
	}

	public void add(int temp) {
		temperaturas[pos++] = temp;
	}

	public int[] getTemperaturas() {
		return this.temperaturas;
	}

}
