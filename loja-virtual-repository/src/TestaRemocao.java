import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(final String[] args) throws SQLException {
		final ConnectionFactory factory = new ConnectionFactory();

		final Connection connection = factory.recuperarConexao();

		final PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");

		stm.setInt(1, 2);
		
		stm.execute();

		int linhasModificadas = stm.getUpdateCount();

		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
	}
}