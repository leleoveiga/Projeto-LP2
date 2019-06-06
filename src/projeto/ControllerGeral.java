package projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ControllerGeral {
    private Set<String> partidos;
    private HashMap<String, String> comissao;
    public ControllerGeral() {
        this.partidos = new HashSet<String>();
        this.comissao = new HashMap<String, String>();
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
    public void cadastraComissao(String tema, String politicos) {
    	if(!comissao.containsKey(tema)) {
    		comissao.put(tema, politicos);
    	}
    }
}