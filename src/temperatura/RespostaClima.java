package temperatura;

import java.util.Arrays;

public class RespostaClima {
	private int somaTotal;
	private int indexDireita;
	private int indexEsquerda;

	public int getSomaTotal() {
		return somaTotal;
	}

	public void setSomaTotal(int somaTotal) {
		this.somaTotal = somaTotal;
	}

	public int getIndexEsquerda() {
		return indexEsquerda;
	}

	public void setIndexEsquerda(int indexEsquerda) {
		this.indexEsquerda = indexEsquerda;
	}

	public int getIndexDireita() {
		return indexDireita;
	}

	public void setIndexDireita(int indexDireita) {
		this.indexDireita = indexDireita;
	}

	public RespostaClima(int indexEsquerda, int indexDireita, int soma) {
		setIndexDireita(indexDireita);
		setIndexEsquerda(indexEsquerda);
		setSomaTotal(soma);
	}

	public String toString(int[] arr) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\t- Dia do ano inicial: " + (indexEsquerda + 1));
		builder.append("\n\t- Dia do ano final: " + (indexDireita + 1));
		builder.append("\n\t- Valor maior subsequência : " + somaTotal);
		builder.append("\n\t- Tamanho maior subsequência : " + ((indexDireita - indexEsquerda) + 1));
		builder.append("\n\t- ");
		builder.append(Arrays.toString(Arrays.copyOfRange(arr, indexEsquerda, indexDireita+1)));
		builder.append("\n\n");
		return builder.toString();
	}
}
