package projeto;

public class PEC extends Lei {
	private String artigos;

	public PEC(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url, codigo);
		this.situacaoAtual = "EM VOTACAO (CCJC)";
		this.artigos = artigos;
	}

	@Override
	public String toString() {
		String[] artigosSplit = artigos.split(",");
		String artigosFormatado = "";
		for (String i : artigosSplit) {
			artigosFormatado += i + ", ";
		}
		
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

		return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + " - " + ementa + " - "
				+ artigosFormatado.substring(0, artigosFormatado.length() - 2) + " - " + situacaoAtual;
	}

}
