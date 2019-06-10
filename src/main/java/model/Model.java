package model;

import view.View;
import model.Login;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import com.db4o.ObjectSet;

public class Model {

	ObjectContainer produtos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/produtos.db4o");
	ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");

	// private List<Item> produtos = new ArrayList<>();

	View v1 = new View();

	public void adicionarProduto(String cadastro_nome, int cadastro_quant) {

		produtos.store(new Item(cadastro_nome, cadastro_quant));
		produtos.commit();
	}

	public void removerProduto(String rem) {
		Item p = new Item();
		p.setNome(rem);

		ObjectSet result = produtos.queryByExample(new Item());
		Item busca[] = new Item[result.size()];

		for (int i = 0; i < result.size(); i++) {
			busca[i] = (Item) result.next();
			if (p.getNome().toLowerCase().equals(busca[i].getNome().toLowerCase())) {
				produtos.delete(busca[i]);
				produtos.commit();
				System.out.println("Item removido!");
			}
		}
	}

	public void editarProduto(String ed) {
		Item p = new Item();
		p.setNome(ed);

		ObjectSet result = produtos.queryByExample(new Item());
		Item busca[] = new Item[result.size()];

		for (int i = 0; i < result.size(); i++) {
			busca[i] = (Item) result.next();
			if (p.getNome().toLowerCase().equals(busca[i].getNome().toLowerCase())) {
				busca[i].setNome(v1.edita_nome());
				busca[i].setQuantidade(v1.edita_quant());
				produtos.store(busca[i]);
				produtos.commit();
				System.out.println("Item editado!");
				break;
			}
		}
	}

	public void listarProdutos() {
		ObjectSet result = produtos.queryByExample(new Item());
		for (int i = 0; i < result.size(); i++) {
			System.out.println((Item) result.next());
		}
	}

	String caminho = "C:\\Users\\Tagep\\Desktop\\relatorio.txt";

	public void emitirRelatorio() throws Exception {
		File arquivo = new File(caminho);
		FileWriter escritor = new FileWriter(arquivo);
		BufferedWriter buffer = new BufferedWriter(escritor);
		ObjectSet result = produtos.queryByExample(new Item());
		int totalP = 0;
		for (int i = 0; i < result.size(); i++) {
			buffer.write(result.toString());
			buffer.newLine();
			buffer.newLine();
			totalP++;
		}
		buffer.write("Total de produtos cadastrados = " + totalP);
		buffer.close();
		System.out.println("\nRelatório emitido!\n");
	}

	public void cadastraUsuario() {
		String usuario = v1.insere_usuario();
		String senha = v1.insere_senha();
		usuarios.store(new Login(usuario, senha));
		usuarios.commit();

	}

	public boolean verificaLogin() {

		ObjectSet result = usuarios.queryByExample(new Login());
		Login busca[] = new Login[result.size()];

		String user = v1.insere_usuario();
		String password = v1.insere_senha();

		boolean a = false;
		
		for (int i = 0; i < result.size(); i++) {
			busca[i] = (Login) result.next();
			if (user.toLowerCase().equals(busca[i].getUsuario().toLowerCase())
					&& password.toLowerCase().equals(busca[i].getSenha().toLowerCase())) {
				System.out.println("Login realizado com sucesso!");
				a = true;
				break;
			}
		}
		if (a == false) {
			System.out.println("Falha no Login!");
		}

		return a;
	}
	
	
	
}
