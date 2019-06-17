package projeto;

public class PL extends Lei{
	
	private boolean conclusivo;
	private String situacaoAtual;
	
	public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		super(dni, ano, ementa, interesses, url);
		// TODO Auto-generated constructor stub
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.conclusivo = conclusivo;
	}
}
