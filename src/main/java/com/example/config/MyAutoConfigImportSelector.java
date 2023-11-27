package com.example.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 파일의 정보를 읽어들인다.
        // 파일에 정의해둘 configuration 목록을 불러오게된다.
        // Iterable<String> 을 implement 하고 있다.
        ImportCandidates candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
        // Stream 처리로 Array로 반환시킨다.
        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

    }
}
