import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;
import model.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		Categoria categoria = new Categoria("Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			categoriaDao.salvar(categoria);
			List<Categoria> categorias = categoriaDao.listarComProdutos();
			categorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
