package com.dev.test_task.storage;

import com.dev.test_task.controller.ChatController;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class UsersStorage {
    private static UsersStorage instance;
    private Set<String> users;// for saving all Users( one session)
    private static final Logger getLog= Logger.getLogger(UsersStorage.class);

    private UsersStorage(){
        users = new HashSet<>();
    }

    public static synchronized UsersStorage getInstance() {
        if (instance == null) {
            instance = new UsersStorage();
            getLog.debug("Created new instance");
        }
        return instance;
    }

    public static void setInstance(UsersStorage instance) {
        UsersStorage.instance = instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String userName) throws Exception {
        if (users.contains(userName)) {
            getLog.debug("HashSet contains "+userName+" yet.");
            throw new Exception("User aready exists with userName: " + userName);//logger
        }
        users.add(userName);
    }
}
