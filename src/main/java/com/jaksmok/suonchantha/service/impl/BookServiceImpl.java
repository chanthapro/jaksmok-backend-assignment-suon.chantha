package com.jaksmok.suonchantha.service.impl;

import com.jaksmok.suonchantha.infrastructure.repository.BaseRepository;
import com.jaksmok.suonchantha.infrastructure.service.BaseServiceImpl;
import com.jaksmok.suonchantha.model.entity.BookEntity;
import com.jaksmok.suonchantha.repository.BookRepository;
import com.jaksmok.suonchantha.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookServiceImpl extends BaseServiceImpl<BookEntity,Long> implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public BaseRepository<BookEntity, Long> getRepository() {
        return bookRepository;
    }

    @Override
    @Transactional
    public BookEntity create(BookEntity data) {
        return super.create(data);
    }

}
