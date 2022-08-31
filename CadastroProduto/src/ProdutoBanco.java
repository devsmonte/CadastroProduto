import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoBanco {


	
	public static Connection conexao() throws IOException, SQLException{
		String url = "jdbc:oracle:thin:@10.0.0.180:1521:xe";
		String usuario = "silvio";
		String senha = "123456";
		return DriverManager.getConnection(url, usuario, senha);
	
	}
	
	public static void inserir(String nome, int quantidade, double valor, Connection conn) throws SQLException{
		
		
		String sql = "INSERT INTO PRODUTO (nome, quantidade, valor) values (?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
			
		ps.setString(1, nome);
		ps.setInt(2, quantidade);
		ps.setDouble(3, valor);
			
		ps.execute();
		System.out.println("Executado com sucesso!");
		ps.close();
	}

	/*
	public void inserir (String nome, String email, int idade, double altura, Connection conn) throws SQLException {
		String sql = "INSERT INTO USUARIO2 (nome, email, idade, altura) values (?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
			
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.setInt(3, idade);
		ps.setDouble(4, altura);
	
		ps.execute();
		System.out.println("Executado com sucesso!");
		ps.close();
	}
	*/
	
	
public static void listarProduto(Connection conn) throws SQLException{
	String sql = "SELECT COD, NOME, QUANTIDADE, VALOR FROM PRODUTO";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ResultSet res = ps.executeQuery();
	   while(res.next()) {
		   int cod = res.getInt(1);
		   String nome = res.getString(2);
		   int quantidade = res.getInt(3);
		   double valor = res.getDouble(4);
		   System.out.println("|" + cod + " ," + nome + " ," + quantidade + " ,	" + valor);
		  // System.out.println("|" + cod + "     " + nome + "              " + quantidade + "    " + valor);
	   }
}

public static void excluirProduto(int cod, Connection conn) throws SQLException{
	String sql = "DELETE FROM PRODUTO WHERE COD = " + cod;
	PreparedStatement ps = conn.prepareStatement(sql);
	
	
	//ps.setInt(1, cod);
			
	ps.execute();
	System.out.println("Linha excluída com sucesso!");
	ps.close();
	
	
}
	
}
