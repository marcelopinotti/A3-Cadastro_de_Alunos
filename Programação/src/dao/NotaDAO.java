package dao;

import CadastrodeAluno.util.Database;
import model.Nota;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaDAO {
    private final Connection connection = Database.getConnection();

    public NotaDAO() throws SQLException {
    }

    public Nota inserirNota(int alunoID, int cursoID, double valorNota, Date data) {
        String sql = "INSERT INTO nota (aluno_id, curso_id, valor, data) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, alunoID);
            stmt.setInt(2, cursoID);
            stmt.setDouble(3, valorNota);
            stmt.setDate(4, new java.sql.Date(data.getTime()));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return new Nota(id, alunoID, cursoID, valorNota, data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizarNota(int notaID, double novoValor) {
        String sql = "UPDATE nota SET valor = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novoValor);
            stmt.setInt(2, notaID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Nota> consultarNotasDosAlunosCurso(int cursoID) {
        List<Nota> notas = new ArrayList<>();
        String sql = "SELECT * FROM nota WHERE curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cursoID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notas.add(new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("curso_id"),
                        rs.getDouble("valor"),
                        rs.getDate("data")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }
}
