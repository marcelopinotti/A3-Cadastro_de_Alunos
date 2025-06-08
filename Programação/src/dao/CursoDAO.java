package dao;

import CadastrodeAluno.util.Database;
import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final Connection connection = Database.getConnection();

    public CursoDAO() throws SQLException {
    }

    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Curso(rs.getInt("cursoID"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getString("statusCurso"),
                        rs.getInt("professorID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Curso> buscarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("cursoID"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getString("statusCurso"),
                        rs.getInt("professorID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
