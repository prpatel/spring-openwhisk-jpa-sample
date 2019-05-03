package com.ibm.openwhisk.spring;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.function.Function;

public abstract class BaseSpringDBFunction implements ApplicationRunner {

    private JsonObject request;
    private JsonObject response;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String requestJson = args.getSourceArgs()[0];
        JsonObject parsedJson = new JsonParser().parse(requestJson).getAsJsonObject();
        setResponse(execute(parsedJson));
    }

    abstract JsonObject execute(JsonObject args);


    protected void setResponse(JsonObject response) {
        this.response = response;
    }

    protected JsonObject getResponse() {
        return response;
    }
}
