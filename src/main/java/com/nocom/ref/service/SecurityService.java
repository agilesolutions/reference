package com.nocom.ref.service;

import com.nocom.ref.model.CustomUser;
import com.nocom.ref.model.MyEntitlement;
import com.nocom.ref.model.MyEntity;
import com.nocom.ref.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityService {

    public Set<String> getDelegated() {

        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .filter(MyEntitlement.class::isInstance)
                .map(MyEntitlement.class::cast)
                .map(MyEntitlement::getDelegated)
                .flatMap(Collection::stream)
                .map(MyEntity::getId)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    public static Optional<CustomUser> getCurrentUser() {

        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .filter(CustomUser.class::isInstance)
                .map(CustomUser.class::cast);

    }



}
