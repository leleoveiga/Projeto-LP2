package projeto;

import easyaccept.EasyAccept;

public class ECO {
	private ControllerPessoa controllerPessoa;

	public static void main(String[] args) {
		args = new String[]{"projeto.ECO", "Testes/use_case_1.txt", "Testes/use_case_2.txt"};
		EasyAccept.main(args);
	}
	public ECO(){
		this.controllerPessoa = new ControllerPessoa();
	}
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses);
	}
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses, partido);
	}
	public String exibirPessoa(String DNI) {
		return this.controllerPessoa.exibirPessoa(DNI);
	}
	public void cadastrarDeputado(String dni, String dataDeInicio) throws Exception {
		this.controllerPessoa.cadastraDeputado(dni, dataDeInicio);
	}
	
}
