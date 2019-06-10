package control;

import model.Model;
import view.View;

public class Controller {
	public View v = new View();
	public Model p = new Model();
	
	public void menu_principal() throws Exception{
		while(p.verificaLogin() == false) {
			p.verificaLogin();
		}
		switch (v.menu()) {
		case 1:
			add_produtos();
			break;
		case 2:
			edit_produtos();
			break;
		case 3:
			remove_produtos();
			break;
		case 4:
			list_produtos();
			break;
		case 5:
			print_relatorios();
			break;
		case 6:
			print_relatorios();
			break;
		case 0:
			break;
		default:
			v.info_invalido();
			break;
       	}
	}

	

	public void add_produtos() throws Exception{
		p.adicionarProduto(v.cadastro_nome(), v.cadastro_quant());
		menu_principal();
	}
	
	public void remove_produtos() throws Exception {
		p.removerProduto(v.remove_prod());
		menu_principal();
	}
	
	public void edit_produtos() throws Exception {
		p.editarProduto(v.busca_edicao());
		menu_principal();
	}
	
	public void print_relatorios() throws Exception {
		p.emitirRelatorio();
		menu_principal();
	}
	
	public void list_produtos() throws Exception {
		p.listarProdutos();
		menu_principal();
	}
	
	public boolean chama_login() throws Exception {
		return p.verificaLogin();
	}
	
	public void cadastra_user() throws Exception {
		p.cadastraUsuario();
		menu_principal();
	}
	/*public void read_files() throws Exception {
		p.lerArquivo();
		menu_principal();
	}*/
	
}
