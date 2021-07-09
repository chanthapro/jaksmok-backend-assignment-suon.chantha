package com.jaksmok.suonchantha.infrastructure.service;

import com.jaksmok.suonchantha.infrastructure.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseService<T , ID extends Serializable>{

    BaseRepository<T,ID> getRepository();

    Page<T> findAllAvailable(Pageable pageable);

    T create(T data);

    T findOneById(ID id) throws Exception;

    T AlreadyExitsValue(String key, String value);

}
