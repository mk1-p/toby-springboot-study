package com.example.tobyspringboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

    public static void run(Class<?> applicatoinClass, String... args) {
        // Container Control Object
        // Convert GenericWebApplicationContext And Use DispatcherServlet
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                // 등록된 Bean을 가져온다.
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                // Application Context를 입력하지 않더라도
                // Spring Context가 자동으로 주입해준다.
                // dispatcherServlet.setApplicationContext(this);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");
                });
                // Run WebServer
                webServer.start();

            }
        };
        applicationContext.register(applicatoinClass);
        // Refresh And Create Bean Object
        applicationContext.refresh();



    }


}
