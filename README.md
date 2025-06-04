# 📚 Sistema de Cadastro de Alunos

Este projeto tem como objetivo o desenvolvimento de um sistema para gerenciar alunos, cursos, matrículas, notas e usuários em uma instituição de ensino, com acesso segmentado por perfis (Aluno, Professor, Funcionário e Administrador).

Projeto de A3 da UNP, utilizando modelagem UML (PlantUML), implementação em Java e integração com banco de dados SQL. O design da interface foi desenvolvido com auxílio do Figma.

---

## ✅ Requisitos Funcionais (RF)

### 🎓 Gestão de Alunos (Funcionário)
- **RF001**: Cadastrar um novo aluno com nome, CPF, e-mail, telefone e endereço.
- **RF002**: Consultar e listar todos os alunos cadastrados.
- **RF003**: Atualizar dados de um aluno existente.
- **RF004**: Excluir o registro de um aluno.
- **RF005**: Matricular um aluno em um curso.
- **RF006**: Atualizar o status da matrícula de um aluno (ativo, trancado, concluído).
- **RF007**: Validar dados inseridos (ex: CPF, e-mail, campos obrigatórios).
- **RF008**: Notificar sobre sucesso ou falha no cadastro/atualização.
- **RF009**: Permitir que o aluno atualize seus próprios dados (exceto CPF).

### 📘 Gestão de Cursos (Funcionário)
- **RF010**: Cadastrar novo curso com nome, categoria, duração etc.
- **RF011**: Consultar e listar cursos cadastrados.
- **RF012**: Excluir um curso.
- **RF013**: Associar um professor a um curso.

### 📝 Gestão de Notas (Professor)
- **RF014**: Registrar notas para alunos em seus cursos.
- **RF015**: Atualizar notas registradas.

### 🔎 Consultas e Histórico Acadêmico
- **RF016**: Aluno pode consultar suas próprias notas.
- **RF017**: Aluno pode consultar seu histórico acadêmico.
- **RF018**: Professor pode consultar alunos matriculados em seus cursos.
- **RF019**: Professor pode consultar notas dos seus alunos.
- **RF020**: Funcionário pode consultar notas de um aluno.
- **RF021**: Funcionário pode consultar o histórico acadêmico de um aluno.

### 🔐 Administração do Sistema (Administrador)
- **RF022**: Cadastrar novo funcionário.
- **RF023**: Consultar e listar todos os funcionários.
- **RF024**: Atualizar dados de um funcionário.
- **RF025**: Excluir ou inativar um funcionário.

### 🔓 Autenticação e Acesso
- **RF026**: Autenticação para Aluno, Professor, Funcionário e Administrador.
- **RF027**: Controle de acesso baseado no perfil do usuário.
- **RF028**: Logout de usuários.

---

## 🛠️ Requisitos Não Funcionais (RNF)

### 🎯 Usabilidade
- **RNF001**: Interface intuitiva e de fácil aprendizado.
- **RNF002**: Feedback claro ao usuário (mensagens de sucesso, erro, etc.).
- **RNF003**: Tempo de resposta ≤ 3 segundos para ações comuns.
- **RNF004**: Compatibilidade com navegadores modernos (Chrome, Firefox, Edge, Safari).

### ⚡ Desempenho
- **RNF005**: Suporte a múltiplos usuários simultâneos.
- **RNF006**: Consultas retornadas em até 5 segundos.

### 🔒 Segurança
- **RNF007**: Armazenamento seguro de dados sensíveis (ex: senhas com hash).
- **RNF008**: Proteção contra ataques (SQL Injection, XSS).
- **RNF009**: Acesso controlado via autenticação e autorização.
- **RNF010**: Registro de logs de acesso e alterações importantes.

### 🧱 Confiabilidade
- **RNF011**: Disponibilidade do sistema: 24h por dia.
- **RNF012**: Backup regular dos dados.
- **RNF013**: Mensagens claras de erro na validação de dados.

### 🧹 Manutenibilidade
- **RNF014**: Código-fonte documentado e seguindo boas práticas.
- **RNF015**: Arquitetura modular baseada em camadas (Tela, Controller, Serviço, etc.).

---
