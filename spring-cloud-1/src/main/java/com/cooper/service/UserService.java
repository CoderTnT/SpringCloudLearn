package com.cooper.service;

import com.cooper.dao.UserDao;
import com.cooper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/12
 * @describe
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User findUserById(long id) {
        return new User();
    }

    public User updateUser(User user) {
        return userDao.saveAndFlush(user);
    }
}
