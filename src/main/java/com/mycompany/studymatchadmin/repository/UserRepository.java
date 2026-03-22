package com.mycompany.studymatchadmin.repository;

import com.mycompany.studymatchadmin.database.DatabaseConnection;
import com.mycompany.studymatchadmin.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void suspendUser(int id) {

        try {

            Connection conn = DatabaseConnection.connect();


            String sql = "UPDATE users SET status='Suspended' WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(int id) {

        try {

            Connection conn = DatabaseConnection.connect();

            String sql = "DELETE FROM users WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<User> getUsers() {

        List<User> list = new ArrayList<>();

        try {

            Connection conn = DatabaseConnection.connect();

            String sql = "SELECT * FROM users WHERE role != 'admin'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                User u = new User();

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));
                u.setStatus(rs.getString("status"));

                list.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
