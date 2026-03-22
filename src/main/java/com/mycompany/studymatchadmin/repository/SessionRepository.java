/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studymatchadmin.repository;

import com.mycompany.studymatchadmin.database.DatabaseConnection;
import com.mycompany.studymatchadmin.model.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class SessionRepository {
    
    public List<Session> getRecentSessions(){

    List<Session> list = new ArrayList<>();

    try{

        Connection conn = DatabaseConnection.connect();

        String sql = "SELECT * FROM sessions ORDER BY session_date DESC LIMIT 5";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){

            Session s = new Session();

            s.setTutor(rs.getString("tutor_name"));
            s.setStudent(rs.getString("student_name"));
            s.setAmount(rs.getDouble("amount"));
            s.setStatus(rs.getString("status"));

            list.add(s);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return list;
}
    
}
