package com.example.service;

import com.example.model.Content;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repo.ContentRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Janusz on 2016-01-08.
 */
@Service

public class ContentServiceImpl implements ContentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);
    private final ContentRepository repository;

    @Inject
    public ContentServiceImpl(final ContentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Content save(@NotNull @Valid final Content content) {
        LOGGER.debug("Creating {}", content);

        return repository.save(content);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Content> getList() {
        LOGGER.debug("pobieranie listy content");
        return repository.findAll();
    }

}