package projeto;

public abstract class Lei {

	protected String dni, ementa, interesses, url, codigo, situacaoAtual;
	protected int ano;
	protected boolean fim;
	protected String proximoLocal;

	public Lei(String dni, int ano, String ementa, String interesses, String url, String codigo) {
		this.dni = dni;
		this.ementa = ementa;
		this.interesses = interesses;
		this.url = url;
		this.ano = ano;
		this.codigo = codigo;
		this.fim = false;
		this.proximoLocal = "CCJC";
	}

	public String getDni() {
		return dni;
	}

	public void setProximoLocal(String proximoLocal) {
		this.proximoLocal = proximoLocal;
	}

	public String getProximoLocal() {
		return proximoLocal;
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

	public boolean finalizou() {
		return fim;
	}

	public boolean fim() {
		fim = true;
		return fim;
	}

}
