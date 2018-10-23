package com.luanrubensf.springquerygql.repository;

import com.luanrubensf.springquerygql.core.IEntity;
import com.luanrubensf.springquerygql.core.pagination.Page;
import com.luanrubensf.springquerygql.core.pagination.Pageable;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.PathBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;

@Component
public class BasicRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PathBuilderFactory pathBuilderFactory;

    public <T extends  IEntity> T merge(T entity) {
        T merged = entityManager.merge(entity);
        entityManager.flush();
        return merged;
    }

    public <T extends IEntity> void persist(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    public <T extends IEntity> void remove(T entity) {
        entityManager.remove(entity);
    }

    public <T extends IEntity> T find(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }

    public <T extends IEntity> T findOne(Class<T> clazz, Predicate... where) {
        PathBuilder<T> entityPath = pathBuilderFactory.create(clazz);
        return from(entityPath)
                .where(where)
                .singleResult(entityPath);
    }

    public <T extends IEntity> List<T> findAll(Class<T> clazz, Predicate... predicates) {
        PathBuilder<T> entityPath = pathBuilderFactory.create(clazz);
        JPAQuery query = from(entityPath)
<<<<<<< HEAD
                .where(applyFilters(predicates));
=======
                .where(predicates);
>>>>>>> refs/remotes/origin/master

        return query.list(entityPath);
    }

    public <T extends IEntity> Page<T> findAll(Class<T> clazz, Pageable pageable, Predicate... predicates) {
        Integer limit = pageable.getLimit();
        Long offset = pageable.getOffset();

        PathBuilder<T> entityPath = pathBuilderFactory.create(clazz);
        JPAQuery query = from(entityPath)
<<<<<<< HEAD
                .where(applyFilters(predicates));
=======
                .where(predicates);
>>>>>>> refs/remotes/origin/master

        long total = query.count();

        List<T> content = query
                .limit(limit)
                .offset(offset)
                .list(entityPath);

        return Page.of(limit, offset, total, content);
    }

    public JPAQuery from(EntityPath... entityPath) {
        return new JPAQuery(entityManager).from(entityPath);
    }
<<<<<<< HEAD

    private <T> Predicate applyFilters(Predicate... predicates) {
        BooleanBuilder filter = new BooleanBuilder();

        if (predicates != null && predicates.length > 0) {
            Stream.of(predicates).forEach(filter::and);
        }

        return filter;
    }
=======
>>>>>>> refs/remotes/origin/master
}
