package com.example.config.autoconfig;

import com.example.config.ConditionalMyOnClass;
import com.example.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    // application property 값을 호출함
    // 작동원리는 PropertySourcesPlaceholderConfigurer 클래스 참고
    @Value("${contextPath}")
    private String contextPath;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean   // 해당 반환타입의 Bean이 등록되어있는지 체크하고 없으면 해당 Bean을 사용
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        // RequestPath 의 Prefix 를 지정
        serverFactory.setContextPath(this.contextPath);
        return serverFactory;
    }

}
