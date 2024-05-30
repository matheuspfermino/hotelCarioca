package conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Checkin;
import model.CheckinTableModel;

public class checkinBD {

        public static void insertcheckin (Checkin c){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into checkin(pagamento,cpf,data,valor) values (?,?,?,?)"
            );
                        // preenche os valores
            preparedStatement.setString(1,c.getFormaPag());
            preparedStatement.setString(2,c.getCPF());
            preparedStatement.setString(3,c.getData());
            preparedStatement.setString(4,c.getValor());
            

            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkinBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }
        public static void updateCheckin(Checkin c) {
    String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
    String jdbcUsername = "root";
    String jdbcPassword = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                "UPDATE checkin SET pagamento=?, cpf=?, data=?, valor=? WHERE cpf=?"
        );

            preparedStatement.setString(1,c.getFormaPag());
            preparedStatement.setString(2,c.getCPF());
            preparedStatement.setString(3,c.getData());
            preparedStatement.setString(4,c.getValor());


        preparedStatement.setString(5, c.getCPF());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkinBD.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    public static void DeleteCheckin(Checkin c){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelJ";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from checkin WHERE cpf = ?");

        preparedStatement.setString(1, c.getCPF());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkinBD.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

