package com.example.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// ServerProperties 클래스의 값을 자동으로 바인당 하기 위한 DeferredImportSelector
// BeanPostProcessor 처리
// DeferredImportSelector 로 지연 로딩
// Data Binding
//TODO 처리 흐름에 대해서 한번 더 확인하기!
@Import(MyConfigurationPropertiesImportSelector.class)
public @interface EnableMyConfigurationProperties {
    Class<?> value();
}
