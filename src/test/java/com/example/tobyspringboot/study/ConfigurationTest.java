package com.example.tobyspringboot.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        // Java 관점에서는 bean1 과 bean2 안의 common 객체가 달라야한다.
        // Configuration 에서는 이 두 클래스의 Common 객체가 동일하다고 나오는데
        // 이는 proxyBeanMethods 엘리먼트가 default 값으로 true 이기 때문이다.
        // 실제로는 Proxy 객체가 Bean 으로 등록되어있기 때문이다.
        // 만약 proxyBeanMethods = false 이면 프록시를 생성하지 않기 때문에 해당 테스트는 실패한다.
        // 프록시를 굳이 만들지 않아도 된다면 false 로 설정한다.
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod() {
        // Proxy 예시로 만들어진 자바 코드 구현 방법
        MyConfigProxy configProxy = new MyConfigProxy();

        Bean1 bean1 = configProxy.bean1();
        Bean2 bean2 = configProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

    }

    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            if (this.common == null) this.common = super.common();
            return this.common;
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }

    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {
    }
}
