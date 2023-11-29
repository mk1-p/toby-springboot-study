package com.example.config.autoconfig;

import com.example.config.ConditionalMyOnClass;
import com.example.config.EnableMyConfigurationProperties;
import com.example.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean   // 해당 반환타입의 Bean이 등록되어있는지 체크하고 없으면 해당 Bean을 사용
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        // RequestPath 의 Prefix 를 지정
        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());
        return serverFactory;
    }


}
