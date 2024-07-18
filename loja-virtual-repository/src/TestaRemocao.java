import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(final String[] args) throws SQLException {
		final ConnectionFactory factory = new ConnectionFactory();

		final Connection connection = factory.recuperarConexao();

		final Statement stm = connection.createStatement();

		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");

		final Integer linhasModificadas = stm.getUpdateCount();

		System.out.println("Quantidade de linhas modificadas: " +  linhasModificadas);
	}
}