import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		String nome = "Mouse";
		String descricao = "Mouse Gamer Logitech";
		ConnectionFactory factory = new ConnectionFactory();

		Connection connection = factory.recuperarConexao();

		String sql = "INSERT INTO PRODUTO (nome, descricao) Values (?, ?)";

		PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			int id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

	}

}
