package com.example.controller;

/**
 * Created by Janusz on 2016-01-14.
 */

import com.example.model.Content;
import com.example.model.ContentCreateForm;
import com.example.service.ContentService;
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
public class ContentCreateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentCreateController.class);
    private final ContentService contentService;

    @Inject
    public ContentCreateController(ContentService contentService) {
        this.contentService = contentService;
    }
    @RequestMapping(value = "/content_create", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public ModelAndView getCreateUserView() {
        LOGGER.debug("Received request for user create view");
        return new ModelAndView("content_create", "form", new ContentCreateForm());
    }

    @RequestMapping(value = "/content_create", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String createUser(@ModelAttribute("formContent") @Valid ContentCreateForm formContent, BindingResult result) {
        if (result.hasErrors()) {
            return "content_create";
        }
        contentService.save(new Content(formContent.getId(), formContent.getContents1(), formContent.getTitle()));
        return "redirect:/content_list";
    }

}
