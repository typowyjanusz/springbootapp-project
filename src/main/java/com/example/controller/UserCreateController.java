package com.example.controller;

import com.example.model.User;
import com.example.model.UserCreate;
import com.example.model.UserRole;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.service.UserRoleService;
import com.example.service.UserService;
import com.example.service.exception.UserAlreadyExistsException;
import com.example.validator.UserCreateFormPasswordValidator;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Bany on 2016-01-12.
 */
@Controller
public class UserCreateController {

    private final UserService userService;
    private final UserCreateFormPasswordValidator passwordValidator;
    private final UserRoleService roleService;

    @Inject
    public UserCreateController(UserService userService, UserCreateFormPasswordValidator passwordValidator, UserRoleService roleService) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
        this.roleService = roleService;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordValidator);
    }

    @RequestMapping(value = "/user_create", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        return new ModelAndView("user_create", "form", new UserCreate());
    }

    @RequestMapping(value = "/user_create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("form") @Valid UserCreate form, BindingResult result) {
        if (result.hasErrors()) {
            return "user_create";
        }
        try {
            userService.save(new User(form.getUsername1(), form.getPassword2(), 1));
            roleService.save(new UserRole(form.getUsername1(),"USER"));
        }
        catch (UserAlreadyExistsException e) {
            result.reject("user.error.exists");
            return "user_create";
        }
        return "redirect:/";
    }
}