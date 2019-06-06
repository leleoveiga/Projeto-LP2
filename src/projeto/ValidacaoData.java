package projeto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

public class ValidacaoData {
	public static boolean isDateValid(String strDate) {
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
		if (ano <= ano_atual) {
			if (mes <= mes_atual) {
				if (dia <= dia_atual) {
					return true;
				}
			}
		} else {
			return false;
		}
		throw new Exception();
	}
}
