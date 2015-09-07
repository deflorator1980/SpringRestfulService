package db_plain;

import java.sql.*;

public class EasyConnect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ce) {
            System.out.println("No driver");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game2", "root", "root");
            // conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mybase", "postgres", "root");

            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select * from gnomes");
            rs = stmt.executeQuery("select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity" +
                    " from gnomes, items, sales " +
                    " where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id;");
            while (rs.next()) {
                String gnome_name = rs.getString("gnome_name");
                String gnome_money = rs.getString("gnome_money");
                String item_name = rs.getString("item_name");
                int quantity = rs.getInt("quantity");
                System.out.println(gnome_name + " " + gnome_money + " " + item_name + " " + quantity + " ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                conn.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

