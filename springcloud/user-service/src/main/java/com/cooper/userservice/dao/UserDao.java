package com.cooper.userservice.dao;

import com.cooper.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/22
 * @describe
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
