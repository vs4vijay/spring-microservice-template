package com.vs4vijay.app.services;

import com.vs4vijay.app.models.User;
import com.vs4vijay.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(UUID id, User user) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        user.setId(id);
        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        userRepository.deleteById(id);
    }
}
