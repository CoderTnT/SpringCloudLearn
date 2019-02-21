package com.cooper.springbootsecurity.controller;

import com.cooper.springbootsecurity.entity.Blog;
import com.cooper.springbootsecurity.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/19
 * @describe
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView list(Model model) {
        List<Blog> list = blogService.getBlogs();
        model.addAttribute("blogsList", list);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delelte(@PathVariable("id") Long id, Model model) {
        blogService.delelteBlog(id);
        model.addAttribute("blogsList", blogService.getBlogs());
        return new ModelAndView("blogs/list", "blogModel", model);
    }



}
