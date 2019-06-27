package projeto;

public class PLP extends Lei {
	private String artigos;

	public PLP(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.artigos = artigos;
	}

	@Override
	public String toString() {
		
		if (turno == 0) {
			if (proximoLocal.equals("plenario")) {
				situacaoAtual = "EM VOTACAO (Plenario - 1o turno)";
			}
		}
		if (turno == 1) {
			if (proximoLocal.equals("plenario")) {
				situacaoAtual = "EM VOTACAO (Plenario - 2o turno)";
			}
		}
		return "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - "
				+ situacaoAtual;
	}

}
