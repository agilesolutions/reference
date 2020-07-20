package com.nocom.ref.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
public class MyEntity {

    private final String key ;
    private final String value;
    private final Map<String, String> ids;

    public Optional<String> getId() {
        return Optional.ofNullable(this.ids.get("MAINID"));
    }

}
