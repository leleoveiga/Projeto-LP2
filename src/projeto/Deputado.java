package projeto;

public class Deputado {

	private String partido, dataInicio ;
	private int leis;
	public Deputado(String partido, String dataInicio, int leis){	
		this.partido = partido;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
}
