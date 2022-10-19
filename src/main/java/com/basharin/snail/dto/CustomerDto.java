package com.basharin.snail.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/*
 * Class to store runtime User object.
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
	
//	@Size(min = 1, max = 25)
//    String firstName;
//	@Size(min = 1, max = 25)
//    String lastName;
//	@NotEmpty
//    String dob;
//	@Size(min = 1, max = 50)
//    String address;
//	@NotEmpty
////	@Pattern(regexp = "^[0-9]{5}")
//    String zipCode;
//	@NotEmpty
////	@Pattern(regexp = "^[0-9]{10}")
//    String phone;
//	@NotEmpty
//    @Email
//    String email;
//    @NotEmpty
//    @Size(min = 5, max = 10)
//    String password;
    
	
    String firstName;
    String lastName;
    String dob;
    String address;
    String zipCode;
    String phone;
    String email;
    String password;
} // close CustomerDto class