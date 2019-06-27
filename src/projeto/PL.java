package projeto;

public class PL extends Lei {

	private boolean conclusivo;
	private int vezesVotado;

	public PL(String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.conclusivo = conclusivo;
		this.vezesVotado = 0;
	}

	public int getVezesVotado() {
		return vezesVotado;
	}

	public void setVezesVotado() {
		this.vezesVotado++;
	}

	public String toString() {
		String conclusiva;
		if (conclusivo) {
			conclusiva = "Conclusiva - ";
		} else {
			conclusiva = "";
		}
		

		if (!fim) {
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
		}

		return "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + conclusiva + situacaoAtual;

	}

	public boolean getConclusivo() {
		return conclusivo;
	}
}
