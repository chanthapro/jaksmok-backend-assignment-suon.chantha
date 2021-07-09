package com.jaksmok.suonchantha.infrastructure.service;

import com.jaksmok.suonchantha.infrastructure.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;

@NoRepositoryBean
public abstract class BaseServiceImpl< T extends BaseEntity<ID>, ID
        extends Serializable> implements BaseService<T,ID> {

    private EntityManager em;

    Specification<T> getAvailableSpecification(){
        return (root, query, cb) -> {
            query.orderBy(cb.desc(root.get("id")));
            return cb.isFalse(root.get("isDeleted"));
        };
    }


    Specification<T> findOneAlreadyExitsValue(String key, String value){
        return (root, query, cb) -> {
            Predicate predicate = cb.equal(root.get(key),value);
            query.orderBy(cb.desc(root.get("id")));
            return  cb.and(predicate);
        };
    }


    @Override
    public Page<T> findAllAvailable(Pageable pageable) {
        return getRepository().findAll(getAvailableSpecification(), pageable);
    }


    @Override
    public T create(T data) {
        return getRepository().save(data);
    }

    @Override
    public T findOneById(ID id) throws Exception {
        T data = getRepository().findById(id).orElse(null);
        if(data == null){
            throw new Exception("Record not found");
        }
        return data;
    }

    @Override
    public T AlreadyExitsValue(String key, String value) {
        return getRepository().findOne(findOneAlreadyExitsValue(key,value)).orElse(null);
    }

}
