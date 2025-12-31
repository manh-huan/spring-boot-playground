package com.vnr.springsecuritydemo.service;


import com.vnr.springsecuritydemo.db.UserStorage;
import com.vnr.springsecuritydemo.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserStorage userStorage;


    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }


    public boolean userExists(String username) {
        return userStorage.findByUserName(username) != null;
    }

    public void saveUser(String username, String password) {
        userStorage.addUser(username, password);
    }

    public User findByUserName(String username) {
        return userStorage.findByUserName(username);
    }

}
