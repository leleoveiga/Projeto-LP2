package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comissao {
	private String nome;
	private List<String> deputados;
	private Validacao validacao;

	public Comissao(String nome) {
		this.deputados = new ArrayList<>();
		this.setNome(nome);
		this.validacao = new Validacao();
	}

	public void adicionaDeputados(String dnis, HashMap pessoas) throws Exception {
		if (dnis.length() != 11) {
			String[] arrayDni = dnis.split(",");
			for (String dni : arrayDni) {
				validacao.validaDni(dni, "Erro ao cadastrar comissao: dni invalido");
				if (pessoas.containsKey(arrayDni)) {
					validacao.validaDni(dni, "Erro ao cadastrar comissao: dni invalido");
					deputados.add(dni);
				}
			}

		} else if (!pessoas.containsKey(dnis)) {
			throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
