package dao;

import CadastrodeAluno.util.Database;
import model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private final Connection connection = Database.getConnection();

    public ProfessorDAO() throws SQLException {
    }

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * FROM professor WHERE login = ? AND senha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Aluno> buscarAlunosPorCurso(int cursoID) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.* FROM aluno a JOIN matricula m ON a.id = m.aluno_id WHERE m.curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cursoID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("alunoID"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
