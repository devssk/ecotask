package com.backend.ecotask.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocations is a Querydsl query type for Locations
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocations extends EntityPathBase<Locations> {

    private static final long serialVersionUID = -1848467918L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocations locations = new QLocations("locations");

    public final StringPath city = createString("city");

    public final QCountries countries;

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final StringPath postalCode = createString("postalCode");

    public final StringPath stateProvince = createString("stateProvince");

    public final StringPath streetAddress = createString("streetAddress");

    public QLocations(String variable) {
        this(Locations.class, forVariable(variable), INITS);
    }

    public QLocations(Path<? extends Locations> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocations(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocations(PathMetadata metadata, PathInits inits) {
        this(Locations.class, metadata, inits);
    }

    public QLocations(Class<? extends Locations> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.countries = inits.isInitialized("countries") ? new QCountries(forProperty("countries"), inits.get("countries")) : null;
    }

}

