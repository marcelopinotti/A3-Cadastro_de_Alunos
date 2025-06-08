package CadastrodeAluno.main;

import CadastrodeAluno.util.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CriadorTabela {

    public static void createTables() throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = Database.getConnection(); // Obtém a conexão com o banco de dados
            stmt = conn.createStatement();   // Cria um objeto Statement para executar SQL

            System.out.println("DatabaseInitializer: Iniciando a criação das tabelas...");

            // Tabela Professor
            String createProfessorTable = "CREATE TABLE IF NOT EXISTS Professor (" +
                    "professorID INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(75) NOT NULL," +
                    "login VARCHAR(75) NOT NULL," +
                    "senha VARCHAR(30) NOT NULL," +
                    "autenticado BOOLEAN DEFAULT FALSE" +
                    ")";
            stmt.execute(createProfessorTable);
            System.out.println("DatabaseInitializer: Tabela 'Professor' criada ou já existe.");

            // Tabela Curso
            String createCursoTable = "CREATE TABLE IF NOT EXISTS Curso (" +
                    "cursoID INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(75) NOT NULL," +
                    "categoria VARCHAR(75) NOT NULL," +
                    "duracao INT NOT NULL," +
                    "statusCurso VARCHAR(75) NOT NULL" +
                    ")";
            stmt.execute(createCursoTable);
            System.out.println("DatabaseInitializer: Tabela 'Curso' criada ou já existe.");

            // Tabela Funcionario
            String createFuncionarioTable = "CREATE TABLE IF NOT EXISTS Funcionario (" +
                    "funcionarioID INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(75) NOT NULL," +
                    "cargo VARCHAR(75) NOT NULL," +
                    "login VARCHAR(75)  NOT NULL," +
                    "senha VARCHAR(30) NOT NULL," +
                    "autenticado BOOLEAN DEFAULT FALSE" +
                    ")";

            stmt.execute(createFuncionarioTable);
            System.out.println("DatabaseInitializer: Tabela 'Funcionario' criada ou já existe.");

            // Tabela Aluno
            String createAlunoTable = "CREATE TABLE IF NOT EXISTS Aluno (" +
                    "alunoID INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(75) NOT NULL," +
                    "cpf VARCHAR(14) UNIQUE NOT NULL," +
                    "telefone VARCHAR(20) NOT NULL," +
                    "email VARCHAR(75) NOT NULL," +
                    "endereco VARCHAR(150) NOT NULL," +
                    "autenticado BOOLEAN DEFAULT FALSE" +
                    ")";
            stmt.execute(createAlunoTable);
            System.out.println("DatabaseInitializer: Tabela 'Aluno' criada ou já existe.");

            // Tabela Nota
            String createNotaTable = "CREATE TABLE IF NOT EXISTS Nota (" +
                    "notaID INT PRIMARY KEY AUTO_INCREMENT," +
                    "valorNota DOUBLE NOT NULL," +
                    "dataLancamento DATE NOT NULL," +
                    "alunoID INT NOT NULL," +
                    "cursoID INT NOT NULL," +
                    "FOREIGN KEY (alunoID) REFERENCES Aluno(alunoID)," + // Possui chaves estrangeiras para Aluno e Curso
                    "FOREIGN KEY (cursoID) REFERENCES Curso(cursoID)" +
                    ")";
            stmt.execute(createNotaTable);
            System.out.println("DatabaseInitializer: Tabela 'Nota' criada ou já existe.");

            // Tabela associativa Professor ao Curso
            String createProfessorCursoTable = "CREATE TABLE IF NOT EXISTS Professor_Curso (" +
                    "professorID INT UNIQUE NOT NULL," +
                    "cursoID INT UNIQUE NOT NULL," +
                    "PRIMARY KEY (professorID, cursoID)," + // Chave primária composta
                    "FOREIGN KEY (professorID) REFERENCES Professor(professorID)," +
                    "FOREIGN KEY (cursoID) REFERENCES Curso(cursoID)" +
                    ")";
            stmt.execute(createProfessorCursoTable);
            System.out.println("DatabaseInitializer: Tabela 'Professor_Curso' criada ou já existe.");

            // Tabela Administrador
            String createAdministradorTable = "CREATE TABLE IF NOT EXISTS Administrador (" +
                    "administradorID INT PRIMARY KEY," + // Mesmo ID do funcionário correspondente
                    "FOREIGN KEY (administradorID) REFERENCES Funcionario(funcionarioID)" +
                    ")";
            stmt.execute(createAdministradorTable);
            System.out.println("DatabaseInitializer: Tabela 'Administrador' criada ou já existe.");

            System.out.println("DatabaseInitializer: Todas as tabelas foram processadas com sucesso!");

        } catch (SQLException e) {
            System.err.println("DatabaseInitializer - ERRO ao criar tabelas: " + e.getMessage());
            e.printStackTrace();
            throw e; // Relança a exceção para o chamador
        } finally {
            // Garante que o Statement e a Conexão sejam fechados
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("DatabaseInitializer - ERRO ao fechar Statement: " + e.getMessage());
                }
            }

            Database.closeConnection(); // Fecha a conexão após a criação das tabelas.
        }
    }

    // Testar a criação das tabelas

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando o teste de criação de tabelas...");
            CriadorTabela DatabaseInitializer = null;
            DatabaseInitializer.createTables();
            System.out.println("Teste de criação de tabelas concluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro no teste de criação de tabelas: " + e.getMessage());
        }
    }
}