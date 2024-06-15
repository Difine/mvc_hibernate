/*
 * @author Dmitry Komarov
 * Created 15.06.2024
 */


package ru.dmitrykomarov.mvc_hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dmitrykomarov.mvc_hibernate.model.User;
import ru.dmitrykomarov.mvc_hibernate.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "add-user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {

        userService.deleteUser(id);
        System.out.println("hello");
        return "redirect:/users";
    }



}
