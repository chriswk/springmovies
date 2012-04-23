package com.chriswk.movies.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class MoviesWebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("com.chriswk.movies.config");

        // Manages the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("appServlet", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'appServlet' could not be mapped to '/' due " +
                    "to an existing mapping. This is a known issue under Tomcat versions " +
                    "<= 7.0.14; see <a href=\"https://issues.apache.org/bugzilla/show_bug.cgi?id=51278\">https://issues.apache.org/bugzilla/show_bug.cgi?id=51278</a>");
        }
    }
}
