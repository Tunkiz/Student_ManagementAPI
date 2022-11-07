package com.bookshop.BookShop.repositories;

import com.bookshop.BookShop.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByName(String name);
}
