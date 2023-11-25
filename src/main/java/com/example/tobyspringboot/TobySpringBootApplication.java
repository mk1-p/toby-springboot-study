package com.example.tobyspringboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class TobySpringBootApplication {

    public static void main(String[] args) {
        // Container Control Object
        // Convert GenericWebApplicationContext And Use DispatcherServlet
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        // Register Bean
        // Similar Singleton Pattern - Call Spring Container as Singleton Registry
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
        // Refresh And Create Bean Object
        applicationContext.refresh();


        // Create Servlet Server Factory(Tomcat)
        // If you want other WebServer, Modify TomcatServletWebServerFactory
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        // Get WebServer Object
        // -> Dispatcher Servlet Convert!
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*");
        });
        // Run WebServer
        webServer.start();
    }

}
