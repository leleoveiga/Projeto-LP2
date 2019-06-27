package projeto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Validacao {
	SimpleDateFormat formato;

	@SuppressWarnings("unused")
	public void validaString(String string, String msg) {
		if (string.trim().isEmpty())
			throw new IllegalArgumentException(msg);
		if (string == null)
			throw new NullPointerException(msg);

	}

	public void validaDni(String string, String msg) {
		if (!Character.isDigit(string.charAt(10)) || string.length() != 11 || string.contains(".")
				|| string.contains(" ")) {
			throw new IllegalArgumentException(msg);
		}

		for (int i = 0; i < string.length() - 2; i++) {
			if (!Character.isDigit(string.charAt(i))) {
				throw new IllegalArgumentException(msg);
			}
		}
	}
//	public boolean validaDni(String dni) {
//		if (!Character.isDigit(dni.charAt(10)) || dni.length() != 11 || dni.contains(".") || dni.contains(" ")) 
//			return false;
//		 else {
//			for (int i = 0; i < dni.length() - 2; i++) {
//				if (!Character.isDigit(dni.charAt(i)))
//					return false;
//			}
//		}
//		return true;
//	}

//	public void verificaDniExistente(String[] dnis, HashMap pessoas) throws Exception {
//		for (String dni : dnis) {
//			if (validaDni(dni) == false)
//				throw new Exception("Erro ao cadastrar comissao: dni invalido");
//			else if (!pessoas.containsKey(dnis))
//				throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
//		}
//	}
//
//	public void verificaDniExistente(String dni, HashMap pessoas) throws Exception {
//		if (validaDni(dni) == false)
//			throw new Exception("Erro ao cadastrar comissao: dni invalido");
//		else if (!pessoas.containsKey(dni))
//			throw new Exception("Erro ao cadastrar comissao: pessoa inexistente");
//	}

	public boolean isDateValid(String strDate) {
		String dateFormat = "ddMMuuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date;
			date = LocalDate.parse(strDate, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public boolean dataFutura(String data) throws Exception {
		Date data_atual = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");

		String data_atualFormatado = formatador.format(data_atual);

		int ano = Integer.parseInt(data.substring(4, 8));
		int mes = Integer.parseInt(data.substring(2, 4));
		int dia = Integer.parseInt(data.substring(0, 2));

		int ano_atual = Integer.parseInt(data_atualFormatado.substring(4, 8));
		int mes_atual = Integer.parseInt(data_atualFormatado.substring(2, 4));
		int dia_atual = Integer.parseInt(data_atualFormatado.substring(0, 2));

		if ((ano < ano_atual) || (ano == ano_atual && mes < mes_atual)
				|| (ano == ano_atual && mes == mes_atual && dia <= dia_atual)) {
			return true;
		} else {
			return false;
		}
	}

	public void validaAno(int ano) throws Exception {
		Calendar calendario = Calendar.getInstance();
		if (calendario.get(Calendar.YEAR) < ano) {
			throw new Exception("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		if (ano < 1988) {
			throw new Exception("Erro ao cadastrar projeto: ano anterior a 1988");
		}
	}

}