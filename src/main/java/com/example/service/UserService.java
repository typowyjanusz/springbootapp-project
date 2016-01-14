package com.example.service;

import com.example.model.Content;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Janusz on 2016-01-08.
 */
public interface UserService {

    Content save(Content content);


    List<Content> getList();
    //List<Content> findAllByOrderByIdDesc();
}
