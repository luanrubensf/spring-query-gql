package com.luanrubensf.springquerygql.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProcesso is a Querydsl query type for Processo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProcesso extends EntityPathBase<Processo> {

    private static final long serialVersionUID = 935612694L;

    public static final QProcesso processo = new QProcesso("processo");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Parecer, QParecer> pareceres = this.<Parecer, QParecer>createList("pareceres", Parecer.class, QParecer.class, PathInits.DIRECT2);

    public QProcesso(String variable) {
        super(Processo.class, forVariable(variable));
    }

    public QProcesso(Path<? extends Processo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcesso(PathMetadata<?> metadata) {
        super(Processo.class, metadata);
    }

}

