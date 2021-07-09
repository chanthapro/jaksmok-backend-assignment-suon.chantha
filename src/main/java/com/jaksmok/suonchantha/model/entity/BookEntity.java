package com.jaksmok.suonchantha.model.entity;

import com.jaksmok.suonchantha.constant.TableConstant;
import com.jaksmok.suonchantha.infrastructure.entity.BaseWithAudible;
import com.jaksmok.suonchantha.model.response.BookResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.print.Book;

@Entity
@Table(name = TableConstant.BOOK)
public class BookEntity extends BaseWithAudible<Long> {

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String realYears;

    @Column
    private String year;

    @Column
    private String country;

    @Column
    private String language;

    @Column
    private int pages;

    @Column
    private String wikipediaLink;

    @Column
    private String imageUrl;


    public BookEntity() {
    }

    public BookEntity(String title, String author, String realYears, String year, String country, String language, int pages, String wikipediaLink, String imageUrl) {
        this.title = title;
        this.author = author;
        this.realYears = realYears;
        this.year = year;
        this.country = country;
        this.language = language;
        this.pages = pages;
        this.wikipediaLink = wikipediaLink;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRealYears() {
        return realYears;
    }

    public void setRealYears(String realYears) {
        this.realYears = realYears;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public BookResponse toResponse() {
        return new BookResponse(
                this.getId(),
                this.title,
                this.author,
                this.realYears,
                this.year,
                this.country,
                this.language,
                this.pages,
                this.wikipediaLink,
                this.imageUrl
        );
    }

}
