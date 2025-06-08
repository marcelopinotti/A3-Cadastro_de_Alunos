package controller;

import model.Aluno;
import model.Nota;
import dao.NotaDAO;
import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProfessorController {
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final NotaDAO notaDAO = new NotaDAO();

    public ProfessorController() throws SQLException {
    }

    public boolean autenticar(String login, String senha) {
        return professorDAO.autenticar(login, senha);
    }

    public Nota registrarNota(int alunoID, int cursoID, double valorNota, Date data) {
        return notaDAO.inserirNota(alunoID, cursoID, valorNota, data);
    }

    public boolean atualizarNota(int notaID, double novoValor) {
        return notaDAO.atualizarNota(notaID, novoValor);
    }

    public List<Nota> consultarNotasDosAlunosCurso(int cursoID) {
        return notaDAO.consultarNotasDosAlunosCurso(cursoID);
    }

    public List<Aluno> consultarAlunosCurso(int cursoID) {
        return professorDAO.buscarAlunosPorCurso(cursoID);
    }
}
