package com.prod_ready_features.prodready.config;

import com.prod_ready_features.prodready.auth.AuditorAwareImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef =  "auditorAwareImp")
public class AppConfig {
    @Bean
    ModelMapper getModelMapper(){return new ModelMapper();}
    @Bean
    AuditorAware<String> auditorAwareImp(){return new AuditorAwareImp();}
}
