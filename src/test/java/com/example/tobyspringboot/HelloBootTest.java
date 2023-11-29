package com.example.tobyspringboot;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// Spring Container Test 사용 가능하도록
@ExtendWith(SpringExtension.class)
// Spring Bean 정보를 호출
@ContextConfiguration(classes = TobySpringBootApplication.class)
// Property 자동 설정의 경우 SpringBoot에서 제공해주는 기능이기에 필요한 Annotation
@TestPropertySource("classpath:application.properties")
@Transactional
public @interface HelloBootTest {
}
