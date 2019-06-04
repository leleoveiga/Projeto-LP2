package projeto;

import java.util.HashSet;
import java.util.Set;

public class ControllerGeral {
    private Set<String> partidos;
    public ControllerGeral() {
        this.partidos = new HashSet<String>();
    }
    public void cadastrarPartido(String partido) {
        partidos.add(partido);
    }
    public String exibirPartidos() {
        String saida= "";
        for(String p : partidos) {
            saida+= p + ",";
        }
        return saida.substring(0, saida.length()-1);
    }
}