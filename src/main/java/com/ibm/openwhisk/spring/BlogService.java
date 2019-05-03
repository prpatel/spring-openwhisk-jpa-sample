package com.ibm.openwhisk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService  {

    @Autowired
    private BlogRepository repository;

    public List<BlogEntry> findAll() {
        List<BlogEntry> blogEntries = (List<BlogEntry>) repository.findAll();
        return blogEntries;
    }
}
