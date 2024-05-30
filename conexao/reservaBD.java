package conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reserva;
import model.ReservaTableModel;

public class reservaBD {

        public static void insertReserva (Reserva r){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelj";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into reserva(nreserva,id,npessoas,checkin,checkout) values (?,?,?,?,?)"
            );
            
            preparedStatement.setString(1,r.getNumreserva());
            preparedStatement.setString(2,r.getID());
            preparedStatement.setString(3,r.getNumpessoas());
            preparedStatement.setString(4,r.getDatain());
            preparedStatement.setString(5,r.getDataout());
            

            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservaBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }
        public static void updateReserva(Reserva r) {
    String jdbcURL = "jdbc:mysql://localhost:3306/hotelj";
    String jdbcUsername = "root";
    String jdbcPassword = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                "UPDATE reserva SET nreserva=?, npessoas=?, checkin=?, checkout=? WHERE id=?"
        );
        
        preparedStatement.setString(1, r.getNumreserva());
        preparedStatement.setString(2, r.getNumpessoas());
        preparedStatement.setString(3, r.getDatain());
        preparedStatement.setString(4, r.getDataout());


        preparedStatement.setString(5, r.getID());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservaBD.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    public static void DeleteReserva(Reserva r){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/hotelj";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from reserva WHERE id = ?");

            preparedStatement.setString(1, r.getID());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

