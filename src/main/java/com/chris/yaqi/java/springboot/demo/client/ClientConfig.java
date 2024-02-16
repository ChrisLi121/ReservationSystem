package com.chris.yaqi.java.springboot.demo.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.FEBRUARY;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client john = new Client(
                    "Jason Jiang",
                    LocalDate.of(1999, FEBRUARY,22),
                    "jasonjason121@gmail.com"
            );
            Client jason = new Client(
                    "John Lin",
                    LocalDate.of(1990, FEBRUARY,22),
                    "johnjohn121@gmail.com"
            );
            repository.saveAll(List.of(jason,john));


        };
    }
}
