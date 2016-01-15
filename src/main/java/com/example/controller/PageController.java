package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.service.ContentService;
import javax.inject.Inject;

/**
 * Created by Janusz on 2016-01-08.
 */

@Controller
public class PageController {

    private final ContentService contentService;

    @Inject
    public PageController(final ContentService contentService){
        this.contentService = contentService;
    }

    @RequestMapping("/")
    public ModelAndView getListUsersView(){
        ModelMap model = new ModelMap();
        model.addAttribute("contents", contentService.getList());
        return new ModelAndView("index",model);
    }

}