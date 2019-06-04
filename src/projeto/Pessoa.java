package projeto;

public class Pessoa {
	
	private String nome, dni, estado, interesses, partido;
	private Deputado deputacao;
	public Pessoa(String nome, String dni, String estado, String interesses){
		this.nome = nome;
		this.dni =dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = null;
		this.deputacao = null;
	}
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);
		this.partido = partido;	
	}
	public String getDni() {
		return dni;
	}
	public void viraDeputado(String dataInicio) {
		this.deputacao = new Deputado(dataInicio);
	}
	public boolean ehDeputado() {
		if(deputacao == null) {
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public String toString() {
		if(!ehDeputado()) {
			if(partido == null) {
				return nome + " - " + dni +" (" + estado + ") - " + "Interesses:"  + interesses ;
			}else {
				return nome + " - " + dni +" (" + estado + ") - " + partido + " - Interesses:"  + interesses ;
			}
		}else {
			 return "POL: " + nome + " - " + dni +" (" + estado + ") - " + partido + " - Interesses: "  + interesses + " - " + deputacao.getDataInicio() + " - " + deputacao.getLeis();
		}
	}
	
}
