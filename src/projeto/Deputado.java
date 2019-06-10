package projeto;



public class Deputado {

	private String dataInicio;
	private int leis;

	public Deputado(String dataInicio) {
		this.dataInicio = dataInicio;
		this.leis = 0;
	}

	public String getDataInicio() {
		return dataInicio;
	}
	public String getDataInicioComBarras() {
		String string = getDataInicio();
		String ano = string.substring(4, 8);
		String mes = string.substring(2, 4);
		String dia = string.substring(0, 2);
		
		return dia + "/" + mes + "/" + ano;
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