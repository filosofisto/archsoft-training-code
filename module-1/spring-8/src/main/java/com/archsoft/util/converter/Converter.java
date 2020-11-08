package com.archsoft.util.converter;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Converter<E, T> {

    private ModelMapper modelMapper;
    private Class<E> classEntity;
    private Class<T> classTO;

    public Converter() {
        modelMapper = new ModelMapper();
    }

    public E toEntity(T to) {
        return modelMapper.map(to, getClassEntity());
    }

    public Iterable<E> toEntity(Iterable<T> iterable) {
        List<E> list = new ArrayList<>();
        iterable.forEach(item -> list.add(toEntity(item)));
        return list;
    }

    public T toTransferObject(E entity) {
        return modelMapper.map(entity, getClassTransferObject());
    }

    public Iterable<T> toTransferObject(Iterable<E> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(item -> list.add(toTransferObject(item)));
        return list;
    }

    public Page<T> toTransferObject(Page<E> page) {
        List<T> list = new ArrayList<>();
        page.forEach(entity -> list.add(toTransferObject(entity)));

        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

    @SuppressWarnings("unchecked")
    private Class<E> getClassEntity() {
        if (Objects.isNull(classEntity)) {
            classEntity = (Class<E>)
                    ((ParameterizedType) getClass().getGenericSuperclass())
                            .getActualTypeArguments()[0];
        }

        return classEntity;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClassTransferObject() {
        if (Objects.isNull(classTO)) {
            classTO = (Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass())
                            .getActualTypeArguments()[1];
        }

        return classTO;
    }
}
