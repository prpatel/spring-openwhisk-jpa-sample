package com.example;

import com.ibm.openwhisk.spring.BlogEntry;
import com.ibm.openwhisk.spring.BlogRepository;
import com.ibm.openwhisk.spring.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class LocalDbTest {

    @Resource
    private BlogRepository blogRepository;

    @Test
    public void saveAndFindBlogEntry() {
        BlogEntry entry = new BlogEntry("TEST TITLE", "TEST BLOG", "prpatel");
        blogRepository.save(entry);

        BlogEntry fetchedEntry = blogRepository.findById(1).orElse(null);
        assertEquals("prpatel", fetchedEntry.getAuthor());
    }
}
