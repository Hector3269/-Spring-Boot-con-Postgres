package org.adaschool.datapostgres.service;

import org.adaschool.datapostgres.data.entity.User;
import org.adaschool.datapostgres.data.dto.UserDto;
import org.adaschool.datapostgres.data.repository.UserRepository;
import org.adaschool.datapostgres.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(UserNotFoundException::new);
    }

    // Otros métodos para actualizar y eliminar
}
