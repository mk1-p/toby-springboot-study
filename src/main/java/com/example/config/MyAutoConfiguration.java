package com.example.config;


import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false)    // ConfigurationTest 파일 참고! 등록될 Bean 객체에 프록시를 만들지 않는다는 옵션
public @interface MyAutoConfiguration {
}
