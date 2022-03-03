package springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="country")
public class Country {
    @Id
    @Column(name = "Code")
    private String countryCode;

    @Column(name = "Name")
    private String countryName;
}
