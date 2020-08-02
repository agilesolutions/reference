package com.nocom.ref.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

public class CustomUser extends User {

    private String location;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String location) {
        super(username, password, authorities);
        this.location = location;
    }

    public Optional<String> getLocation() {
        return Optional.ofNullable(location);
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
