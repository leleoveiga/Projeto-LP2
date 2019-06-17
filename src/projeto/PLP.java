package projeto;

public class PLP extends Lei {
	private String situacaoAtual;
	private String artigos;
	
	public PLP(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.artigos = artigos;
	}

	@Override
	public String toString() {
		return "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - " + situacaoAtual ;
	}
	
	

	

}
