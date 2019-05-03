package com.ibm.openwhisk.spring;

import com.google.gson.JsonObject;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class LombokTest {

    public static JsonObject main(JsonObject args) {
        SpringApplicationBuilder springAppBuilder = new SpringApplicationBuilder()
                .sources(GetAllBlogEntries.class, JpaConfig.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE);

        SpringApplication springApp = springAppBuilder.build();
        String[] stringifedJson = {args.toString()};
        ConfigurableApplicationContext cac = springApp.run(stringifedJson);
        BaseSpringDBFunction f = cac.getBean(GetAllBlogEntries.class);
        System.out.println("Response: " + f.getResponse());
        return f.getResponse();
    }
}
