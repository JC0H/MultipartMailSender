package ua.com.jcoh.service;

import ua.com.jcoh.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByName(String username);
    List<User> findAll();
    User findOne(int id);
}
