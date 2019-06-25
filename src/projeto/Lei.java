package projeto;

public abstract class Lei {
	
	protected String dni, ementa, interesses, url, codigo, situacaoAtual;
	protected int ano;
	
	
	public Lei(String dni, int ano ,String ementa, String interesses, String url, String codigo) {
		this.dni  = dni;
		this.ementa = ementa;
		this.interesses = interesses;
		this.url = url;
		this.ano = ano;
		this.codigo = codigo;
	}


	public String getInteresses() {
		return interesses;
	}


	public String getSituacaoAtual() {
		return situacaoAtual;
	}


	public void setSituacaoAtual(String situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

}
