package com.example.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;

public class ServerProperties {
    // Spring Boot 제공 클래스중 동일 이름인 ServerProperties 클래스가 있다.
    // 내부를 보면 @ConfigurationProperties 어노테이션에 Prefix 값으로 'server' 값이 붙어있는데
    // server.port 처럼 application properties 에 기본적으로 세팅하던 것들이 여기서 정의되어 나오는 것들이다.

    private String contextPath;
    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }



}
