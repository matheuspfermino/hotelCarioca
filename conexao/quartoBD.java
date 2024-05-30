package conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quarto;
import model.QuartoTableModel;

public class quartoBD {

        public static void insertQuarto (Quarto q){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelj";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into quarto(nPessoa,id,tipoQuarto) values (?,?,?)"
            );
            preparedStatement.setString(1,q.getNumPessoa());
            preparedStatement.setString(2,q.getID());
            preparedStatement.setString(3,q.getTipo());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(quartoBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }
        public static void updateQuarto(Quarto q) {
    String jdbcURL = "jdbc:mysql://localhost:3306/hotelj";
    String jdbcUsername = "root";
    String jdbcPassword = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                "UPDATE quarto SET nPessoa=?, tipoQuarto=? WHERE id=?"
        );
        
        preparedStatement.setString(1,q.getNumPessoa());
        preparedStatement.setString(2,q.getTipo());
        
        preparedStatement.setString(3,q.getID());
        
        

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(quartoBD.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    public static void DeleteQuarto(Quarto q){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from quarto WHERE id = ?");

            preparedStatement.setString(1, q.getID());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(quartoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}


