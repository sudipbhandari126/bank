package com.fyle.bank.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.fyle.bank.models")
@EnableJpaRepositories(basePackages = "com.fyle.bank.repositories")
public class DBConfiguration {
}
