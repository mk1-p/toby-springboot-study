package com.example.tobyspringboot;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.SQLException;

// Spring Container Test 사용 가능하도록
@ExtendWith(SpringExtension.class)
// Spring Bean 정보를 호출
@ContextConfiguration(classes = TobySpringBootApplication.class)
// Property 자동 설정의 경우 SpringBoot에서 제공해주는 기능이기에 필요한 Annotation
@TestPropertySource("classpath:application.properties")
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }

}
