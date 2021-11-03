package com.cherkasov.mvc_springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cherkasov.mvc_springboot.models.Role;
import com.cherkasov.mvc_springboot.service.RoleService;
import com.cherkasov.mvc_springboot.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;
    private RoleService roleService;
    private Role role;

    @Autowired
    public UsersController(UserService userService, RoleService roleService, Role role) {
        this.userService = userService;
        this.roleService = roleService;
        this.role = role;
    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getOne(id));
        return "/users/getOne";
    }

}



