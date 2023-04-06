package com.backend.ecotask.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountries is a Querydsl query type for Countries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCountries extends EntityPathBase<Countries> {

    private static final long serialVersionUID = 701358472L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCountries countries = new QCountries("countries");

    public final StringPath CountryId = createString("CountryId");

    public final StringPath countryName = createString("countryName");

    public final QRegions regions;

    public QCountries(String variable) {
        this(Countries.class, forVariable(variable), INITS);
    }

    public QCountries(Path<? extends Countries> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCountries(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCountries(PathMetadata metadata, PathInits inits) {
        this(Countries.class, metadata, inits);
    }

    public QCountries(Class<? extends Countries> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.regions = inits.isInitialized("regions") ? new QRegions(forProperty("regions")) : null;
    }

}

