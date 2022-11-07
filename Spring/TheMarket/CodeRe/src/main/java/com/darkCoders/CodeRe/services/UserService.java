package com.darkCoders.CodeRe.services;

import com.darkCoders.CodeRe.models.Cart;
import com.darkCoders.CodeRe.models.User;
import com.darkCoders.CodeRe.models.exceptions.UserNotFoundException;
import com.darkCoders.CodeRe.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartServices cartService;
    @Autowired
    public UserService(UserRepository userRepository, CartServices cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }
    public User addUser(User newUser){
        Cart cart = new Cart();
        cartService.addCart(cart);
        newUser.setCart(cart);
        return  userRepository.save(newUser);
    }
    public List<User> getUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public User getUser(long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    @Transactional
    public User updateUser(long id, User user){
        User userToUpdate = getUser(id);

        if (Objects.nonNull(user.getName()))
            userToUpdate.setName(user.getName());
        if (Objects.nonNull(user.getAddress()))
            userToUpdate.setAddress(user.getAddress());
        if (Objects.nonNull(user.getEmail()))
            userToUpdate.setEmail(user.getEmail());

        return userToUpdate;
    }
    public User DeleteUser(long id){
        User userToDelete = getUser(id);
        userRepository.delete(userToDelete);
        return userToDelete;
    }
}
