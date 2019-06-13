package projeto;

public abstract class Lei {
	
	protected String dni, ementa, interesses, situacao, url, codigo;
	protected int ano;
	
	public Lei(String dni, String ementa, String interesses, String url, int ano) {
		this.dni  = dni;
		this.ementa = ementa;
		this.interesses = interesses;
		this.url = url;
		this.ano = ano;
	}
	
	
	
	
}
