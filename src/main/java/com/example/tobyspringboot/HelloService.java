package com.example.tobyspringboot;


import org.springframework.stereotype.Service;

@Service
public interface  HelloService {
    String sayHello(String name);

    // 구현되어있지 않은 경우 Default 메소드를 통해 값 반환
    // 아래 테스트 코드에서 람다식으로 구현된 부분이 있어 특별히 구현할 필요가 없다면 임시조치로 괜찮은듯.
    // 또는 인터페이스가 만들어졌으나 구현체 비지니스 로직이 아직 결정되지 않았다면 괜찮은 방법인듯
    default Integer countOf(String name) {
        return 0;
    };
}
