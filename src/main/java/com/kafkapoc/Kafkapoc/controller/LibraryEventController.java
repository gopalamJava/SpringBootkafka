package com.kafkapoc.Kafkapoc.controller;


import com.kafkapoc.Kafkapoc.model.LibraryEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryEventController {



@PostMapping("/v1/LibraryEvent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent){

    //invoke kafka producer
    System.out.println("hello world");

    return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
}




}
