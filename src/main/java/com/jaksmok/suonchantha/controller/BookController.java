package com.jaksmok.suonchantha.controller;


import com.jaksmok.suonchantha.constant.RestUriConstant;
import com.jaksmok.suonchantha.infrastructure.response.BaseResponse;
import com.jaksmok.suonchantha.model.entity.BookEntity;
import com.jaksmok.suonchantha.model.request.BookRequest;
import com.jaksmok.suonchantha.model.response.BookResponse;
import com.jaksmok.suonchantha.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestUriConstant.BOOK)
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService  bookService){
        this.bookService = bookService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> save(
            @RequestBody BookRequest bookRequest
    ){
        BookEntity data = bookService.create(bookRequest.toEntity());
        return BaseResponse.success(data.toResponse(),"success");
    }

    @GetMapping
    public ResponseEntity<Object> getAll(
            Pageable pageable
    ){
        Page<BookResponse> book = bookService.findAllAvailable(pageable).map(BookEntity::toResponse);
        return BaseResponse.success(book,"Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(
        @PathVariable Long id
    ) throws Exception {
        BookEntity book = bookService.findOneById(id);
        return BaseResponse.success(book.toResponse(), "Success");
    }

}
