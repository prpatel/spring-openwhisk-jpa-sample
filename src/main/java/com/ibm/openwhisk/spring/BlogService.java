package com.ibm.openwhisk.spring;

import java.util.List;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class BlogService  {

    @Autowired
    private BlogRepository repository;

    public List<BlogEntry> findAll() {
        List<BlogEntry> blogEntries = (List<BlogEntry>) repository.findAll();
        return blogEntries;
    }
}
