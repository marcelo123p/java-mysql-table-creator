import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/projeto_java";
        String user = "root";
        String password = ""; 

        // Cada SQL separado
        String createPessoa = """
            CREATE TABLE IF NOT EXISTS pessoa (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100),
                idade INT,
                email VARCHAR(100)
            );
        """;

        String createEndereco = """
            CREATE TABLE IF NOT EXISTS endereco (
                id INT AUTO_INCREMENT PRIMARY KEY,
                pessoa_id INT,
                rua VARCHAR(100),
                cidade VARCHAR(50),
                estado VARCHAR(50),
                FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
            );
        """;

        String createTelefone = """
            CREATE TABLE IF NOT EXISTS telefone (
                id INT AUTO_INCREMENT PRIMARY KEY,
                pessoa_id INT,
                numero VARCHAR(20),
                tipo VARCHAR(20),
                FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
            );
        """;

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute(createPessoa);
            stmt.execute(createEndereco);
            stmt.execute(createTelefone);

            System.out.println("✅ Tabelas criadas com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao criar as tabelas:");
            e.printStackTrace();
        }
    }
}
