import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
//throws SQLException, IOException

public class MenuProduto {
	public static void main(String[] args)throws SQLException, IOException {
		
		Scanner entrada = new Scanner(System.in);
		Scanner entradaS = new Scanner(System.in);
		
		int selecaoMenu = 7;
		boolean lacoMenu = true;
		do {
			System.out.println("|===================================================|");
			System.out.println("|============= Cadastro de Produtos ================|");
			System.out.println("|===================================================|");
			System.out.println("|                                                   |");
			System.out.println("| 0 - Sair do Sistema                               |");
			System.out.println("| 1 - Cadastro de Produtos                          |");
			System.out.println("| 2 - Exibir Produtos                               |");
			System.out.println("| 3 - Excluir Produto                               |");
			System.out.println("|                                                   |");
			System.out.println("|===================================================|");
			
			selecaoMenu = entrada.nextInt();
			
			switch (selecaoMenu) {
			case 0: {
				lacoMenu = false;
				break;
			}
			case 1: {
				System.out.println("Nome do produto: ");
				String nome = entradaS.nextLine();
				
				System.out.println("Quantidade: ");
				int quantidade = entrada.nextInt();
				
				System.out.println("Valor: " );
				double valor = entrada.nextDouble();
				

				//ProdutoBanco.conexao();
				ProdutoBanco.inserir(nome, quantidade, valor, ProdutoBanco.conexao());
				
				break;
			}
			
			case 2:{
				System.out.println("|===================================================|");
				System.out.println("|============= Lista de Produtos ===================|");
				System.out.println("|===================================================|");
				System.out.println("|Cód ,	Nome ,	Qtd ,	Valor ");
				ProdutoBanco.listarProduto(ProdutoBanco.conexao());
				break;
			}
			
			case 3:{
				System.out.println("|===================================================|");
				System.out.println("|============= Exclusão de Linha ===================|");
				System.out.println("|===================================================|");
				System.out.println("|Digite o código do item para exclusão: ");
				int cod = entrada.nextInt();
				ProdutoBanco.excluirProduto(cod, ProdutoBanco.conexao());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selecaoMenu);
			}
		} while (lacoMenu == true);
	
	
		entrada.close();
		entradaS.close();
	
	}
}
