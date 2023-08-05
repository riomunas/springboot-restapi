package org.aaim.api.bookapp;

import java.util.List;

public interface BookService {
  List<Book> findAll();

  Book findById(int id);

  List<Book> findByAuthor(String author) throws BookNotFoundException;

  List<Book> findByCategory(String category) throws BookNotFoundException;

  void addBook(Book book);
}
