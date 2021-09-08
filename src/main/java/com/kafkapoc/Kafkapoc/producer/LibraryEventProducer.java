package com.kafkapoc.Kafkapoc.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkapoc.Kafkapoc.model.LibraryEvent;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class LibraryEventProducer {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;



    public void sendLibraryEventsToKafka(LibraryEvent libraryEvent) throws JsonProcessingException {


        System.out.println("myvalue before" );
       ListenableFuture<SendResult<Integer, String>> ls= kafkaTemplate.send( getPoducerRecord(libraryEvent));
        System.out.println("myvalue Aftre" );


    }

    private ProducerRecord getPoducerRecord(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key= libraryEvent.getLibraryEventId();
        String value=objectMapper.writeValueAsString(libraryEvent);
        ProducerRecord producerRecord= new ProducerRecord("libary-events",key,value);
        return producerRecord;
    }


}
