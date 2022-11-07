package com.bookshop.BookShop.services;

import com.bookshop.BookShop.models.Client;
import com.bookshop.BookShop.models.exceptions.ClientNotFoundException;
import com.bookshop.BookShop.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

//    public ClientService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }
    public Client addClient(Client client){
        return clientRepository.save(client);
    }
    public Client getClient(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
    public Client getByName(String name){
        return clientRepository.findByName(name);
    }
    public List<Client> getClients(){
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public Client updateClient(Long id, Client client){
        Client clientToUpdate = getClient(id);
        if (Objects.nonNull(client.getName())){
            clientToUpdate.setName(client.getName());
        }
        if (Objects.nonNull(client.getAddress())){
            clientToUpdate.setAddress(client.getAddress());
        }
        if (Objects.nonNull(client.getEmail())){
            clientToUpdate.setEmail(client.getEmail());
        }
        return clientToUpdate;
    }
    public Client deleteClient(Long id){
        Client client = getClient(id);
        clientRepository.delete(client);
        return client;
    }
}
