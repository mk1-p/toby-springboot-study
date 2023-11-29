package com.example.config.autoconfig;

import com.example.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {



    @Bean
    public ServerProperties serverProperties(Environment env) {
//        ServerProperties properties = new ServerProperties();
//        properties.setContextPath(env.getProperty("contextPath"));
//        properties.setPort(Integer.parseInt(env.getProperty("port")));
//        return properties;

        // Spring Boot 제공
        // Binder 로 파라메터를 받고 bind 대상의 Getter Setter 를 읽어들여 일치하는 프로퍼티를 매핑해준다.
        return Binder.get(env).bind("", ServerProperties.class).get();
    }

}
