package caminhoes;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static List<Caminhao> melhorResultado = new ArrayList<>();

    public static List<Caminhao> distribuirRotas(RotaUtils utils) {

        List<Caminhao> caminhoes = utils.getCaminhoes();
        List<Rota> rotas = utils.getRotas();
        rotas.sort((o1, o2) -> o1.compareTo(o2));

        int mediaKm = (int) rotas.stream().mapToInt(Rota::getComprimento).sum() / caminhoes.size();
        mediaKm += mediaKm * 0.01;

        return backtracking(mediaKm, caminhoes, rotas);
    }

    public static List<Caminhao> backtracking(int mediaKM, List<Caminhao> caminhoes, List<Rota> rotas) {
        List<Caminhao> resposta = new ArrayList<Caminhao>();
        while (!rotas.isEmpty()) {
            Rota rotaToAdd = rotas.remove(0);
            for (Caminhao caminhao : caminhoes) {
                if (!((rotaToAdd.getComprimento() + caminhao.getTotalKm()) > mediaKM)) {

                    caminhao.addRota(rotaToAdd);
                    if (!(rotas.isEmpty() && calculaDiferença(caminhoes) == 0)) {
                        resposta = backtracking(mediaKM, caminhoes, rotas);
                        if (!(rotas.isEmpty() && calculaDiferença(caminhoes) == 0)) {
                            if (calculaDiferença(resposta) < calculaDiferença(melhorResultado)){
                                melhorResultado = resposta;
                                rotas.add(rotaToAdd);
                                caminhao.removeRota(rotaToAdd);
                            }
                        }else{
                           return caminhoes;
                        }
                    }
                    else{
                        return caminhoes;
                    } 
                }
            }

        }
        
        return caminhoes;
    }

    public static int calculaDiferença(List<Caminhao> caminhoes) {

        if (caminhoes.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return caminhoes.stream().mapToInt(Caminhao::getTotalKm).min().orElse(0)
                - caminhoes.stream().mapToInt(Caminhao::getTotalKm).max().orElse(0);
    }
}
