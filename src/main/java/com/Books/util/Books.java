package com.Books.util;

import com.Books.util.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private String status;
    private int code;
    private int total;
    private List<Book> data;
}
