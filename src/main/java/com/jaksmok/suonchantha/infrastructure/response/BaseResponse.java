package com.jaksmok.suonchantha.infrastructure.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private Object content;
    private ResponsePage page;
    private ResponseStatus status;

    public BaseResponse(
            Object content,
            ResponseStatus status,
            ResponsePage page
    ) {

        this.content = content;
        this.status = status;
        this.page = page;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }


    public BaseResponse(
            @JsonInclude(JsonInclude.Include.NON_NULL)
                    Object content,
            ResponseStatus status
    ) {

        this.content = content;
        this.status = status;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }


    public static ResponseEntity<Object> success(
            List<?> data, String message
    ) {
        ResponseStatus status = new ResponseStatus(
                message, 200
        );
        BaseResponse response = new BaseResponse(data, status, null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public static ResponseEntity<Object> success(
            Page<?> page, String message
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponsePage p = page.getPageable().isUnpaged() ? null
                : new ResponsePage(
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize()
        );

        ResponseStatus status = new ResponseStatus(
                message, 200
        );


        BaseResponse data = new BaseResponse(
                page.getContent(),
                status,
                p
        );


        return ResponseEntity.status(HttpStatus.OK).body(data);

    }


    public static ResponseEntity<Object> success(Object data, String message) {
        ResponseStatus status = new ResponseStatus(
                message, 200
        );

        BaseResponse response = new BaseResponse(
                data,
                status
        );


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public static ResponseEntity<Object> failed(
            HttpStatus status,
            String message
    ) {

        ResponseStatus s = new ResponseStatus(
                message,
                status.value()
        );

        BaseResponse response = new BaseResponse(
                null,
                s,
                null
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public BaseResponse() {

    }


    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ResponsePage getPage() {
        return page;
    }

    public void setPage(ResponsePage page) {
        this.page = page;
    }
}
