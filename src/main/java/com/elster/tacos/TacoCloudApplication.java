package com.elster.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//I could add the separate configuration like this to automatically add a controller for endpoint to return view if no
//addition methods are needed. But because the main spring boot class is a configuration I can do this here.
/*@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

By extending an existing configuration class, you can avoid creating a new configuration class,
keeping your project artifact count down. But I tend to prefer creating a
new configuration class for each kind of configuration (web, data, security, and so
on), keeping the application bootstrap configuration clean and simple.
}*/
@SpringBootApplication()
public class TacoCloudApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
