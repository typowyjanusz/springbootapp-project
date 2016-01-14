package com.example.controller;

/**
 * Created by Janusz on 2016-01-14.
 */

import com.example.model.Content;
import com.example.model.UserCreateForm;
import com.example.service.UserService;
import com.example.service.exception.UserAlreadyExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Janusz on 2016-01-08.
 */
@Controller
public class UserCreateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateController.class);
    private final UserService userService;
    //private final UserCreateFormPasswordValidator passwordValidator;

    @Inject
    public UserCreateController(UserService userService) {
        this.userService = userService;
        //this.passwordValidator = passwordValidator;
    }

    //@InitBinder("form")
   /* public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordValidator);
    }
*/

    @RequestMapping(value = "/user_create", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public ModelAndView getCreateUserView() {
        LOGGER.debug("Received request for user create view");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/user_create", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String createUser(@ModelAttribute("form") @Valid UserCreateForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}, with result={}", form, result);

        if (result.hasErrors()) {
            return "user_create";
        }
        try {
            userService.save(new Content(form.getId(), form.getContents1(), form.getTitle()));
        } catch (UserAlreadyExistsException e) {
            LOGGER.debug("Tried to create user with existing id", e);
            result.reject("user.error.exists");
            return "user_create";
        }

        return "redirect:/";
    }

}
