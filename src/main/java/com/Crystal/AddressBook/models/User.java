package com.Crystal.AddressBook.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    @Column(updatable = false,nullable = false)
    Long id;
    @Column(updatable = false,nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    @Column
    UserRole userRole;
//    String role;
}
