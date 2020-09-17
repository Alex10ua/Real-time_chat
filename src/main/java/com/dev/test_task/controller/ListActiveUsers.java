package com.dev.test_task.controller;

import com.dev.test_task.storage.UsersStorage;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class ListActiveUsers {
    private static final Logger getLog= Logger.getLogger(ListActiveUsers.class);

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        getLog.debug("handling register user request: " + userName);//logger
        try {
            UsersStorage.getInstance().setUser(userName);
            getLog.debug("New user is registered: "+userName);
        } catch (Exception e) {
            getLog.error("Name is used: "+userName);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> showAllUsers()
    {
        return UsersStorage.getInstance().getUsers();
    }
}
