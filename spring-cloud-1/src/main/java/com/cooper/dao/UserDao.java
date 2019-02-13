package com.cooper.dao;

import com.cooper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/12
 * @describe
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByUsername(String username);

    List<User> findAll();

    User save(User user);



    User saveAndFlush(User user);





}
