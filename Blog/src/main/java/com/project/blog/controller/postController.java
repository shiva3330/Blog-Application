package com.project.blog.controller;
import com.project.blog.model.Post;
import com.project.blog.repository.postRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.PanelUI;

@Controller
public class postController {

    @Autowired
    postRepo repo;

    @GetMapping("/")
    public String homePage(Model model){
       model.addAttribute("listPosts",repo.findAll());
       return "index";
    }
    @GetMapping("/new")
    public String newPost(Model model){
        model.addAttribute("post",new Post());
        return "new_post";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id, Model model){
        model.addAttribute("post",repo.findById(id));
        return "edit_post";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/";
    }
}
