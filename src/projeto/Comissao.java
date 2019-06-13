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
		if (dnis.length() > 11) {
			String[] arrayDni = dnis.split(",");
			//System.out.println(toStringSplit(arrayDni));
			//validacao.verificaDniExistente(arrayDni, pessoas);
			for (String dni: arrayDni) {
				deputados.add(dni);
			}
		} else {
			validacao.verificaDniExistente(dnis, pessoas);
			deputados.add(dnis);
		}

	}
	
	private String toStringSplit(String[] array) {
		String saida = "";
		for(String string: array) {
			saida += string + "//\n";
		}
		return saida + "\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
