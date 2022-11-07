package com.bookshop.BookShop.Repositories;

import com.bookshop.BookShop.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    public List<OrderItem> findByCart_Id(Long cart_id);

    public Optional<OrderItem> findById(String id);
}
