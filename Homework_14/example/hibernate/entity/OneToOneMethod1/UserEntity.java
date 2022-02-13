package com.example.hibernate.entity.OneToOneMethod1;

import com.example.model.Address;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int ID;

    @Column(name = "name")
    private String name;

    // One-One Relationship
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // OR Another Method
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private AddressEntity addressJoin;
}
