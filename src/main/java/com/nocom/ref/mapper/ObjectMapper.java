package com.nocom.ref.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface ObjectMapper<O,D> {

    public D mapToDto(O modelObject);

    public O mapFromDto(D dto);

    default List<D> mapToDtos(List<O> modelObjects) {
        return modelObjects.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    default List<O> mapFromDtos(List<D> dtos) {
        return dtos.stream().map(this::mapFromDto).collect(Collectors.toUnmodifiableList());
    }

}