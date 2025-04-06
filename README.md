# Projeto Java + MySQL

Este é um projeto simples em Java que conecta ao MySQL e cria automaticamente as seguintes tabelas:

- `pessoa`
- `endereco` (relacionada à pessoa)
- `telefone` (relacionada à pessoa)

## 🚀 Como executar

### Requisitos:
- Java JDK 17+
- MySQL instalado (localhost)
- IntelliJ Community Edition
- Driver JDBC do MySQL (ex: `mysql-connector-j-8.x.x.jar`)

### Configuração

1. Certifique-se de que o MySQL está rodando.
2. Crie o banco de dados via terminal:

```sql
CREATE DATABASE projeto_java;
