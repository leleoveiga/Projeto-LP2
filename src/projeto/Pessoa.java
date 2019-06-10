package projeto;

public class Pessoa {

	private String nome, dni, estado, interesses, partido;
	private Deputado deputacao;
	
	
	
	
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = null;
		this.deputacao = null;
		
	}

	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);
		this.partido = partido;
	}

	public void viraDeputado(String dataInicio) throws Exception {
		if (partido == null || partido.equals("")) {
			throw new Exception("Erro ao cadastrar deputado: pessoa sem partido");
		}
		this.deputacao = new Deputado(dataInicio);
	}
	public String getDni() {
		return dni;
	}

	

	public boolean verificaDeputado() {
		if (deputacao == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		if (!verificaDeputado()) {
			if ((partido == null || partido.trim().isEmpty()) && !interesses.trim().isEmpty()) {
				return nome + " - " + dni + " (" + estado + ") - " + "Interesses: " + interesses;
			} else if (!interesses.trim().isEmpty()) {
				return nome + " - " + dni + " (" + estado + ") - " + partido + " - Interesses: " + interesses;
			} else if (partido != null) {
				return nome + " - " + dni + " (" + estado + ") - " + partido;
			} else {
				return nome + " - " + dni + " (" + estado + ")";
			}
		} else {
			if(!interesses.trim().isEmpty()) {
			return "POL: " + nome + " - " + dni + " (" + estado + ") - " + partido + " - Interesses: " + interesses
					+ " - " + deputacao.getDataInicioComBarras() + " - " + deputacao.getLeis() + " Leis";
			}else {
				return "POL: " + nome + " - " + dni + " (" + estado + ") - " + partido 
						+ " - " + deputacao.getDataInicioComBarras() + " - " + deputacao.getLeis() + " Leis";
			}
		}
	}

}