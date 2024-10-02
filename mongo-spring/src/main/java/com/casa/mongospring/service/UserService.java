package com.casa.mongospring.service;

import com.casa.mongospring.dto.UserDTO;
import com.casa.mongospring.model.User;
import com.casa.mongospring.repository.UserRepository;
import com.casa.mongospring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> convertToDTO(List<User> users) {
        List<UserDTO> userDTOS = new java.util.ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO(user));
        }
        return userDTOS;
    }

    public UserDTO findUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found", id)
        );
        return new UserDTO(user);
    }

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user, String id) {
        User newUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ObjectNotFoundException("User not found", id)
        );
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }
}
