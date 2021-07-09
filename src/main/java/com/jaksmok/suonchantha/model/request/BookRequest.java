package com.jaksmok.suonchantha.model.request;

import com.jaksmok.suonchantha.model.entity.BookEntity;

public class BookRequest {

    private String title;

    private String author;

    private String realYears;

    private String year;

    private String country;

    private String language;

    private int pages;

    private String wikipediaLink;

    private String imageUrl;


    public BookRequest() {
    }

    public BookRequest(String title, String author, String realYears, String year, String country, String language, int pages, String wikipediaLink, String imageUrl) {
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



    public BookEntity toEntity(){
        return new BookEntity(
                title,
                author,
                realYears,
                year,
                country,
                language,
                pages,
                wikipediaLink,
                imageUrl
        );
    }

}
