package projeto;

public class PLP extends Lei {
	private String situacaoAtual;
	private String artigos;
	
	public PLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.artigos = artigos;
		// TODO Auto-generated constructor stub
	}

	

}
