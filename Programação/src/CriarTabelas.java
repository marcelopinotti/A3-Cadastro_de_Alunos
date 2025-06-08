import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriarTabelas {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco";
        String user = "root";
        String password = "sua_senha";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE Professor (" +
                    "professorID INT PRIMARY KEY," +
                    "nome VARCHAR(255)," +
                    "login VARCHAR(50) UNIQUE," +
                    "senha VARCHAR(255))");

            stmt.execute("CREATE TABLE Funcionario (" +
                    "funcionarioID INT PRIMARY KEY," +
                    "nome VARCHAR(255)," +
                    "cargo VARCHAR(100)," +
                    "login VARCHAR(50) UNIQUE," +
                    "senha VARCHAR(255))");

            stmt.execute("CREATE TABLE Curso (" +
                    "cursoID INT PRIMARY KEY," +
                    "nome VARCHAR(255)," +
                    "categoria VARCHAR(100)," +
                    "duracao INT," +
                    "statusCurso VARCHAR(50))");

            stmt.execute("CREATE TABLE Aluno (" +
                    "alunoID INT PRIMARY KEY," +
                    "nome VARCHAR(255)," +
                    "cpf VARCHAR(14) UNIQUE," +
                    "email VARCHAR(255)," +
                    "telefone VARCHAR(20)," +
                    "endereco VARCHAR(255)," +
                    "login VARCHAR(50) UNIQUE," +
                    "senha VARCHAR(255))");

            stmt.execute("CREATE TABLE Nota (" +
                    "notaID INT PRIMARY KEY," +
                    "valorNota DOUBLE," +
                    "dataLancamento DATE," +
                    "alunoID INT," +
                    "cursoID INT," +
                    "FOREIGN KEY (alunoID) REFERENCES Aluno(alunoID)," +
                    "FOREIGN KEY (cursoID) REFERENCES Curso(cursoID))");

            stmt.execute("CREATE TABLE Administrador (" +
                    "adminID INT PRIMARY KEY," +
                    "login VARCHAR(50) UNIQUE," +
                    "senha VARCHAR(255))");

            stmt.execute("CREATE TABLE Professor_Curso (" +
                    "professorID INT," +
                    "cursoID INT," +
                    "PRIMARY KEY (professorID, cursoID)," +
                    "FOREIGN KEY (professorID) REFERENCES Professor(professorID)," +
                    "FOREIGN KEY (cursoID) REFERENCES Curso(cursoID))");

            stmt.execute("CREATE TABLE Aluno_Curso (" +
                    "alunoID INT," +
                    "cursoID INT," +
                    "PRIMARY KEY (alunoID, cursoID)," +
                    "FOREIGN KEY (alunoID) REFERENCES Aluno(alunoID)," +
                    "FOREIGN KEY (cursoID) REFERENCES Curso(cursoID))");

            System.out.println("Tabelas criadas com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}