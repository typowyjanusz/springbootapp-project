package com.example.controller;

/**
 * Created by Janusz on 2016-01-14.
 */
import com.example.model.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.example.service.ContentService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ContentRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentRestController.class);
    private final ContentService contentService;

    @Inject
    public ContentRestController(final ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/content", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public Content createUser(@RequestBody @Valid final Content content) {
        LOGGER.debug("Received request to create the {}", content);
        return contentService.save(content);
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public List<Content> listUsers() {
        LOGGER.debug("Received request to list all of content");
        return contentService.getList();
    }

}