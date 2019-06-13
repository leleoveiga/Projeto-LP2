package projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControllerGeral {
	private Set<String> partidos;
	private Map<String, Comissao> comissoes;
	private Validacao validacao;
	private HashMap<String, Pessoa> pessoas;

	public ControllerGeral(HashMap<String, Pessoa> pessoas) {
		this.partidos = new HashSet<String>();
		this.comissoes = new HashMap<String, Comissao>();
		this.validacao = new Validacao();
		this.pessoas = pessoas;
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
		} else {
			return "";
		}

	}

	public void cadastraComissao(String tema, String politicos) throws Exception {
		validacao.validaString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		validacao.validaString(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if (!comissoes.containsKey(tema)) {
			Comissao comissao = new Comissao(tema);
			comissao.adicionaDeputados(politicos, pessoas);
			comissoes.put(tema, comissao);
		} else {
			throw new Exception("Erro ao cadastrar comissao: tema existente");
		}
	}
}