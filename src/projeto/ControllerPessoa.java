package projeto;

import java.util.HashMap;

public class ControllerPessoa {
	private Validacao validacao;
	private HashMap<String, Pessoa> pessoas;

	public ControllerPessoa() {
		this.pessoas = new HashMap<String, Pessoa>();
		this.validacao = new Validacao();
	}

	public void cadastraPessoa(String nome, String dni, String estado, String interesses) throws Exception {
		validacao.validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validacao.validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validacao.validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");

		if (dni.contains("^[a-Z]") || dni.length() > 11 || dni.contains(".") || dni.contains(" ")) {
			throw new Exception("Erro ao cadastrar pessoa: dni invalido");
		}

		if (!pessoas.containsKey(dni)) {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoas.put(dni, pessoa);
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}

//	public void verificaDataValida(String dataInicio) throws Exception {
//		int ano = Integer.parseInt(dataInicio.substring(4, 7));
//		int mes = Integer.parseInt(dataInicio.substring(2, 3));
//		int dia = Integer.parseInt(dataInicio.substring(0, 1));
//		if (mes == 02) {
//			if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
//				if (dia >= 29) {
//					throw new Exception("Erro ao cadastrar deputado: data invalida");
//				}
//			}
//		}
//	}

	public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido)
			throws Exception {
		validacao.validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validacao.validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validacao.validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");

		if (dni.contains("^[a-Z]") || dni.length() != 11 || dni.contains(".") || dni.contains(" ")) {
			throw new Exception("Erro ao cadastrar pessoa: dni invalido");
		}

		if (!pessoas.containsKey(dni)) {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
			pessoas.put(dni, pessoa);
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}

	public void cadastraDeputado(String dni, String dataInicio) throws Exception {
		validacao.validaString(dataInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		if (dataInicio.contains("^[a-Z]") || dataInicio.length() != 8 || dataInicio.contains(".")
				|| dataInicio.contains(" ")) {
			throw new Exception("Erro ao cadastrar deputado: data invalida");
		}
//		verificaDataValida(dataInicio);
		if (pessoas.containsKey(dni)) {
			pessoas.get(dni).viraDeputado(dataInicio);
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		}
	}

	public String exibirPessoa(String dni) {
		if (pessoas.containsKey(dni)) {
			return pessoas.get(dni).toString();
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		}

	}
}
