import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.salvar(comoda);
			//List<Produto> produtos = persistenciaProduto.listar(); 
		}
		System.out.println(comoda);
	}

}
