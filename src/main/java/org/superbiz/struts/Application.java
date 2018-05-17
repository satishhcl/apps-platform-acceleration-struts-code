package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public FilterRegistrationBean strutsCleanup() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ActionContextCleanUp());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new PageFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new FilterDispatcher());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("actionPackages", "com.lq");
        return registration;
    }


}
