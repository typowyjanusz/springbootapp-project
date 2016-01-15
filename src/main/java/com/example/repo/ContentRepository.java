package com.example.repo;

import com.example.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Janusz on 2016-01-08.
 */
public interface ContentRepository extends JpaRepository<Content, Integer> {


}
