package Model;

import Dados.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private final int professorID;
    private String nome;
    private List<Curso> cursos;
    private List<Nota> notas;

    public Professor(int professorID, String nome) {
        this.professorID = professorID;
        this.nome = nome;
        this.cursos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public int getProfessorID() {
        return professorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Nota registrarNota(int alunoID, int cursoID, double valorNota, LocalDate data) {
        Nota novaNota = new Nota(gerarNotaID(), valorNota, data, cursoID);
        notas.add(novaNota);
        return novaNota;
    }

    private int gerarNotaID() {
        return notas.size() + 1;
    }

    public Nota atualizarNota(int notaID, double novoValor) {
        for (Nota nota : notas) {
            if (nota.getNotaID() == notaID) {
                nota.setValorNota(novoValor);
                return nota;
            }
        }
        return null;
    }

    public List<Nota> consultarNotasAlunosEmSeusCursos(int cursoID) {
        List<Nota> notasCurso = new ArrayList<>();
        for (Nota nota : notas) {
            if (nota.getCursoID() == cursoID) {
                notasCurso.add(nota);
            }
        }
        return notasCurso;
    }

    public List<Aluno> consultarListaAlunosEmSeusCursos(int cursoID, List<Aluno> todosAlunos) {
        List<Aluno> alunosDoCurso = new ArrayList<>();
        for (Aluno aluno : todosAlunos) {
            for (Curso curso : aluno.getCursos()) {
                if (curso.getCursoID() == cursoID) {
                    alunosDoCurso.add(aluno);
                    break;
                }
            }
        }
        return alunosDoCurso;
    }
}
