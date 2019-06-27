package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comissao {
	private String nome;
	private List<String> deputados;
	private List<String> leisVotadas;
	private Validacao validacao;

	public Comissao(String nome) {
		this.deputados = new ArrayList<>();
		this.setNome(nome);
		this.validacao = new Validacao();
		this.leisVotadas = new ArrayList<>();
	}

	public void adicionaDeputados(String dnis, HashMap<String, Pessoa> pessoas) throws Exception {
		String[] arrayDni = dnis.split(",");
		for (String dni : arrayDni) {
			validacao.validaDni(dni, "Erro ao cadastrar comissao: dni invalido");
			if (pessoas.containsKey(dni)) {
				if (pessoas.get(dni).verificaDeputado()) {
					deputados.add(dni);
				} else {
					throw new Exception("Erro ao cadastrar comissao: pessoa nao eh deputado");
				}

			} else if (!pessoas.containsKey(dni)) {
				throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
			}
		}

	}

	public void vota(String codigo) {
		leisVotadas.add(codigo);
	}

	public boolean jaVotou(String codigo) {
		return leisVotadas.contains(codigo);
	}

	public int qntDeputados() {
		return deputados.size();
	}

	public List<String> getDeputados() {
		return deputados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
