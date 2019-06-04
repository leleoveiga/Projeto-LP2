package projeto;

public class Facade {
	private ControllerPessoa controllerPessoa;
	
	@SuppressWarnings("unused")
	private ControllerDeputado controllerDeputado;
	Facade(){
		this.controllerPessoa = new ControllerPessoa();
		this.controllerDeputado = new ControllerDeputado();
	}
	void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses);
	}
	void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.controllerPessoa.cadastraPessoa(nome, dni, estado, interesses, partido);
	}
}
