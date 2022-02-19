package com.github.sosedvovan.repository;

import com.github.sosedvovan.model.Zapis;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SqlStorage {

    String dbUrl = "jdbc:postgresql://localhost:5432/zametki";
    String dbUser = "postgres";
    String dbPassword = "00821821";

//    Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    //    public void clear(){
//        try {
//            PreparedStatement ps = connection.prepareStatement("DELETE FROM zametki");
//            ps.execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
    public void save(Zapis z) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO zametki (id, datetime, description1, description2) VALUES (?,?,?,?)")) {
            ps.setInt(1, z.getId());
            ps.setString(2, z.getDateTime());
            ps.setString(3, z.getDescription1());
            ps.setString(4, z.getDescription2());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Zapis> getAll() {
        List<Zapis> allZapis = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM zametki ORDER BY id")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Zapis z = new Zapis(rs.getInt("id"), rs.getString("dateTime"),
                        rs.getString("description1"), rs.getString("description2"));
                allZapis.add(z);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        System.out.println("Служебное сообщение List<Zapis>: " + allZapis);

        return allZapis;
    }

    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = connection.prepareStatement("DELETE FROM zametki WHERE id=?")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
