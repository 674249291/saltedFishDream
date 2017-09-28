package com.saltedfish.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


/**
 * Created by xiongjun on 2017/8/19.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.saltedfish")
public class Application extends SpringBootServletInitializer {

   /* @Bean
    ServletContextTemplateResolver templateResolver(){
        ServletContextTemplateResolver resolver=new ServletContextTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setPrefix("/resources/templates/");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

    @Bean
    SpringTemplateEngine engine(){
        SpringTemplateEngine engine=new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine());
        return viewResolver;
    }*/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
}
