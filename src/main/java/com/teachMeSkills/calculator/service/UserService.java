package com.teachMeSkills.calculator.service;

import com.teachMeSkills.calculator.dao.UserDAO;
import com.teachMeSkills.calculator.entity.Operation;
import com.teachMeSkills.calculator.entity.User;
import com.teachMeSkills.calculator.storage.UserStorage;

import java.util.ArrayList;
import java.util.List;


public class UserService {

    private UserDAO userDao = new UserDAO();

    public boolean saveUser(User user) {
        userDao.save(user);
        return true;
    }

    public User findByLogin (String login){
        return userDao.findByLogin(login);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

}
