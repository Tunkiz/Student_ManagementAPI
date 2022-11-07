package com.bookshop.BookShop.models.dto;

import com.bookshop.BookShop.models.Client;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private List<BookDto> bookDtos = new ArrayList<>();

    public static ClientDto from(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        clientDto.setAddress(client.getAddress());
        clientDto.setBookDtos(client.getBooks().stream().map(BookDto::from).collect(Collectors.toList()));
        return clientDto;
    }
}
