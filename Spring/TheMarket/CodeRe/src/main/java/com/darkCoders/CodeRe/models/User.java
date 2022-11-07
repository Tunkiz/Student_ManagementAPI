package com.darkCoders.CodeRe.models;

import com.darkCoders.CodeRe.models.dtos.UserDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public static User from(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setCart(userDTO.getCart());
        return user;
    }

}
