package projeto;

import easyaccept.EasyAccept;

public class ECO {
	private ControllerPessoa controllerPessoa;
	
	ECO(){
		this.controllerPessoa = new ControllerPessoa();
	}
	public static void main(String[] args) {
		args = new String[] { "projeto.ECO", "testes/use_case_1.txt" , "testes/use_case_2.txt",  "testes/use_case_3.txt", "testes/use_case_4.txt" };
		EasyAccept.main(args);
	}
	void cadastrarPessoa(String nome, String dni, String estado, String interesses) throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses);
	}
	void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) throws Exception {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses, partido);
	}
	String exibirPessoa(String DNI) {
		return this.controllerPessoa.exibirPessoa(DNI);
	}
	
}
