package com.example.tobyspringboot;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {
        // 현재는 SpringBoot로 톰켓환경을 띄우지 않으므로 main method 실행 후 테스트 코드 실행
        // https://www.inflearn.com/questions/1012699/testresttemplate-resourceaccessexception-%EB%AC%B8%EC%A0%9C


        // RestTemplate의 경우 에러코드가 반환되면 Exception을 반환한다.
        // 테스트 환경에서는 TestRestTemplate 사용이 편할 수 있다.
        TestRestTemplate rest = new TestRestTemplate();
        String name = "Spring";

        // url, response body type, parameter binding
        ResponseEntity<String> res = rest
                .getForEntity("http://localhost:8080/hello?name={name}", String.class, name);

        // Status Code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE))
                // 처음부분과 일치하는지
                .startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        Assertions.assertThat(res.getBody()).isEqualTo("hello "+name);

    }

}
