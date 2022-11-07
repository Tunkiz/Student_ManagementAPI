package com.bookshop.BookShop.controllers;

import com.bookshop.BookShop.models.Client;
import com.bookshop.BookShop.models.dto.ClientDto;
import com.bookshop.BookShop.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody final ClientDto clientDto){
        Client client = clientService.addClient(Client.from(clientDto));
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable final Long id){
        Client client = clientService.getClient(id);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(){
        List<Client> clients = clientService.getClients();
        List<ClientDto> clientDtos = clients.stream().map(ClientDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable final Long id, @RequestBody final ClientDto clientDto){
        Client client = clientService.updateClient(id, Client.from(clientDto));
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable final Long id){
        Client client = clientService.deleteClient(id);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }



}
