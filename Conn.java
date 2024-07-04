package BMS;

import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Conn conn = new Conn();
        if (conn.c != null) {
            System.out.println("Connection established");
        }
        try {
            if (conn.c != null) {
                conn.c.close();
                System.out.println("Connection closed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

