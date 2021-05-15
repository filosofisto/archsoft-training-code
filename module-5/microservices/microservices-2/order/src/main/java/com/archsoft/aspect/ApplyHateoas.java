package com.archsoft.aspect;

import com.archsoft.exception.RecordNotFoundException;

@FunctionalInterface
public interface ApplyHateoas<T> {

    T apply() throws RecordNotFoundException;
}
