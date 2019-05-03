package com.ibm.openwhisk.spring;

import com.google.gson.JsonObject;

public class CommandLineRunner {

    public static void main(String[] args){

        System.out.println("Running Application:");
        System.out.println(GetAllBlogEntries.main(new JsonObject()));
        System.out.println("Finished Application execution");
    }
}
