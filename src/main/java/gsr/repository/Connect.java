package gsr.repository;

import gsr.model.SqlResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Connect {

    Connection conn = null;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public SqlResponse runQuery(String query){
        boolean success = true;
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("query: " + query);
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String value = rs.getString(1);
                System.out.println(value);
                list.add(value);
            }
        } catch (Exception e){
            e.printStackTrace();
            success = false;
            list = new ArrayList<>();
            list.add("error: " + e.toString());
        }
        System.out.println(list.toString());
        return new SqlResponse(success, list);
    }

    public SqlResponse runInsert(String query){
        boolean success = true;
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("query: " + query);
        try{
            Statement statement = conn.createStatement();
            int updated = statement.executeUpdate(query);
            list.add(Integer.toString(updated));
        } catch (Exception e){
            e.printStackTrace();
            success = false;
            list = new ArrayList<>();
            list.add("error: " + e.toString());
        }
        System.out.println(list.toString());
        return new SqlResponse(success, list);
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",null);
    }
}
