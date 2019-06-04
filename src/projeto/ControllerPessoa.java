package projeto;

import java.util.HashMap;

public class ControllerPessoa {
	private Validacao validacao;
	private HashMap<String,Pessoa> pessoas;
	public ControllerPessoa(){
		this.pessoas = new HashMap<String,Pessoa>();
		this.validacao = new Validacao();
	}
	public void cadastraPessoa(String nome, String dni, String estado, String interesses) throws Exception {
		validacao.validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validacao.validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validacao.validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
				
		if (dni.contains("^[a-Z]") || dni.length() > 11 || dni.contains(".") ) {
			throw new Exception("Erro ao cadastrar pessoa: dni invalido");
		}
		
		if(!pessoas.containsKey(dni)) {		
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoas.put(dni, pessoa);
		}else {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}
	public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) throws Exception {
		validacao.validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validacao.validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validacao.validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		
		if (dni.contains("^[a-Z]") || dni.length() > 11 || dni.contains(".") ) {
			throw new Exception("Erro ao cadastrar pessoa: dni invalido");
		}
		
		if(!pessoas.containsKey(dni)) {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
			pessoas.put(dni, pessoa);
		}else {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}
	public void cadastraDeputado(String dni, String dataInicio) {
		if(pessoas.containsKey(dni)) {
			pessoas.get(dni).viraDeputado(dataInicio);
		}else {
			throw new IllegalArgumentException("pessoa nao existe.");
		}
	}
	public String exibirPessoa(String dni) {
		if(pessoas.containsKey(dni)) {
			return pessoas.get(dni).toString();
		}else {
			throw new IllegalArgumentException("pessoa nao existe.");
		}
		
	}
}
