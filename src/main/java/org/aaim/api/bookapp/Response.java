package org.aaim.api.bookapp;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Response {
  List<Payload> data;

  public Response(List<Book> listBook) {
    this.data = listBook.stream().map(
      book -> new Payload()
        .setId(book.getId())
        .setAuthor(book.getAuthor())
        .setCategory(book.getCategory())
    ).collect(Collectors.toList());

    this.data = listBook.stream()
      .map(Payload::new)
      .collect(Collectors.toList());
  }

  @Data
  @NoArgsConstructor
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  @Accessors(chain = true)
  private static class Payload {
    private int id;
    private String author;
    private String category;

    public Payload(Book book) {
      id = book.getId();
      author = book.getAuthor();
      category = book.getCategory();
    }

  }
}
