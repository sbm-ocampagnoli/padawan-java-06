import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC", "root", "root");

		System.out.println("Fechando a conexão!");
		connection.close();
	}

}
