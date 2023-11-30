package com.example.tobyspringboot;

import com.example.config.MySpringBootApplication;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@MySpringBootApplication
public class TobySpringBootApplication {

    private final JdbcTemplate jdbcTemplate;

    public TobySpringBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }


    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            // 만약 Environment Variable 설정을 넣는다면
            // 우선순위상 E.V 가 application properties 보다 높기 때문에 E.V 값이 설정된다.
            // MY_NAME Key 값으로 넣어도 my.name의 여러 경우의 수를 인식하기 때문에
            // 몇가지 명명법에 맞게 넣는다면 적용된다.
            // System Properties 를 적용하는 경우 우선 순위 상 S.P가 적용된다.
            // ex. -Dmy.name=SystemProperty
            String name = env.getProperty("my.name");
            System.out.println("my.name = "+name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TobySpringBootApplication.class, args);
    }




}
