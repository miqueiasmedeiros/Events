package com.unipds.unipds.service;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.User;
import com.unipds.unipds.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return repo.findById(id).orElseThrow(()-> new NotFoundException("User "+ id + " not found"));
    }

    @Override
    public User getUserEmail(String email) {
        return repo.findByEmail(email).orElseThrow(()-> new NotFoundException("Email "+email+" not registered"));
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public void deleteUserById(Integer id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("Id "+ id + " not found");
        }
        repo.deleteById(id);
    }

    @Override
    public User updateUserById(User user, Integer id) {
        User updateUser = repo.findById(id).orElseThrow(()-> new NotFoundException("Id "+id+" not found for updated"));
        updateUser.setNome(user.getNome());
        updateUser.setEmail(user.getEmail());
      return repo.save(updateUser);
    }

}
