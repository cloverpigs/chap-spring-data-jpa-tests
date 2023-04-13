package com.greedy.datatests.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages= {"com.greedy.datatests"})
@EnableJpaRepositories(basePackages= {"com.greedy.datatests"})
public class JPAconfiguration {

}
