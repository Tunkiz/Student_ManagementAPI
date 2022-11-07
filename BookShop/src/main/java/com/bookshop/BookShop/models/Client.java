package com.bookshop.BookShop.models;

import com.bookshop.BookShop.models.dto.ClientDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
    @OneToOne


    public static Client from(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setAddress(clientDto.getAddress());
        return client;
    }

}
