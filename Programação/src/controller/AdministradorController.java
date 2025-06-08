package controller;

import dao.AdministradorDAO;
import model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class AdministradorController {
    private final AdministradorDAO administradorDAO = new AdministradorDAO();

    public AdministradorController() throws SQLException {
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return administradorDAO.cadastrarFuncionario(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return administradorDAO.listarFuncionarios();
    }

    public boolean editarFuncionario(int id, Funcionario novoData) {
        return administradorDAO.editarFuncionario(id, novoData);
    }

    public boolean alterarStatusFuncionario(int id, boolean ativo) {
        return administradorDAO.alterarStatus(id,ativo);
    }

    public boolean associarProfessorACurso(int professorID, int cursoID) {
        return administradorDAO.associarProfessorACurso(professorID, cursoID);
    }
}