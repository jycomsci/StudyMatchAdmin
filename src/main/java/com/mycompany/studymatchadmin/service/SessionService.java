/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studymatchadmin.service;

/**
 *
 * @author HP
 */
import com.mycompany.studymatchadmin.repository.SessionRepository;
import com.mycompany.studymatchadmin.model.Session;

import java.util.List;

public class SessionService {

    private SessionRepository repository = new SessionRepository();

    public List<Session> getRecentSessions(){
        return repository.getRecentSessions();
    }
}
