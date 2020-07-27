package com.nocom.ref.util;

import com.nocom.ref.model.CustomUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("securityUtils")
public class SecurityUtils {

    private static final String ROLE_MANAGER = "ROLE_MANAGER";

    public boolean isManager() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().filter(AnonymousAuthenticationToken.class::isInstance).anyMatch(r -> r.getAuthority().equals(ROLE_MANAGER));
    }

    public boolean isCurrentUserSwiss() {
        Optional<Object> currentUser = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return currentUser.filter(CustomUser.class::isInstance)
                .map(CustomUser.class::cast)
                .flatMap(CustomUser::getLocation)
                .map("CH"::equals)
                .orElse(false);

    }

    public String getCurrentUserName() {
        Optional<Object> currentUser = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return currentUser.filter(CustomUser.class::isInstance)
                .map(CustomUser.class::cast)
                .map(CustomUser::getUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
}
