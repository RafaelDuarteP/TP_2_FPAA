package temperatura;

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
    public RespostaClima(){
        setIndexDireita(0);
        setIndexEsquerda(0);
        setSomaTotal(0);
    }
    public String toString(int[] arr){
        StringBuilder builder = new StringBuilder();
        builder.append("\nDia do ano inicial: " + (indexEsquerda + 1));
        builder.append("\nDia do ano final: " + (indexDireita + 1));
        builder.append("\nValor maior subsequência : " + somaTotal);
        builder.append("\nTamanho maior subsequência : " + ((indexDireita - indexEsquerda)+1 ));
        for(int i = indexEsquerda; i<=indexDireita;i++){
            builder.append("\n" + arr[i]);
        }
        return builder.toString();
    }
}
