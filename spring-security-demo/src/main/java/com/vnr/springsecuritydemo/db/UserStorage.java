package com.vnr.springsecuritydemo.db;


import com.vnr.springsecuritydemo.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserStorage {

    public List<User> userStorage = new ArrayList<>();

    private final PasswordEncoder passwordEncoder;

    public UserStorage(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userStorage.add(new User("admin", passwordEncoder.encode("1234")));
    }


   public void addUser(String userName, String password) {
       String encodedPassword = passwordEncoder.encode(password);
       User newUser = new User(userName, encodedPassword);
       userStorage.add(newUser);
   }

    public List<User> getUserStorage() {
         return userStorage;
    }

    public User findByUserName(String userName){
        return userStorage.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }

}
