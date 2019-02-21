package com.cooper.springbootsecurity.service;

import com.cooper.springbootsecurity.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/19
 * @describe
 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByUsername(s);
    }
}
