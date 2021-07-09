package com.jaksmok.suonchantha.repository;

import com.jaksmok.suonchantha.infrastructure.repository.BaseRepository;
import com.jaksmok.suonchantha.model.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<BookEntity, Long> {
}
