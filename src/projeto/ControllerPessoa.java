package projeto;

import java.util.HashMap;

public class ControllerPessoa {
	private HashMap<String,Pessoa> pessoas;
	public ControllerPessoa(){
		this.pessoas = new HashMap<String,Pessoa>();
	}
	public void cadastraPessoa(String nome, String dni, String estado, String interesses) {
		if(!pessoas.containsKey(dni)) {		
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoas.put(dni, pessoa);
		}else {
			throw new IllegalArgumentException("pessoa ja existe.");
		}
	}
	public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if(!pessoas.containsKey(dni)) {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
			pessoas.put(dni, pessoa);
		}else {
			throw new IllegalArgumentException("pessoa ja existe.");
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
