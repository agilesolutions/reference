package com.nocom.ref.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MyEntitlement implements GrantedAuthority {

    private final List<MyEntity> delegated;

    public List<MyEntity> getDelegated() {
        return this.delegated;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
