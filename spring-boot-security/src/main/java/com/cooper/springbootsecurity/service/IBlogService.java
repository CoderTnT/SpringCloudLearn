package com.cooper.springbootsecurity.service;

import com.cooper.springbootsecurity.entity.Blog;

import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/19
 * @describe
 */
public interface IBlogService {

    List<Blog> getBlogs();

    void delelteBlog(long id);

}
