package com.nocom.ref.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component("securityUtils")
public class SecurityUtils {

    private static final String ROLE_MANAGER = "ROLE_MANAGER";

    public boolean isManager() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().filter(AnonymousAuthenticationToken.class::isInstance) .anyMatch(r -> r.getAuthority().equals(ROLE_MANAGER));
    }
}
