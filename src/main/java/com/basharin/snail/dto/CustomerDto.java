package com.basharin.snail.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
	
    Long id;
    String firstName;
    String lastName;
    String dob;
    String address;
    String zipCode;
    String phone;
    String email;
    String password;
}