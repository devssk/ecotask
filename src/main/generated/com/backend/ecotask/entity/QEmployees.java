package com.backend.ecotask.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployees is a Querydsl query type for Employees
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployees extends EntityPathBase<Employees> {

    private static final long serialVersionUID = 1986541145L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployees employees = new QEmployees("employees");

    public final NumberPath<java.math.BigDecimal> commissionPct = createNumber("commissionPct", java.math.BigDecimal.class);

    public final QDepartments departments;

    public final StringPath email = createString("email");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final StringPath firstName = createString("firstName");

    public final DatePath<java.time.LocalDate> hireDate = createDate("hireDate", java.time.LocalDate.class);

    public final QJobs jobs;

    public final StringPath lastName = createString("lastName");

    public final QEmployees manager;

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);

    public QEmployees(String variable) {
        this(Employees.class, forVariable(variable), INITS);
    }

    public QEmployees(Path<? extends Employees> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployees(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployees(PathMetadata metadata, PathInits inits) {
        this(Employees.class, metadata, inits);
    }

    public QEmployees(Class<? extends Employees> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.departments = inits.isInitialized("departments") ? new QDepartments(forProperty("departments"), inits.get("departments")) : null;
        this.jobs = inits.isInitialized("jobs") ? new QJobs(forProperty("jobs")) : null;
        this.manager = inits.isInitialized("manager") ? new QEmployees(forProperty("manager"), inits.get("manager")) : null;
    }

}

