package org.adaschool.datapostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.adaschool.datapostgres.data.entity.User;
import org.adaschool.datapostgres.data.dto.UserDto;
import org.adaschool.datapostgres.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // Otros métodos para actualizar y eliminar
}
