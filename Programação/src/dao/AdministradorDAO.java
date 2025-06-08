package dao;

import CadastrodeAluno.util.Database;
import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
    private final Connection connection = Database.getConnection();

    public AdministradorDAO() throws SQLException {
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, login, senha, ativo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.setBoolean(4, funcionario.isAtivo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                funcionario.setFuncionarioID(rs.getInt(1));
            }
            return funcionario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getInt("id"), rs.getString("nome"),
                        rs.getString("login"), rs.getString("senha"),
                        rs.getBoolean("ativo")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean editarFuncionario(int id, Funcionario novoData) {
        String sql = "UPDATE funcionario SET nome=?, login=?, senha=?, ativo=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoData.getNome());
            stmt.setString(2, novoData.getLogin());
            stmt.setString(3, novoData.getSenha());
            stmt.setBoolean(4, novoData.isAtivo());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarStatus(int id, boolean ativo) {
        String sql = "UPDATE funcionario SET ativo=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, ativo);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean associarProfessorACurso(int professorID, int cursoID) {
        String sql = "INSERT INTO professor_curso (professor_id, curso_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, professorID);
            stmt.setInt(2, cursoID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
