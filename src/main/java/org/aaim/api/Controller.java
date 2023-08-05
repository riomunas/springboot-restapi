package org.aaim.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping
  public ResponseEntity<String> home() {
    String body = "Hi... Allah Maha Baik";
    HttpHeaders headers = new HttpHeaders();
    headers.add("keyword", "Allah Kuasa Makhluk Tidak Kuasa");
    return new ResponseEntity<String>(body, headers, HttpStatus.OK);
  }
}
