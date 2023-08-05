package org.aaim.api.bookapp;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceimpl implements BookService {

  @Override
  public Book findById(int id) {
    return findAll()
      .stream()
      .filter(book -> (book.getId() == id))
      .findAny()
      .orElseThrow();
  }

  @Override
  public List<Book> findByAuthor(String author) {
    return findAll()
      .stream()
      .filter(book -> (book.getAuthor().equalsIgnoreCase(author)))
      .collect(Collectors.toList());
  }

  @Override
  public List<Book> findByCategory(String category) {
    return findAll()
      .stream()
      .filter(book -> (book.getCategory().equalsIgnoreCase(category)))
      .collect(Collectors.toList());
  }

  @Override
  public void addBook(Book book) {
    System.out.println(book);
  }

  public List<Book> findAll() {
    return Arrays.asList(
      new Book(10001, "Java", "Catty", "Tech"),
      new Book(10002, "Spring Boot", "Rot", "Tech"),
      new Book(20001, "Mirracle", "Catty", "Fiction"),
      new Book(20002, "Ferrari", "Robin", "Ficiton"),
      new Book(30001, "Captain America", "Hal", "Comic"),
      new Book(40001, "Skull Glow", "Kumaran", "Horor")
    );
  }
}
