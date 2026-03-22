package com.mycompany.studymatchadmin.service;

import com.mycompany.studymatchadmin.model.User;
import com.mycompany.studymatchadmin.repository.UserRepository;
import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    public void suspendUser(int id){
        userRepository.suspendUser(id);
    }

    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }

}