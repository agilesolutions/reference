package com.nocom.ref.util;

import com.nocom.ref.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@Component("securityUtils")
public class SecurityUtils {

    private static final String ROLE_MANAGER = "ROLE_MANAGER";

    public boolean isManager() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().filter(AnonymousAuthenticationToken.class::isInstance).anyMatch(r -> r.getAuthority().equals(ROLE_MANAGER));
    }

    public boolean isCurrentUserSwiss() {
        Optional<Object> currentUser = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return currentUser.filter(User.class::isInstance)
                .map(User.class::cast)
                .flatMap(User::getLocation)
                .map("CH"::equals)
                .orElse(false);

    }

    public String getCurrentUserName() {
        Optional<Object> currentUser = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return currentUser.filter(User.class::isInstance)
                .map(User.class::cast)
                .map(User::getUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
}
