package com.example.config.autoconfig;

import com.example.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
// Condition 상태값을 반환함으로써 Spring에게 어떤 WebServer 를 사용할것인지 알려준다.
@Conditional(JettyWebServerConfig.JettyCondition.class)
public class JettyWebServerConfig {

    // 보통은 Bean의 이름은 메소드 이름을 따라간다.
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

    static class JettyCondition implements Condition {
        // true 값을 반환함으로써 Jetty를 사용하겠다 정의
        // 반대로 Tomcat은 false로 설정
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return ClassUtils.isPresent("org.eclipse.jetty.server.Server",
                    context.getClassLoader());
        }
    }
}
