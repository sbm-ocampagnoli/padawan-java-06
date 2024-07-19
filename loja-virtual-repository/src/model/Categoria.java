package model;

public class Categoria {
	private Integer id;
	private String nome;

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return String.format("A categoria é: %d, %s", this.id, this.nome);
	}
}
