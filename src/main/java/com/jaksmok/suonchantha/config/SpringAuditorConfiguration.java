package com.jaksmok.suonchantha.config;

import com.jaksmok.suonchantha.infrastructure.utils.AuditorAwareImpl;
import com.jaksmok.suonchantha.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class SpringAuditorConfiguration {

    private final AuthService authService;

    public SpringAuditorConfiguration(AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl(authService);
    }
}
