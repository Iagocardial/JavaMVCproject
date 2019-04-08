package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import view.View;

public class Produtos {
	private List<Item> produtos = new ArrayList<>();
	
	View v1 = new View();
	
	public void adicionarProduto(String cadastro_nome, int cadastro_quant) {
		produtos.add(new Item(cadastro_nome, cadastro_quant));
	}

	public void removerProduto(String rem) {
		for (Iterator<Item> i = produtos.iterator(); i.hasNext();) {
			Item p = i.next();
		  if (p.getNome().equals(rem)) {
		    i.remove();
		  }
		}
	}

	public void editarProduto(String ed) {
		for (Item p : produtos) {
			if (p.getNome().toLowerCase().compareTo(ed.toLowerCase()) == 0) {
				v1.info_encontrado();
				p.setNome(v1.edita_nome());
				p.setQuantidade(v1.edita_quant());
			}else {
				v1.info_nencontrado();
			}
		}
	}

	/*public void imprimirProdutos() {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}*/
	
	
	String caminho = "C:\\Users\\Tagep\\Desktop\\relatorio.txt";
	
	//String caminho = "/home/iagocardial/Documentos/Fatec/4 Semestre/engenharia 3/relatorio.txt";
	
	public void emitirRelatorio() throws Exception {
		File arquivo = new File(caminho);
		FileWriter escritor = new FileWriter(arquivo);
		BufferedWriter buffer = new BufferedWriter(escritor);
		int totalP = 0;
		for (Item p : produtos) {
			buffer.write(p.getNome() + "    " +p.getQuantidade());
			buffer.newLine();
			buffer.newLine();
			totalP++;
		}
		buffer.write("Total de produtos cadastrados = " +totalP);
		buffer.close();
	}
	
	public void lerArquivo() throws Exception
	{
		String linha;
		ArrayList<String> produtos = new ArrayList<>();
		
		BufferedReader entrada = new BufferedReader(new FileReader(caminho));
		
		while((linha = entrada.readLine()) != null){
			produtos.add(linha);
		}
		entrada.close();
		System.out.println("Dados Lidos com Sucesso!");
}

	
	
	/*@Override
	public int compareTo(Produto arg0) {
		return 0;
	}*/

}