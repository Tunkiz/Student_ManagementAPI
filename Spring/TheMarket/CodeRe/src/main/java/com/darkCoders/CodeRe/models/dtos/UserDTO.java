package com.darkCoders.CodeRe.models.dtos;

import com.darkCoders.CodeRe.models.Cart;
import com.darkCoders.CodeRe.models.User;
import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String address;
    private Cart cart;
    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setCart(user.getCart());
        return userDTO;
    }
}
