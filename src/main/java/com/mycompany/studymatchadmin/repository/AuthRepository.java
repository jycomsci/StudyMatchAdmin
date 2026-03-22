package com.mycompany.studymatchadmin.repository;

import com.mycompany.studymatchadmin.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthRepository {

    public boolean login(String username, String password) {

        try {

            Connection conn = DatabaseConnection.connect();

            String sql = "SELECT * FROM users WHERE username=? AND password=? AND role='admin'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}