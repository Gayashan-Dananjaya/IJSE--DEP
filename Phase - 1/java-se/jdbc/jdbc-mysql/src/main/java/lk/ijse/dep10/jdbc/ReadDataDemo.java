package lk.ijse.dep10.jdbc;

import java.sql.*;

public class ReadDataDemo {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep_10_hello", "root", "Gayashan@1996");
            Statement stm = connection.createStatement();

            String sql = "SELECT * FROM Student";
            ResultSet rst = stm.executeQuery(sql);

//            rst.next();
//
//            int id = rst.getInt(1);
//            System.out.println(id);
//
//            id = rst.getInt("id");
//            System.out.println(id);
//
//            String firstName = rst.getString("first_name");
//            System.out.println(firstName);
//
//            String lastName = rst.getString("last_name");
//            System.out.println(lastName);

            while (rst.next()) {
                int id = rst.getInt("id");
                String firstName = rst.getString("first_name");
                String lastName = rst.getString("last_name");
                String address = rst.getString("address");
                String gender = rst.getString("gender");
                Date dob = rst.getDate("dob");

                System.out.printf("|%-5s|%-10s|%-10s|%-10s|%-10s|%-12s| \n", id, firstName, lastName, address, gender, dob);
            }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
