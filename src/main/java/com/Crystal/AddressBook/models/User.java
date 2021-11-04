package com.Crystal.AddressBook.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column( columnDefinition = "varchar(32) default 'USER' ")
    @Enumerated(value = EnumType.STRING)
    public UserRole role = UserRole.USER;
  //  String role;
}
