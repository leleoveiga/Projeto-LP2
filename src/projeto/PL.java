package projeto;

public class PL extends Lei{
	
	private boolean conclusivo;
	private String situacaoAtual;
	
	public PL(String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.conclusivo = conclusivo;
	}
	
	public String toString() {
		String conclusiva;
		if (conclusivo) {
			conclusiva = "Conclusiva - ";
		} else {
			conclusiva = "";
		}
		return "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + conclusiva + situacaoAtual;
	}
}
