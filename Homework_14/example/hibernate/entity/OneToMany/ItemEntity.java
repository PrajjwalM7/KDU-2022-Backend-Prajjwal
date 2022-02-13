package com.example.hibernate.entity.OneToMany;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "item")
public class ItemEntity implements Serializable {
    @Id
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cart;

    @Column(name = "price")
    private double price;
}
