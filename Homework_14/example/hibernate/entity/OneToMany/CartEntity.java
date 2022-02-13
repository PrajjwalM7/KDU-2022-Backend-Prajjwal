package com.example.hibernate.entity.OneToMany;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @Column(name = "cart_id")
    private int id;

    @OneToMany(mappedBy = "cart")
    private Set<ItemEntity> items;
}
