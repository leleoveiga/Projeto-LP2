package projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo)
			throws Exception {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (pessoas.containsKey(dni)) {
			if (pessoas.get(dni).verificaDeputado()) {
				validacao.validaAno(ano);
				if (!contadorPL.containsKey(ano)) {
					contadorPL.put(ano, 0);
				}
				contadorPL.put(ano, contadorPL.get(ano) + 1);
				String codigo = "PL " + contadorPL.get(ano).toString() + "/" + ano;
				PL leiPL = new PL(codigo, dni, ano, ementa, interesses, url, conclusivo);
				leis.put(codigo, leiPL);
				return codigo;
			} else {
				throw new Exception("Erro ao cadastrar projeto: pessoa nao eh deputado");
			}

		} else {
			throw new Exception("Erro ao cadastrar projeto: pessoa inexistente");
		}

	}

	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos)
			throws Exception {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (pessoas.containsKey(dni)) {
			validacao.validaAno(ano);
			if (pessoas.get(dni).verificaDeputado()) {
				if (!contadorPLP.containsKey(ano)) {
					contadorPLP.put(ano, 0);
				}
				contadorPLP.put(ano, contadorPLP.get(ano) + 1);
				String codigo = "PLP " + contadorPLP.get(ano).toString() + "/" + ano;
				PLP leiPLP = new PLP(codigo, dni, ano, ementa, interesses, url, artigos);
				leis.put(codigo, leiPLP);
				return codigo;
			} else {
				throw new Exception("Erro ao cadastrar projeto: pessoa nao eh deputado");
			}

		} else {
			throw new Exception("Erro ao cadastrar projeto: pessoa inexistente");
		}
	}

	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos)
			throws Exception {
		validacao.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validacao.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validacao.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validacao.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validacao.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validacao.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (pessoas.containsKey(dni)) {
			if (pessoas.get(dni).verificaDeputado()) {
				validacao.validaAno(ano);
				if (!contadorPEC.containsKey(ano)) {
					contadorPEC.put(ano, 0);
				}
				contadorPEC.put(ano, contadorPEC.get(ano) + 1);
				String codigo = "PEC " + contadorPEC.get(ano).toString() + "/" + ano;
				PEC leiPEC = new PEC(codigo, dni, ano, ementa, interesses, url, artigos);
				leis.put(codigo, leiPEC);
				return codigo;
			} else {
				throw new Exception("Erro ao cadastrar projeto: pessoa nao eh deputado");
			}

		} else {
			throw new Exception("Erro ao cadastrar projeto: pessoa inexistente");
		}

	}

	public String exibirProjeto(String codigo) {
		return leis.get(codigo).toString();
	}

	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) throws Exception {
		int votos = 0;
		Lei lei = leis.get(codigo);
		validacao.validaString(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if (statusGovernista.equals("GOVERNISTA") || statusGovernista.equals("OPOSICAO")
				|| statusGovernista.equals("LIVRE")) {
			if (!leis.containsKey(codigo)) {
				throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
			}
		} else {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		}
		if (lei != null) {
			if (lei.getProximoLocal().equals("CCJC")) {
				if (!comissoes.containsKey("CCJC")) {
					throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
				}
			}
		} 
		
		if (leis.get(codigo).finalizou()) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}

		if (lei.getProximoLocal().equals("plenario")) {
			throw new Exception("Erro ao votar proposta: proposta encaminhada ao plenario");
		}

		for (int i = 0; i < comissoes.get(lei.getProximoLocal()).qntDeputados(); i++) {
			List<String> deputados = (List<String>) comissoes.get(lei.getProximoLocal()).getDeputados();
			if (statusGovernista.equals("GOVERNISTA")) {
				if (partidos.contains(pessoas.get(deputados.get(i)).getPartido())) {
					votos++;
				}
			}
			if (statusGovernista.equals("OPOSICAO")) {
				if (!partidos.contains(pessoas.get(deputados.get(i)).getPartido())) {
					votos++;
				}
			}
			if (statusGovernista.equals("LIVRE")) {
				String[] interessesDeputado = pessoas.get(deputados.get(i)).getInteresses().split(",");
				String[] interessesLei = leis.get(codigo).getInteresses().split(",");
				for (String interesseDeputado : interessesDeputado) {
					for (String interesseLei : interessesLei) {
						if (interesseDeputado.equals(interesseLei)) {
							votos++;
							break;
						}
						break;
					}
				}
			}
		}
		
		if (leis.get(codigo).getClass() == PL.class) {
			PL leiPL = (PL) leis.get(codigo);
		}

		int participantes = comissoes.get(lei.getProximoLocal()).qntDeputados();
		if (votos >= ((participantes / 2) + 1)) {

			if (leis.get(codigo).getClass() == PL.class) {
					if (!leis.get(codigo).getProximoLocal().equals("CCJC")) {
						leis.get(codigo).fim();

				}
			}

			leis.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
			leis.get(codigo).setProximoLocal(proximoLocal);
			if (proximoLocal.equals("-")) {
				pessoas.get(lei.getDni()).adicionaLei();
				leis.get(codigo).fim();
				leis.get(codigo).setSituacaoAtual("APROVADO");
			}
			return true;
		}

		if (proximoLocal.equals("-")) {
			leis.get(codigo).fim();
			leis.get(codigo).setSituacaoAtual("ARQUIVADO");
		}
//		if(lei.finalizou()) {
//			throw new Exception("Erro ao votar proposta: tramitacao encerrada");
//		}
		
		if (leis.get(codigo).getClass() == PL.class) {
			if (leis.get(codigo).getProximoLocal().equals("CCJC")) {
				leis.get(codigo).fim();

		}
	}
		return false;
	}

	public void votarPlenario(String codigo, String statusGovernista, String presentes) {
		if (leis.get(codigo).finalizou()) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		PL lei = (PL) leis.get(codigo);
		if (lei.getConclusivo()) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
		}
	}

}