import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet result = stm.getResultSet();
		
		while(result.next()) {
			int id = result.getInt("ID");
			System.out.println(id);
			String nome = result.getString("NOME");
			System.out.println(nome);
			String descricao = result.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		connection.close();
	}
}
