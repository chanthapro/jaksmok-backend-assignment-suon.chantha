package com.jaksmok.suonchantha.infrastructure.repository;


import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public  class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID>
        implements BaseRepository<T,ID>  {

    private JpaEntityInformation<T,?> entityInformation;
    private EntityManager entityManager;


    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

}
