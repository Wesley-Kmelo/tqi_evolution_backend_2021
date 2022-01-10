package com.tqi.finalProject.config;

//classe responsável por registrar os endpoints disponiveis que vão ser controlados pelo Spring Security


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigMvc implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");

        registry.addViewController("/loginadm").setViewName("loginadm");

        registry.addViewController("/cliente").setViewName("cliente");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/cadastro").setViewName("cadastro");
        registry.addViewController("/login").setViewName("login");

    }
}
