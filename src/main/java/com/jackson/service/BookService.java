package com.jackson.service;

import com.jackson.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

     Book getBookById(int id);

     List<Book> listBooks();

    List<Integer> task2();

    Map<String, Integer> task4();

}
