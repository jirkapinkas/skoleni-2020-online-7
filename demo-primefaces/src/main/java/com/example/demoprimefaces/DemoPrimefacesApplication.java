package com.example.demoprimefaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@SpringBootApplication
public class DemoPrimefacesApplication implements ServletContextAware {

    @Autowired
    private Environment environment;

    @Bean
    ServletRegistrationBean jsfServletRegistration () {
        //registration
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoPrimefacesApplication.class, args);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        if(environment.acceptsProfiles(Profiles.of("prod"))) {
            servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
            servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "-1");
        } else {
            servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
            servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "0");
        }
    }
}
