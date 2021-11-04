package com.Crystal.AddressBook.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue
    @Column(updatable = false,nullable = false)
    Long id;
    @Column(nullable=false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String number;
    @Column(nullable = false)
    String street;
    @Column
    String unit;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    String state;
    @Column(nullable = false)
    String postalCode;
    @Column
    String email;
    @Column
    String cellPhone;
    @Column
    String workPhone;
    @Column
    String homePhone;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    @UpdateTimestamp
    Timestamp lastModified;

}
