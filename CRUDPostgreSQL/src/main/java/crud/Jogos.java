package crud;

public class Jogos {

	private int Id;
	private String Nome;
	private String Plataforma;
	private String Genero;
	
	public Jogos() {
		this.Id = -1;
		this.Nome = "";
		this.Plataforma = "";
		this.Genero = "";
	}
	
	public Jogos(int id, String nome, String plataforma, String genero) {
		this.Id = id;
		this.Nome = nome;
		this.Plataforma = plataforma ;
		this.Genero =  genero;
	}
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPlataforma() {
		return Plataforma;
	}

	public void setPlataforma(String plataforma) {
		Plataforma = plataforma;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	@Override
	public String toString() {
		return "Jogos [Id=" + Id + ", Nome=" + Nome + ", Plataforma=" + Plataforma + ", Genero=" + Genero + "]";
	}

	
	
}
