package com.example.tobyspringboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Annotation Retention 은 Default 값은 Class 까지이다.
// 컴파일후 메모리에 데이터가 제거되기 때문에 Runtime 에서도 살아있도록 한다
@Retention(RetentionPolicy.RUNTIME)
// Class, Interface, Enum
// 세가지 모두 적용되도록 하려면 Type
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
public @interface MySpringBootAnnotation  {
}
