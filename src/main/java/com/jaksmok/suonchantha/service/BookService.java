package com.jaksmok.suonchantha.service;


import com.jaksmok.suonchantha.infrastructure.service.BaseService;
import com.jaksmok.suonchantha.model.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends BaseService<BookEntity,Long> {


}
