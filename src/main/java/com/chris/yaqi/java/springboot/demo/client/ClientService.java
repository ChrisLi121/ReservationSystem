package com.chris.yaqi.java.springboot.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientByEmail= clientRepository.findClientByEmail(client.getEmail());
        if(clientByEmail.isPresent()){
            throw new IllegalStateException("Email has been taken.");
        }else {
            clientRepository.save(client);
        }


    }

    public void deleteClient(Long id) {
        if(!clientRepository.existsById(id)){
            throw new IllegalStateException("Client with id " + id + " not found.");
        }else{
            clientRepository.deleteById(id);
        }
    }
    @Transactional
    public void updateClient(Long clientId, String name, String email) {

        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalStateException("Client with id " + clientId + " not found."));
        if(name != null && !name.isEmpty() && !Objects.equals(name,client.getName())){
            client.setName(name);
        }
        if(email != null && !email.isEmpty() && !Objects.equals(email,client.getEmail())){
            if(clientRepository.findClientByEmail(email).isPresent()){
                throw new IllegalStateException("email taken");
            }
            client.setEmail(email);
        }

    }
}
