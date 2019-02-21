package com.cooper.springbootsecurity.dao;

import com.cooper.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/19
 * @describe
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
