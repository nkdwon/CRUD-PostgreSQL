package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conexao;

    public DAO() {
        conexao = null;
    }

    public Connection conectar() {
        try {
            String url = "jdbc:postgresql://localhost:5432/CRUD Locadora Jogos";
            String usuario = "postgres"; 
            String senha = "root"; 

            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    // READ 
    public List<Jogos> listar() {
        List<Jogos> jogos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM \"Jogos\" ORDER BY \"Id\" ASC";  
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String nome = rs.getString("Nome");
                String plataforma = rs.getString("Plataforma");
                String genero = rs.getString("Gênero");

                Jogos jogo = new Jogos(id, nome, plataforma, genero);
                jogos.add(jogo);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar os jogos: " + e.getMessage());
        }
        return jogos;
    }

    // CREATE 
    public void inserir(Jogos jogo) {
        try {
            String sql = "INSERT INTO \"Jogos\" (\"Nome\", \"Plataforma\", \"Gênero\") VALUES (?, ?, ?)"; 
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getPlataforma());
            stmt.setString(3, jogo.getGenero());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Jogo inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o jogo: " + e.getMessage());
        }
    }

    // UPDATE
    public void atualizar(Jogos jogo) {
        try {
            String sql = "UPDATE \"Jogos\" SET \"Nome\" = ?, \"Plataforma\" = ?, \"Gênero\" = ? WHERE \"Id\" = ?"; 
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getPlataforma());
            stmt.setString(3, jogo.getGenero());
            stmt.setInt(4, jogo.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Jogo atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o jogo: " + e.getMessage());
        }
    }

    // DELETE
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM \"Jogos\" WHERE \"Id\" = ?"; 
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Jogo excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o jogo: " + e.getMessage());
        }
    }
}
