import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);

		try {

			String sql = "INSERT INTO PRODUTO (nome, descricao) Values (?, ?)";

			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			adicionaVariavel("Tv Smart", "32 Polegadas", stm);
			adicionaVariavel("Radio", "a pilha", stm);
			
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			int id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}

}
