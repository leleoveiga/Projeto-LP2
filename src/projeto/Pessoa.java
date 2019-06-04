package projeto;

public class Pessoa {
	
	private String nome, dni, estado, interesses;
	private Deputado partido;
	public Pessoa(String nome, String dni, String estado, String interesses){
		this.nome = nome;
		this.dni =dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = null;
	}
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);
		this.partido = new Deputado(partido);
		
	}
	public String getDni() {
		return dni;
	}

	public String toString() {
		return nome + " - " + dni +" (" + estado + ") - " + "Interesses:"  + interesses ;
	}
	
}
