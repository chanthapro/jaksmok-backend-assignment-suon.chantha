package com.jaksmok.suonchantha.infrastructure.utils;

import com.jaksmok.suonchantha.model.entity.UserEntity;
import com.jaksmok.suonchantha.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String>{

    private final AuthService authService;

    @Autowired
    public AuditorAwareImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            UserEntity user = authService.getCurrentUser();
            if(user == null){
                return Optional.of("Anonymous");
            }
            return Optional.of(user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of("Anonymous");
    }
}
