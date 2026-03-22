package com.mycompany.studymatchadmin.service;

import com.mycompany.studymatchadmin.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnalyticsService {

    public double getTotalRevenue() {

        try {

            Connection conn = DatabaseConnection.connect();

            String sql = "SELECT SUM(amount) FROM sessions WHERE status='Completed'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public double getTotalCommission() {

        try {

            Connection conn = DatabaseConnection.connect();

            String sql = "SELECT SUM(commission) FROM payments";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getTodaySessions() {

        try {

            Connection conn = DatabaseConnection.connect();

            String sql =
                    "SELECT COUNT(*) FROM sessions WHERE DATE(session_date)=CURDATE()";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}