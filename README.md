# Clinica Médica em Java

> Aplicação console em Java para gerenciamento de médicos, pacientes, agendamentos e consultas.

---

## 📋 Índice

- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Arquitetura e Organização](#arquitetura-e-organização)
- [Funcionalidades](#funcionalidades)
- [Medidas de Segurança](#medidas-de-segurança)
- [Bibliotecas Utilizadas](#bibliotecas-utilizadas)
- [Notas Importantes](#notas-importantes)

---

## 🔧 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java JDK 8 ou superior**
- **VS Code** ou qualquer editor/IDE Java
- **Terminal ou prompt de comando** com acesso a `javac` e `java`
- Pasta `Arquivos/` com as subpastas:
  - `Agendamentos`
  - `(ListaEspera)Agendamentos`
  - `Consultas Realizadas`
  - `Pacientes`
  - `Staff`

---

## 🚀 Instalação

### 1. Clone ou abra o projeto

Abra o projeto em sua IDE ou terminal.

### 2. Compile o projeto

No terminal, a partir da raiz do projeto:

```powershell
javac -d bin src\App.java src\controlador\*.java src\entidades\*.java src\exceptions\*.java src\paineis\*.java src\servicos\*.java
```

> Se estiver usando Linux ou macOS, troque `\` por `/`.

### 3. Execute a aplicação

```powershell
java -cp bin App
```

A aplicação é executada no console e exibe um menu interativo.

---

## 🏗️ Arquitetura e Organização

O projeto segue uma organização simples de um sistema console em Java.

### Estrutura de pastas

```
src/
├── App.java
├── controlador/
│   ├── Agenda.java
│   ├── Clientes.java
│   ├── ConsultasRealizadas.java
│   └── Staff.java
├── entidades/
│   ├── Agendamento.java
│   ├── Medico.java
│   └── Paciente.java
├── exceptions/
│   ├── AgendamentoIndisponivelException.java
│   ├── AgendamentoNaoEncontradoException.java
│   ├── DataIncorretaException.java
│   ├── MedicoJaCadastradoException.java
│   ├── MedicoNaoEncontradoException.java
│   ├── PacienteJaCadastradoException.java
│   └── PacienteNaoEncontradoException.java
├── paineis/
│   └── MenuPrincipal.java
└── servicos/
    ├── Consulta.java
    ├── Inicializador.java
    └── Relatorio.java
```

### O que cada pasta faz

- `src/`: código-fonte principal.
- `controlador/`: lógica de negócio e persistência em arquivos.
- `entidades/`: classes de modelo de dados.
- `exceptions/`: tratamento de erros específicos.
- `paineis/`: exibe menus de texto no console.
- `servicos/`: funcionalidades auxiliares, como inicialização e relatórios.

---

## 🎯 Funcionalidades

### Gestão de médicos
- Cadastrar médicos
- Alterar dados de médicos
- Remover médicos
- Pesquisar médicos por ID
- Listar todos os médicos

### Gestão de pacientes
- Cadastrar pacientes
- Alterar dados de pacientes
- Remover pacientes
- Pesquisar pacientes por ID
- Listar todos os pacientes

### Agendamentos
- Agendar consultas
- Verificar conflito de horário para o mesmo médico, dia e hora
- Manter fila de espera para horários ocupados
- Cancelar agendamentos e mover paciente da fila de espera

### Consultas realizadas
- Registrar consultas concluídas
- Gerar arquivo de histórico de consultas
- Visualizar relatórios simples pelo menu

---

## 🔐 Medidas de Segurança

- Validação de IDs duplicados para médicos e pacientes
- Tratamento de exceções específicas para:
  - médico não encontrado
  - paciente não encontrado
  - agendamento indisponível
- Verificação de conflito de horário antes de gravar agendamentos
- Persistência de dados em arquivos de texto para manter informações entre execuções

> Observação: não há autenticação de usuário nem criptografia de senha. A segurança é focada em validação de dados e tratamento de erros.

---

## 📚 Bibliotecas Utilizadas

O projeto usa apenas bibliotecas padrão do Java SE:

- `java.io` para leitura e escrita de arquivos
- `java.util` para coleções e entrada de dados
- `java.text` em parte da inicialização de agendamentos

Não há dependências externas ou frameworks adicionais.

---
