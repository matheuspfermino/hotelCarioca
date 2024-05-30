package conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CadastroFunc;
import model.ClienteTableModel;

public class funcBD {

        public static void insertFunc (CadastroFunc f){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into funcionario(nome,cpf,email,telefone,nascimento,endereco,cargo,salario) values (?,?,?,?,?,?,?,?)"
            );
                        // preenche os valores
            preparedStatement.setString(1,f.getNome());
            preparedStatement.setString(2,f.getCpf());
            preparedStatement.setString(3,f.getEmail());
            preparedStatement.setString(4,f.getTelefone());
            preparedStatement.setString(5,f.getNascimento());
            preparedStatement.setString(6,f.getEndereco());
            preparedStatement.setString(7,f.getCargo());
            preparedStatement.setString(8,f.getSalario());
            

            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(funcBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }
        
        public static void DeleteFunc (CadastroFunc f){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from funcionario WHERE cpf = ?");
                
            preparedStatement.setString(1, f.getCpf());
            
            preparedStatement.executeUpdate();

         
            

            
            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(funcBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
       } 
        
        public static void updateFunc(CadastroFunc f) {
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Correção: Use SET corretamente
            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE funcionario SET nome=?, cpf=?, email=?, telefone=?,nascimento=?,endereco=?,cargo=?,salario=? WHERE cpf=?"
            );

            preparedStatement.setString(1,f.getNome());
            preparedStatement.setString(2,f.getCpf());
            preparedStatement.setString(3,f.getEmail());
            preparedStatement.setString(4,f.getTelefone());
            preparedStatement.setString(5,f.getNascimento());
            preparedStatement.setString(6,f.getEndereco());
            preparedStatement.setString(7,f.getCargo());
            preparedStatement.setString(8,f.getSalario());

            // Use o CPF como identificador único na cláusula WHERE
            preparedStatement.setString(9, f.getCpf());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Atualizado!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    } 
        
}

