package projeto;

public class Validacao {
    /**
     * Manda uma excecao se a string for vazia ou nula
     * @param string
     */
    @SuppressWarnings("unused")
    public void validaString(String string , String msg) {
        if(string.trim().isEmpty() )
            throw new IllegalArgumentException(msg);
        if(string == null) {
            throw new NullPointerException(msg);
        }
    }
}