package org.aaim.api.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

  @Autowired BookService service;
  @GetMapping("hi")
  public ResponseEntity<String> sayHi() {
    String body = "Hi. Allah Maha Baik";
    HttpHeaders headers = new HttpHeaders();
    headers.add("desc", "Online Book Application");
    return ResponseEntity
      .status(HttpStatus.OK)
      .headers(headers)
      .body(body);
  }

  @GetMapping
  public ResponseEntity<List<Book>> findAll() {
    List<Book> body = service.findAll();
    return ResponseEntity.ok(body);
  }

  @GetMapping("{id}")
  public ResponseEntity<Book> findById(@PathVariable int id) {
    Book book = service.findById(id);
    return ResponseEntity.ok(book);
  }

  /*Kalau nama param di URI beda ama di local method maka tambahkan param di @PathVariable dengan nama sama dengan param di URI */
  @GetMapping("test/{bookId}")
  public ResponseEntity<Book> findByIdTest(@PathVariable("bookId") int id) {
    Book book = service.findById(id);
    return ResponseEntity.ok(book);
  }

  @GetMapping("find-by-author")
  public ResponseEntity<Response> findByAuthor(@RequestParam("author") String author) {
    List<Book> bookList = service.findByAuthor(author);
    return ResponseEntity.ok(new Response(bookList));
  }

  @GetMapping("find-by-category")
  public ResponseEntity<Response> findByTitleAuthor(@RequestParam("category") String category) {
    List<Book> bookList = service.findByCategory(category);
    return ResponseEntity.ok(new Response(bookList));
  }

  @PostMapping
  public ResponseEntity<Void> addBook(@RequestBody Book book) {
    HttpHeaders headers = new HttpHeaders();
    service.addBook(book);
    headers.add("Desc", "Adding a Book");
    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
  }
}
