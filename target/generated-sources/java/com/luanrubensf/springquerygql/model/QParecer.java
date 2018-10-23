package com.luanrubensf.springquerygql.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QParecer is a Querydsl query type for Parecer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QParecer extends EntityPathBase<Parecer> {

    private static final long serialVersionUID = 1624523254L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParecer parecer = new QParecer("parecer");

    public final DatePath<java.time.LocalDate> data = createDate("data", java.time.LocalDate.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProcesso processo;

    public QParecer(String variable) {
        this(Parecer.class, forVariable(variable), INITS);
    }

    public QParecer(Path<? extends Parecer> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QParecer(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QParecer(PathMetadata<?> metadata, PathInits inits) {
        this(Parecer.class, metadata, inits);
    }

    public QParecer(Class<? extends Parecer> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.processo = inits.isInitialized("processo") ? new QProcesso(forProperty("processo")) : null;
    }

}

