package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.service.UserService;
import javax.inject.Inject;

/**
 * Created by Janusz on 2016-01-08.
 */

@Controller
public class UserListController {

    private final UserService userService;

    @Inject
    public UserListController(final UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView getListUsersView(){
        ModelMap model = new ModelMap();
        model.addAttribute("contents",userService.getList());
        return new ModelAndView("index",model);
    }

}