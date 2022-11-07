package com.springboot.restapidemo.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //specifying the relationship
    @OneToMany(cascade  = CascadeType.ALL)
    // spcifying the join column name, this mean we 
    // will have the cart_id column in this table
    // this will tell us which cart does 
    // the specific item is asigned
    @JoinColumn(name = "carr_id")
    private List<Item> items = new ArrayList<>();
    
}
