package com.example.tobyspringboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

import java.io.IOException;

public class TobySpringBootApplication {

    public static void main(String[] args) {
        // Container Control Object
        GenericApplicationContext applicationContext = new GenericApplicationContext();
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
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                    // 인증, 보안, 다국어, 공통 기능 등!
                    // url
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name() )) {

                        // Bind Parameter
                        String name = req.getParameter("name");
                        // Get Hello Controller Bean
                        HelloController helloController = applicationContext.getBean(HelloController.class);
                        String hello = helloController.hello(name);

                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().print(hello);
                    }
                    else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }


                }
            }).addMapping("/*");
        });
        // Run WebServer
        webServer.start();
    }

}
