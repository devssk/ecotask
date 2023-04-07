package com.backend.ecotask.dto.mapper;

import org.hibernate.Hibernate;

import java.util.Collection;

public interface LazyLoadingAwareMapper {
    default boolean isNotLazyLoaded(Collection<?> sourceCollection) {
        if (Hibernate.isInitialized(sourceCollection)) {
            return true;
        }
        return false;
    }
}
