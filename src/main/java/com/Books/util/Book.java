package com.Books.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private String isbn;
    private String image;
    private String published;
    private String publisher;
}
