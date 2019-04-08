package control;


import model.Produtos;
import view.View;

public class Controller {
	
	public View v = new View();
	public Produtos p = new Produtos();
	
	public void menu_principal() throws Exception{
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
	
	public void read_files() throws Exception {
		p.lerArquivo();
		menu_principal();
	}
}