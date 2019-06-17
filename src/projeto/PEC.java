package projeto;

public class PEC extends Lei{
	private String situacaoAtual;
	private String artigos;

	public PEC(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.artigos = artigos;
	}


	

}
