package com.vs4vijay.app.services;

import com.vs4vijay.app.errors.ResourceNotFoundException;
import com.vs4vijay.app.models.User;
import com.vs4vijay.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(String id, User user) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        user.setId(id);
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.deleteById(id);
    }
}
