package projeto;

public class Validacao {

	@SuppressWarnings("unused")
	public void validaString(String string, String msg) {
		if (string.trim().isEmpty())
			throw new IllegalArgumentException(msg);
		if (string == null) {
			throw new NullPointerException(msg);
		}
	}
}