package controller;

import model.Aluno;
import model.Curso;
import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public FuncionarioController() throws SQLException {
    }

    public boolean autenticar(String login, String senha) {
        return funcionarioDAO.autenticar(login, senha);
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return funcionarioDAO.cadastrarAluno(aluno);
    }

    public boolean atualizarAluno(int alunoID, Aluno AlunoData) {
        return funcionarioDAO.atualizarAluno(alunoID, AlunoData);
    }

    public boolean excluirAluno(int alunoID) {
        return funcionarioDAO.excluirAluno(alunoID);
    }

    public Curso cadastrarCurso(Curso curso) {
        return funcionarioDAO.cadastrarCurso(curso);
    }

    public boolean atualizarCurso(int cursoID, Curso curso) {
        return funcionarioDAO.atualizarCurso(cursoID, curso);
    }

    public boolean excluirCurso(int cursoID) {
        return funcionarioDAO.excluirCurso(cursoID);
    }

    public List<Aluno> listarAlunos() {
        return funcionarioDAO.listarAlunos();
    }

    public List<Curso> listarCursos() {
        return funcionarioDAO.listarCursos();
    }

    public List<String> gerarRelatorioAcademico(String tipoRelatorio) {
        return funcionarioDAO.gerarRelatorioAcademico(tipoRelatorio);
    }
}
