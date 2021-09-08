package com.kafkapoc.Kafkapoc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkapoc.Kafkapoc.model.LibraryEvent;
import com.kafkapoc.Kafkapoc.producer.LibraryEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class LibraryEventController {

    @Autowired
    private LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/LibraryEvent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) {

        //invoke kafka producer
        System.out.println("hello world");
        try {
            libraryEventProducer.sendLibraryEventsToKafka(libraryEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }


}
