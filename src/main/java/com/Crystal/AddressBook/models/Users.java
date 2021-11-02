package com.Crystal.AddressBook.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @Column(updatable = false,nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String role;
}
