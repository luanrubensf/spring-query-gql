package com.luanrubensf.springquerygql.configuration;

import com.mysema.query.types.path.PathBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {
    @Bean
    public PathBuilderFactory pathBuilderFactory() {
        return new PathBuilderFactory();
    }
}
