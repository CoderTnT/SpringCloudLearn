package com.cooper.dao;

import com.cooper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/12
 * @describe
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByUsername(String username);
}
