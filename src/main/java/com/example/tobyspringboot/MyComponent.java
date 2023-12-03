package com.example.tobyspringboot;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Meta Annotation
 * 어노테이션 위에 어노테이션을 추가하여 여러 기능을 붙일 수 있음
 */

// 유지 기간
@Retention(RetentionPolicy.RUNTIME)
// 지정 타겟 위치
@Target(ElementType.TYPE) //클래스나 인터페이스
@Component
public @interface MyComponent {
}
