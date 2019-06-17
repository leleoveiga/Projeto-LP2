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
	private HashMap<String, Lei> leis;
	private HashMap<Integer, Integer> contadorPL;
	private HashMap<Integer, Integer> contadorPLP;
	private HashMap<Integer, Integer> contadorPEC;

	public ControllerGeral(HashMap<String, Pessoa> pessoas) {
		this.partidos = new HashSet<String>();
		this.comissoes = new HashMap<String, Comissao>();
		this.validacao = new Validacao();
		this.pessoas = pessoas;
		this.leis = new HashMap<>();
		this.contadorPL = new HashMap<>();
		this.contadorPLP = new HashMap<>();
		this.contadorPEC = new HashMap<>();
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

	public void cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!contadorPL.containsKey(ano)) {
			contadorPL.put(ano, 0);
		}
		contadorPL.put(ano, contadorPL.get(ano)+1);
		String codigo = contadorPL.get(ano).toString();
		PL leiPL = new PL(codigo, dni, ano, ementa, interesses, url, conclusivo);
		leis.put(codigo, leiPL);
		
	}

	public void cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!contadorPLP.containsKey(ano)) {
			contadorPLP.put(ano, 0);
		}
		contadorPL.put(ano, contadorPL.get(ano)+1);
		String codigo = contadorPLP.get(ano).toString();
		PLP leiPLP = new PLP(codigo, dni, ano, ementa, interesses, url, artigos);
		leis.put(codigo, leiPLP);
	
	}

	public void cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!contadorPEC.containsKey(ano)) {
			contadorPEC.put(ano, 0);
		}
		contadorPEC.put(ano, contadorPEC.get(ano)+1);
		String codigo = contadorPEC.get(ano).toString();
		PEC leiPEC = new PEC(codigo, dni, ano, ementa, interesses, url, artigos);
		leis.put(codigo, leiPEC);
	
		
	}
	
	
}