package lk.ijse.dep10.jdbc;

import com.jdbc.JdbcApi;
import com.microsoft.dbms.SQLServer;
import com.mysql.dbms.MySQLServer;
import com.oracle.dbms.OracleServer;

public class ClientApp {
    public static void main(String[] args) {
        JdbcApi oracleServer = new OracleServer();
        String response = oracleServer.execute("hello");
        System.out.println(response);

        JdbcApi MySQLServer = new MySQLServer();
        response = MySQLServer.execute("hello");
        System.out.println(response);

//        OracleServer oracleServer = new OracleServer();
//        String response = oracleServer.executeCommand("hello");
//        System.out.println(response);
//
//        MySQLServer mySQLServer = new MySQLServer();
//        byte[] bytes = mySQLServer.run("hello");
//        response = new String(bytes);
//        System.out.println(response);
//
//        SQLServer sqlServer = new SQLServer();
//        StringBuilder stringBuilder = sqlServer.interpret("hello".getBytes());
//        response = stringBuilder.toString();
//        System.out.println(response);
    }
}
