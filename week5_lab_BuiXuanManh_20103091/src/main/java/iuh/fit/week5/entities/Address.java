package iuh.fit.week5.entities;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Long id;
    @Column(columnDefinition = "varchar(50)")
    private String city;
    @Column(name = "country",columnDefinition = "smallint(6)")
    private CountryCode countryCode;
    @Column(columnDefinition = "varchar(7)")
    private String zipcode;
    @Column(columnDefinition = "varchar(150)")
    private String street;
    @Column(columnDefinition = "varchar(20)")
    private String number;

    public Address(String city, CountryCode countryCode, String zipcode, String street, String number) {
        this.city = city;
        this.countryCode = countryCode;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
    }
}
