package springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="contact_details")
public class ContactDetails {
    @Id
    @Column(name="contact_id")
    private String contactID;

    @Column(name="phone")
    private Integer phone;

    @Column(name="email")
    private String email;

    @Column(name="line1")
    private String line1;

    @Column(name="line2")
    private String line2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;
}
