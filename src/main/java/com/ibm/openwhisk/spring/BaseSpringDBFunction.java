package com.ibm.openwhisk.spring;

import com.google.gson.JsonObject;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("com.ibm.openwhisk.spring")})
public abstract class BaseSpringDBFunction {

    private JsonObject request;
    private JsonObject response;
    private AnnotationConfigApplicationContext context;

    public static JsonObject main(JsonObject args) {
        String[] stringifedJson = {args.toString()};

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BaseSpringDBFunction.class);

        GetAllBlogEntries function = context.getBean(GetAllBlogEntries.class);

        JsonObject jsonObject = function.execute(args);
        context.close();
        return jsonObject;
    }

    @Bean
    public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager geJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
        return transactionManager;
    }

    abstract JsonObject execute(JsonObject args);


    protected void setResponse(JsonObject response) {
        this.response = response;
    }

    protected JsonObject getResponse() {
        return response;
    }
}
