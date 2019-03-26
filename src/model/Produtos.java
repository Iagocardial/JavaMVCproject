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

public class Produtos {
private List<Item> produtos = new ArrayList<>();

	Scanner leitor = new Scanner(System.in);
	String nome;
	int quant;

	public void adicionarProduto() {
		System.out.println("\nNome do produto: ");
		nome = leitor.next();
		System.out.println("\nQuantidade: ");
		quant = leitor.nextInt();
		produtos.add(new Item(nome, quant));
	}

	public void removerProduto() {
		System.out.println("\nInforme o produto que deseja remover: ");
		String rem = leitor.next();
		for (Iterator<Item> i = produtos.iterator(); i.hasNext();) {
			Item p = i.next();
		  if (p.getNome().equals(rem)) {
		    i.remove();
		    System.out.println("\nProduto removido!\n");
		  }
		}
	}

	public void editarProduto() {
		System.out.println("\nInforme o produto que deseja editar: ");
		String ed = leitor.next();
		for (Item p : produtos) {
			if (p.getNome().toLowerCase().compareTo(ed.toLowerCase()) == 0) {
				System.out.println("\nProduto encontrado!");
				System.out.println("\nNovo nome: ");
				p.setNome(leitor.next());
				System.out.println("\nNova quantidade: ");
				p.setQuantidade(leitor.nextInt());
			}else {
				System.out.println("Produto não encontrado!");
			}
		}
	}

	/*public void imprimirProdutos() {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}*/
	
	
//	String caminho = "C:\\Users\\mayra\\Desktop\\relatorio.txt";
	
	String caminho = "/home/iagocardial/Documentos/Fatec/4 Semestre/engenharia 3/relatorio.txt";
	
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
