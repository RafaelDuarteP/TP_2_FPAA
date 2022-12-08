package temperatura;

import java.util.List;

public class DivisaoEConquista {
    static int  diasAno = 365;
    static int  indexPrimario = 0;

    public static String calculaClima(TemperaturasUtils utils) {
		StringBuilder builder = new StringBuilder();

		List<Periodo> periodos = utils.getPeriodos();

		int idPeriodo = 1;
		for (Periodo periodo : periodos) {
			builder.append("- Período: ").append(idPeriodo++);
			builder.append(climaDivisaoEConquista(periodo.getTemperaturas(), indexPrimario, diasAno - 1).toString(periodo.getTemperaturas()));
		}
		return builder.toString();
	}

    public static String calculaClimaAno(TemperaturasUtils utils) {
		StringBuilder builder = new StringBuilder();

		List<Periodo> periodos = utils.getPeriodos();
		int anos[] ;
        anos =concatenaArray(periodos);

			builder.append("- Anos: ");
			builder.append(climaDivisaoEConquista(anos, indexPrimario, (((periodos.size() * diasAno)-1))).toString(anos));
		return builder.toString();
	}

    public static RespostaClima climaDivisaoEConquista(int[] temperaturas,int indexIni, int indexFinal) {
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
    private static int[] concatenaArray(List<Periodo> periodos){
        
        int[] result = new int[periodos.size() * diasAno];
        int counter = 0;
        for (Periodo periodo : periodos) {
            System.arraycopy(periodo.getTemperaturas(), 0, result, diasAno * counter, diasAno);
            counter++;
        }
        return result;
    }
}
