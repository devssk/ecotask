package com.backend.ecotask.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmpDetailsView is a Querydsl query type for EmpDetailsView
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmpDetailsView extends EntityPathBase<EmpDetailsView> {

    private static final long serialVersionUID = -2099781685L;

    public static final QEmpDetailsView empDetailsView = new QEmpDetailsView("empDetailsView");

    public final StringPath city = createString("city");

    public final NumberPath<java.math.BigDecimal> commissionPct = createNumber("commissionPct", java.math.BigDecimal.class);

    public final StringPath countryId = createString("countryId");

    public final StringPath countryName = createString("countryName");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath departmentName = createString("departmentName");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath jobId = createString("jobId");

    public final StringPath jobTitle = createString("jobTitle");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public final StringPath regionName = createString("regionName");

    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);

    public final StringPath stateProvince = createString("stateProvince");

    public QEmpDetailsView(String variable) {
        super(EmpDetailsView.class, forVariable(variable));
    }

    public QEmpDetailsView(Path<? extends EmpDetailsView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmpDetailsView(PathMetadata metadata) {
        super(EmpDetailsView.class, metadata);
    }

}

