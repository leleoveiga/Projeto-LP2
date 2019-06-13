package projeto;

import java.util.HashMap;

public class Validacao {

	@SuppressWarnings("unused")
	public void validaString(String string, String msg) {
		if (string.trim().isEmpty())
			throw new IllegalArgumentException(msg);
		if (string == null) {
			throw new NullPointerException(msg);
		}
	}

	public boolean validaDni(String dni) {
		if (!Character.isDigit(dni.charAt(10)) || dni.length() != 11 || dni.contains(".") || dni.contains(" ")) {
			return false;
		} else {
			for (int i = 0; i < dni.length() - 2; i++) {
				if (!Character.isDigit(dni.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

	public void verificaDniExistente(String[] dnis, HashMap pessoas) throws Exception {
		for (String dni : dnis) {
			if (validaDni(dni) == false)
				throw new Exception("Erro ao cadastrar comissao: dni invalido");
			else if (!pessoas.containsKey(dnis))
				throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
		}
	}

	public void verificaDniExistente(String dni, HashMap pessoas) throws Exception {
		if (validaDni(dni) == false)
			throw new Exception("Erro ao cadastrar comissao: dni invalido");
		else if (!pessoas.containsKey(dni))
			throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
	}

}