package com.example.tobyspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    /**
     * 고립 테스트 진행
     * 성공 케이스
     * 실패 케이스
     */
    @Test
    void helloController() {
        String namePara = "TEST";
        // Controller의 의존성을 제거하고 단일로 정상작동하는지 체크한다.
        // 고립성 테스트
        HelloController helloController = new HelloController(name -> name);
        String ret = helloController.hello(namePara);

        Assertions.assertThat(ret).isEqualTo(namePara);
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> name);

        // 실패 테스트의 경우 테스트
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
