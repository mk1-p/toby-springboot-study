package com.example.config.autoconfig;

import com.example.config.MyAutoConfiguration;
import com.example.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                // Java의 Reflection을 이용할수도 있지만
                // Spring 에서 제공하는 AnnotationUtils 를 이용하여 찾을 수 있다.
                MyConfigurationProperties annotation = AnnotationUtils
                        .findAnnotation(bean.getClass(), MyConfigurationProperties.class);

                if (annotation == null) return bean;

                // annotation 에 정의된 prefix 값을 읽어들여,
                // binder 의 name 값에 넣어 prefix.~ 식으로 찾을 수 있게 한다.
                Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");

                // 해당 Annotation 을 사용하는 bean 이 존재하는 경우
                // environment 값을 바인딩, 만약 값이 없다면 새로운 인스턴스를 생성해줌 bindOrCreate()
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }

}
