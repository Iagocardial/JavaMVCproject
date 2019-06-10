package view;

import model.Login;

import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {
	//JFrame janela = new JFrame("Gerenciador");
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//janela.setSize(400, 400);
		//janela.setVisible(true);
		
		public int menu() {
			Scanner leitor = new Scanner(System.in);
			int opcao;
	        System.out.println("\n\n########## Sistema de Gerenciamento de Estoque #########");
	        System.out.println("\n                  ===============================");
	        System.out.println("                  |     1 - Cadastrar Produto    |");
	        System.out.println("                  |     2 - Editar Produto       |");
	        System.out.println("                  |     3 - Remover Produto      |");
	        System.out.println("                  |     4 - Listar Produtos      |");
	        System.out.println("                  |     5 - Emitir Relatório     |");
	        System.out.println("                  |     6 - Cadastrar Usuário    |");
	        System.out.println("                  |     0 - Sair                 |");
	        System.out.println("                  ================================\n");
	        System.out.println("\n\t\tInforme a opção desejada:    ");
	        opcao = leitor.nextInt();
	        System.out.print("\n");
	        return opcao;
	 }
		
		public String cadastro_nome() {
			String nome;
			Scanner leitor = new Scanner(System.in);
			System.out.println("\nNome do produto: ");
			nome = leitor.next();
			return nome;
		}
		
		public int cadastro_quant() {
			int quant;
			Scanner leitor = new Scanner(System.in);
			System.out.println("\nQuantidade: ");
			quant = leitor.nextInt();
			return quant;
		}
		
		public String remove_prod() {
			Scanner leitor = new Scanner(System.in);
			String rem;
			System.out.println("\nInforme o produto que deseja remover: ");
			rem = leitor.nextLine();
			return rem;
		}
		
		public void info_removido() {
			System.out.println("\nProduto removido!\n");
		}
		
		public String busca_edicao() {
			String rem;
			Scanner leitor = new Scanner(System.in);
			System.out.println("\nInforme o produto que deseja editar: ");
			rem = leitor.nextLine();
			return rem;
		}
		
		public void info_encontrado() {
			System.out.println("\nProduto encontrado!\n");
		}
		
		public void info_nencontrado() {
			System.out.println("Produto nao encontrado!");	
		}
		
		public void info_invalido() {
			System.out.println("Opção Inválida!");
			}
		
		public String edita_nome() {
			String nome;
			Scanner leitor = new Scanner(System.in);
			System.out.println("\nNovo nome: ");
			nome=leitor.nextLine();
			return nome;
		}
		
		public int edita_quant() {
			int quant;
			Scanner leitor = new Scanner(System.in);
			System.out.println("\nNova quantidade: ");
			quant=leitor.nextInt();
			return quant;
		}
		
		
		public String insere_usuario() {
			String usuario = JOptionPane.showInputDialog("Usuário: ");
			return usuario;
		}
		
		public String insere_senha() {
			String senha = JOptionPane.showInputDialog("Senha: ");
			return senha;
		}
		
		
}
