package org.launchcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.launchcode.models.Post;
import org.launchcode.models.data.PostDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostDao postDao;

    @RequestMapping(value = "")
    public String index (Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Post");
        model.addAttribute("preference", "Add preference");
        model.addAttribute("game", "Add game");
        model.addAttribute(new Post());
        return "post/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid Post newPost, HttpSession session, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Post", "Add Post");
            model.addAttribute("preference", "Add preference");
            model.addAttribute("game", "Add game");
            return "post/add";
        }



        postDao.save(newPost);
        return "redirect:/post";

    }

    @RequestMapping(value = "edit/{postId}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable int postId) {

        model.addAttribute("title", "edit description");
        model.addAttribute("post", postDao.findOne(postId));

        return "post/edit";

    }

    @RequestMapping(value = "edit/{postId}", method = RequestMethod.POST)
    public String processEditForm(@PathVariable int postId, @ModelAttribute Post newPost) {
        Post editedPost = postDao.findOne(postId);
        editedPost.setDescription(newPost.getDescription());
        editedPost.setPreference(newPost.getPreference());
        editedPost.setGame(newPost.getGame());
        postDao.save(editedPost);

        return "redirect:/post";


    }


}
