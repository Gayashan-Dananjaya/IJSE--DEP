package lk.ijse.dep10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloMySQL {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep_10_hello", "root", "Gayashan@1996");
            System.out.println(connection);

            Statement stm = connection.createStatement(); //Regular Statement
//            int affectedRows = stm.executeUpdate("INSERT INTO Student VALUES (6,'Nuwan', 'Ramindu', 'Galle', 'MALE', '2000-05-20')");

//            String updateSql = "UPDATE Student SET address='Matara' WHERE id=6";
//            int affectedRows = stm.executeUpdate(updateSql);

            int affectedRows = stm.executeUpdate("DELETE FROM Student WHERE id=6");
            System.out.println(affectedRows);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Wade Awul...");
            e.printStackTrace();
        }
    }
}
