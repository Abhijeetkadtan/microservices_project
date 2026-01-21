package com.example.user_service.controller;

import com.example.user_service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {


        log.trace("Entering getUser() with id={}", id);

        if (id < 0) {
            log.warn("Invalid user id received: {}", id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "User id must be greater than zero"
            );
        }

        try {

            if (id > 100) {
                log.warn("User not found with id={}", id);
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                );
            }

            UserDTO user = new UserDTO(
                    id,
                    "John Doe",
                    "john.doe@test.com"
            );


            log.info("User fetched successfully with id={}", id);
            return user;


        } catch (ResponseStatusException ex) {

            throw ex;
        } catch (Exception ex) {

            log.error("Unexpected error while fetching user with id={}", id, ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Internal server error"
            );
        }
    }
}
