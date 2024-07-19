import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		Categoria categoria = new Categoria("Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			categoriaDao.salvar(categoria);
			List<Categoria> categorias = categoriaDao.listar();
			categorias.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
	}

}
