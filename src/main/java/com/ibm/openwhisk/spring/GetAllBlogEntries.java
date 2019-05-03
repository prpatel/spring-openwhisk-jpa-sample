package com.ibm.openwhisk.spring;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

public class GetAllBlogEntries extends BaseSpringDBFunction{

    @Autowired
    BlogRepository repository;

    @Override
    JsonObject execute(JsonObject args) {
//        BlogEntry entry = new BlogEntry("TEST TITLE", "TEST BODY", "prpatel");
//        repository.save(entry);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(repository.findAll());
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("result", jsonElement);
        return jsonObject;

    }
}
