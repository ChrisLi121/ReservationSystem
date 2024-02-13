package com.chris.yaqi.java.springboot.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ClientService {

    public List<Client> getClient(){
        return List.of(
                new Client(1L,
                        "Jason Jiang",
                        LocalDate.of(1999, Month.FEBRUARY,22),
                        23,
                        "johnjohn121@gmail.com"
                )

        );
    }
}
