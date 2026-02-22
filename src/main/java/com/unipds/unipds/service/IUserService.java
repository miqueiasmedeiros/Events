package com.unipds.unipds.service;

import com.unipds.unipds.model.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IUserService {
    public User addUser(User user);
    public User getUserById(Integer id);
    public User getUserEmail(String email);
    public List<User> getAllUsers();
    public void deleteUserById(Integer id);
    public User updateUserById(User user, Integer id);
}
