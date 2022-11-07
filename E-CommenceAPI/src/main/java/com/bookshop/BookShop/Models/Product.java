package com.bookshop.BookShop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    public enum sex{
        MALE,
        FEMALE
    }
    @Id
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    sex a_sex;
    @Column(name = "dresstype")
    String b_dresstype;
    @Column(name = "image")
    String c_image;
    @Column(name = "price")
    String d_price;
    @Column(name = "arrival")
    String e_arrival;
    @Column(name = "discount")
    int f_discount;
}
