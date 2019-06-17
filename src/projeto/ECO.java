package projeto;

import easyaccept.EasyAccept;

public class ECO {
	private ControllerPessoa controllerPessoa;
	private ControllerGeral controllerGeral;

	public static void main(String[] args) {
		args = new String[] { "projeto.ECO", "Testes/use_case_1.txt", "Testes/use_case_2.txt", "Testes/use_case_3.txt",
				"Testes/use_case_4.txt", "Testes/use_case_5.txt", "Testes/use_case_6.txt", "Testes/use_case_7.txt"  };
		EasyAccept.main(args);
	}

	public ECO() {
		this.controllerPessoa = new ControllerPessoa();
		this.controllerGeral = new ControllerGeral(controllerPessoa.getPessoas());
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses);
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido)
			throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses, partido);
	}

	public String exibirPessoa(String DNI) throws Exception {
		return this.controllerPessoa.exibirPessoa(DNI);
	}

	public void cadastrarDeputado(String dni, String dataDeInicio) throws Exception {
		this.controllerPessoa.cadastraDeputado(dni, dataDeInicio);
	}

	public void cadastrarPartido(String partido) {
		this.controllerGeral.cadastrarPartido(partido);
	}

	public String exibirBase() {
		return this.controllerGeral.exibirPartidos();
	}

	public void cadastrarComissao(String tema, String politico) throws Exception {
		controllerGeral.cadastraComissao(tema, politico);
	}
	
	public void cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) throws Exception {
		controllerGeral.cadastrarPL(dni,ano,ementa,interesses,url,conclusivo);
	}
	
	public void cadastrarPLP(String dni, int ano, String ementa, String interesses, String url,String artigos) throws Exception {
		controllerGeral.cadastrarPLP(dni,ano,ementa,interesses,url,artigos);
	}
	
	public void cadastrarPEC(String dni, int ano, String ementa, String interesses, String url,String artigos) throws Exception {
		controllerGeral.cadastrarPEC(dni,ano,ementa,interesses,url,artigos);
	}
	
	public String exibirProjeto(String codigo) {
		return controllerGeral.exibirProjeto(codigo);
	}
	
	
}