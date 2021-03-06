package com.jackson.controller;

import com.jackson.model.Author;
import com.jackson.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    @Qualifier(value = "authorService")
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public String listAuthors(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("listAuthors", this.authorService.listAuthors());

        return "authors";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("author") Author author){
        if(author.getId() == 0){
            this.authorService.addAuthor(author);
        }else {
            this.authorService.updateAuthor(author);
        }

        return "redirect:/authors";
    }


    @RequestMapping("/removeA/{id}")
    public String removeAuthor(@PathVariable("id") int id){
        this.authorService.removeAuthor(id);

        return "redirect:/authors";
    }

    @RequestMapping("editA/{id}")
    public String editAuthor(@PathVariable("id") int id, Model model){
        model.addAttribute("author", this.authorService.getAuthorById(id));
        model.addAttribute("listAuthors", this.authorService.listAuthors());

        return "authors";
    }

    @RequestMapping("authordata/{id}")
    public String authorData(@PathVariable("id") int id, Model model){
        model.addAttribute("author", this.authorService.getAuthorById(id));

        return "authordata";
    }


    @RequestMapping(value = "/task1", method = RequestMethod.GET)
    public String task1(Model model){
        model.addAttribute("task1", this.authorService.task1());

        return "task1";
    }

    @RequestMapping(value = "/task3", method = RequestMethod.GET)
    public String task2(Model model){
        model.addAttribute("task3", this.authorService.task3());

        return "task3";
    }
}
