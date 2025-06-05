package Model;

import Dados.*;

import java.util.List;
import java.util.Objects;

public class Funcionario  extends  Usuario {

    private int funcId;
    private String nome;
    private String cargo;
    private String endereco;
    private String telefone;
    private String status;

    List<Aluno> alunos;
    List<Curso> cursos;


    public Funcionario() {
    }

    public Funcionario(int funcId, String nome, String cargo, String email, String senha) {
        super(email, senha);
        this.funcId = funcId;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Funcionario(int funcId, String nome, String cargo) {
    }

    public List<Curso> consultarCursos() {
        return cursos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Aluno cadastrarAluno(String email, String senha, int id, String nome, String cpf, String telefone, String endereco) {
        Aluno novoAluno = new Aluno(id, nome, cpf, email, telefone, endereco, senha);
        alunos.add(novoAluno);
        return novoAluno;
    }

    public Aluno listarAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getAlunoID() == id) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> atualizarDados(int id, String novoTelefone, String novoEndereco, String novoEmail) {
        for (Aluno aluno : alunos) {
            if (aluno.getAlunoID() == id) {
                if (novoTelefone != null) {
                    aluno.setTelefone(novoTelefone);
                }
                if (novoEndereco != null) {
                    aluno.setEndereco(novoEndereco);
                }
                if (novoEmail != null) {
                    aluno.setEmail(novoEmail);
                }

                System.out.println
                        (
                                "Dados atualizados com sucesso!");
                return alunos;
            }
        }
        System.out.println("Aluno não encontrado.");
        return alunos;
    }


    public List<Aluno> ExcluirAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getAlunoID() == id) {
                alunos.remove(aluno);
                System.out.println("Aluno excluído com sucesso!");
                return alunos;
            }
            break;
        }
        System.out.println("Aluno não encontrado.");
        return null;
    }

    public boolean matricularAlunoEmCurso(Aluno aluno, int cursoId, List<Curso> cursosDisponiveis) {
        List<Curso> cursos = aluno != null ? aluno.getCursos() : null;

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return false;
        }

        for (Curso curso : cursos) {
            if (curso.getCursoID() == cursoId) {
                if (cursosDisponiveis.contains(curso)) {
                    System.out.println("Aluno já está matriculado neste curso.");
                    return false;
                }
                System.out.println("Aluno matriculado com sucesso!");
                return true;
            } else {
                System.out.println("Curso não encontrado.");
                return false;
            }
        } return true;
    }


    public Curso cadastrarCurso(int cursoID, String nome, String categoria, int duracao, String status) {

        for (Curso curso : cursos) {
            if (curso.getCursoID() == cursoID) {
                System.out.println("Já existe um curso com esse ID.");
                return null;
            }
        }
        Curso novoCurso = new Curso(cursoID, nome,categoria,duracao,status);
        cursos.add(novoCurso);
        System.out.println("Curso cadastrado com sucesso!");
        return novoCurso;
    }


    public List<Curso> listarCursos() {
        for (Curso curso : cursos) {
            System.out.println("ID: " + curso.getCursoID()
                    + ", Nome: " + curso.getNome()
                    + ", Categoria: " + curso.getCategoria()
                    + ", Duração: " + curso.getDuracao()
                    + ", Status: " + curso.getStatusCurso());
        }
        return cursos;
    }


    public boolean atualizarCurso(int cursoID, String novoNome, String novaCategoria, int novaDuracao, String novoStatus) {
        for (Curso curso : cursos) {
            if (curso.getCursoID() == cursoID) {
                curso.setNome(novoNome);
                curso.setCategoria(novaCategoria);
                curso.setDuracao(novaDuracao);
                curso.setStatusCurso(novoStatus);
                System.out.println("Curso atualizado com sucesso!");
                return true;
            }
        }
        System.out.println("Curso não encontrado.");
        return false;
    }
    public boolean excluirCurso(int cursoID) {
        for (Curso curso : cursos) {
            if (curso.getCursoID() == cursoID) {
                cursos.remove(curso);
                System.out.println("Curso excluído com sucesso!");
                return true;
            }
        }
        System.out.println("Curso não encontrado.");
        return false;
    }
    String relatorioAcademico;
    public String relatorioAcademico() {
        for (Aluno aluno : alunos) {
            relatorioAcademico = ("Relatório Acadêmico:\n"
                    +"ID: " + aluno.getAlunoID()
                    + ", Nome: " + aluno.getNome()
                    + ", Email: " + aluno.getEmail()
                    + ", Telefone: " + aluno.getTelefone()
                    + ", Endereço: " + aluno.getEndereco()
                    + "\n");
        }
        return relatorioAcademico;
    }

}
