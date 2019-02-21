package com.cooper.springbootsecurity.service;

import com.cooper.springbootsecurity.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/19
 * @describe 模拟删除
 */
@Service
public class BlogService implements IBlogService{

    private List<Blog> list = new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1L, "this is dasdads", "good!"));
        list.add(new Blog(2L, "yyyyyyyy", "bad!"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void delelteBlog(long id) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {

            Blog blog = (Blog) iterator.next();

            if (blog.getId() == id) {
                iterator.remove();
            }
        }
    }
}
