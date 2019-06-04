package projeto;

public class Deputado {

	private String dataInicio ;
	private int leis;
	public Deputado(String dataInicio){	
		this.dataInicio = dataInicio;
		this.leis = 0;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public int getLeis() {
		return leis;
	}
	public void setLeis(int leis) {
		this.leis = leis;
	}

}
