# Toby Spring Boot in Inflearn
'토비의 스프링 부트 - 이해와 원리' 강의 공부 코드 모음

## Env
* MacOS(Sonoma, M1 MacSilicon)
* Java17
* Spring Boot v3.2.0

## Branch
강의 별 브랜치 Prefix 와 공부하면서 작성된 코드 및 주석입니다. <br>
일부 강의 목록은 통합하여 코드가 작성되었기 때문에 대략적인 강의 명과 브랜치 매칭을 해두었습니다.
* 독립 실행형 서블릿 애플리케이션 (sa-servlet)
  * [서블릿](https://github.com/mk1-p/toby-springboot-study/tree/sa-servlet/servlet)
  * [프론트 컨트롤러](https://github.com/mk1-p/toby-springboot-study/tree/sa-servlet/front-controller)
* 독립 실행형 스프링 애플리케이션 (sa-spring)
  * [스프링 컨테이너 사용](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/spring-container)
  * [자바코드 구성정보 사용](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/java-fatory-pattern)
  * [의존성 주입](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/di)
  * [@Component](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/component)
  * [Bean의 생명주기 메소드](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/bean-lifecycle) 
  * [SpringBootApplication](https://github.com/mk1-p/toby-springboot-study/tree/sa-spring/spring-boot-application)
* DI와 테스트, 디자인 패턴 (di-pattern)
  * [테스트코드를 위한 테스트](https://github.com/mk1-p/toby-springboot-study/tree/di-pattern/test-code)
  * [DI와 단위 테스트](https://github.com/mk1-p/toby-springboot-study/tree/di-pattern/unit-test)
  * [DI를 이용한 Decorator, Proxy 패턴](https://github.com/mk1-p/toby-springboot-study/tree/di-pattern/decorator)
* 자동 구성 기반 애플리케이션 (auto-config)
  * [인프라 빈 구성 정보의 분리](https://github.com/mk1-p/toby-springboot-study/tree/auto-config/infra-bean)
  * [동적인 자동구성 정보 등록](https://github.com/mk1-p/toby-springboot-study/tree/auto-config/dynamic-config)
* 조건부 자동 구성 (conditional-config)
  * [스타터와 Jetty 서버 구성 추가](https://github.com/mk1-p/toby-springboot-study/tree/conditional-config/jetty)
  * [@Conditional과 Condition](https://github.com/mk1-p/toby-springboot-study/tree/conditional-config/conditional)
  * [커스톰 @Conditional](https://github.com/mk1-p/toby-springboot-study/tree/conditional-config/custom-conditional)
* 외부 설정을 이용한 자동 구성 (external-config)
  * [자동 구성에 Environment 프로퍼티 적용](https://github.com/mk1-p/toby-springboot-study/tree/external-config/env-property)
  * [@Value와 PropertySourcesPlaceholderConfigurer](https://github.com/mk1-p/toby-springboot-study/tree/external-config/value-placeholder)
  * [프로퍼티 클래스의 분리](https://github.com/mk1-p/toby-springboot-study/tree/external-config/property-class)
  * [프로퍼티 빈의 후처리기 도입](https://github.com/mk1-p/toby-springboot-study/tree/external-config/bean-postprocessor)
* Spring JDBC 자동 구성 개발 (jdbc)
  * [DataSource 자동 구성 클래스](https://github.com/mk1-p/toby-springboot-study/tree/jdbc/datasource-config)
  * [JdbcTemplate과 트랜잭션 매니저 구성](https://github.com/mk1-p/toby-springboot-study/tree/jdbc/template-transaction)
  * [Hello 리포지토리](https://github.com/mk1-p/toby-springboot-study/tree/jdbc/hello-repository)
  * [리포지토리를 사용하는 HelloService](https://github.com/mk1-p/toby-springboot-study/tree/jdbc/hello-service)
* 스프링 부트 자세히 살펴보기 (springboot)
  * [마무리](https://github.com/mk1-p/toby-springboot-study/tree/springboot/auto-config)