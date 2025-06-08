package controller;

import model.Aluno;
import dao.AlunoDAO;

import java.sql.SQLException;
import java.util.List;

public class AlunoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();

    public AlunoController() throws SQLException {
    }

    public boolean autenticar(String login, String senha) {
        return alunoDAO.autenticar(login, senha);
    }

    public boolean atualizarDados(int alunoID, Aluno novosDados) {
        return alunoDAO.atualizar(alunoID, novosDados);
    }

    public List<String> consultarNotas(int alunoID) {
        return alunoDAO.consultarNotas(alunoID);
    }
}