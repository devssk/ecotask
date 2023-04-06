package com.backend.ecotask.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartments is a Querydsl query type for Departments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartments extends EntityPathBase<Departments> {

    private static final long serialVersionUID = 1710360885L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepartments departments = new QDepartments("departments");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath departmentName = createString("departmentName");

    public final QLocations locations;

    public final QEmployees manager;

    public QDepartments(String variable) {
        this(Departments.class, forVariable(variable), INITS);
    }

    public QDepartments(Path<? extends Departments> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepartments(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepartments(PathMetadata metadata, PathInits inits) {
        this(Departments.class, metadata, inits);
    }

    public QDepartments(Class<? extends Departments> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locations = inits.isInitialized("locations") ? new QLocations(forProperty("locations"), inits.get("locations")) : null;
        this.manager = inits.isInitialized("manager") ? new QEmployees(forProperty("manager"), inits.get("manager")) : null;
    }

}

