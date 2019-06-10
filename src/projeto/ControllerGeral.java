package projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ControllerGeral {
	private Set<String> partidos;
	private HashMap<String, String> comissao;
	private Validacao validacao;

	public ControllerGeral() {
		this.partidos = new HashSet<String>();
		this.comissao = new HashMap<String, String>();
		this.validacao = new Validacao();
	}

	public void cadastrarPartido(String partido) {
		validacao.validaString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		partidos.add(partido);
	}

	public String exibirPartidos() {
		String saida = "";
		for (String p : partidos) {
			saida += p + ",";
		}
		if (!saida.equals("")) {
			return saida.substring(0, saida.length() - 1);
		}else {
			return "";
		}
		
	}

	public void cadastraComissao(String tema, String politicos) throws Exception {
		validacao.validaString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		validacao.validaString(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if (!comissao.containsKey(tema)) {
			comissao.put(tema, politicos);
		}else {
			throw new Exception("Erro ao cadastrar comissao: tema existente");
		}
	}
}