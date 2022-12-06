package temperatura;

import java.util.List;

public class DivisaoEConquista {
    static int  diasAno = 365;
    static int  indexPrimario = 0;

    public static void main(String[] args) {

        calculaClima("src/temperatura/entradas/temperaturas.txt");
        calculaClima("src/temperatura/entradas/temperaturasExtremo.txt");
    }

    static void calculaClima(String nomeArquivo) {
        TemperaturasUtils utils = new TemperaturasUtils(nomeArquivo);

        List<Periodo> periodos = utils.getPeriodos();

        for (Periodo periodo : periodos) {
            System.out.println(climaDivisaoEConquista(periodo.getTemperaturas(),indexPrimario, diasAno-1).toString(periodo.getTemperaturas()));
        }
        
    }

    static RespostaClima climaDivisaoEConquista(int[] temperaturas,int indexIni, int indexFinal) {
        if (indexIni == indexFinal) {
            return new RespostaClima(indexIni,indexFinal,temperaturas[indexIni]);
        }
        else{
            int indexMeio = (indexIni +indexFinal)/2;
            RespostaClima esquerda = climaDivisaoEConquista(temperaturas, indexIni, indexMeio);
            RespostaClima direita = climaDivisaoEConquista(temperaturas, indexMeio +1, indexFinal);
            RespostaClima meio = calculaMeio(temperaturas,indexIni,indexMeio,indexFinal);
            if(esquerda.getSomaTotal()>= direita.getSomaTotal() && esquerda.getSomaTotal() >= meio.getSomaTotal()){
                return esquerda;
            }
            else if(direita.getSomaTotal()>= esquerda.getSomaTotal() && direita.getSomaTotal() >= meio.getSomaTotal()){
                return direita;
            }
            else {
                return meio;
            }

        }

    }

    private static RespostaClima calculaMeio(int[] temperaturas,int indiceIni,int indiceMeio,int indiceFinal){
       Integer somaEsquerda = Integer.MIN_VALUE;    
       int somaAux = 0;
       int maximoEsquerda = 0;
       for(int i = indiceMeio; i >= indiceIni; i--){
        somaAux += temperaturas[i];
        if(somaAux > somaEsquerda){
            somaEsquerda = somaAux;
            maximoEsquerda = i;
        }
       }
       Integer somaDireita = Integer.MIN_VALUE;
       somaAux = 0;
       int maximoDireita = 0;
       for(int j = indiceMeio + 1; j <= indiceFinal;j++){
        somaAux += temperaturas[j];
        if(somaAux > somaDireita){
            somaDireita = somaAux;
            maximoDireita = j;
        }

       }
       return new RespostaClima(maximoEsquerda, maximoDireita, somaEsquerda+somaDireita);
    }
}
