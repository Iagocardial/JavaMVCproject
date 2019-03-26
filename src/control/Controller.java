package control;


import model.Produtos;

public class Controller {
	
	private Produtos p;
	
	public void add_produtos(){
		p.adicionarProduto();
	}
	
	public void remove_produtos() {
		p.removerProduto();
	}
	
	public void edit_produtos() {
		p.editarProduto();
	}
	
	public void print_relatorios() throws Exception {
		p.emitirRelatorio();
	}
	
	public void read_files() throws Exception {
		p.lerArquivo();
	}
}
