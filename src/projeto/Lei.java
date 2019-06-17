package projeto;

public abstract class Lei {
	
	protected String dni, ementa, interesses, url, codigo;
	protected int ano;
	
	
	public Lei(String dni, int ano ,String ementa, String interesses, String url) {
		this.dni  = dni;
		this.ementa = ementa;
		this.interesses = interesses;
		this.url = url;
		this.ano = ano;
		
	}
	
	
	
	
}
