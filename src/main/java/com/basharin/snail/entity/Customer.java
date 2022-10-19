package com.basharin.snail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/*
 * POJO class of Customer entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "first_name", columnDefinition = "VARCHAR(25) NOT NULL")
	String firstName;
	
	@Column(name = "last_name", columnDefinition = "VARCHAR(25) NOT NULL")
	String lastName;
	
	@Column(name = "date_of_birth", columnDefinition = "DATE NOT NULL")
	String dob;
	
	@Column(name = "address", columnDefinition = "VARCHAR(50) NOT NULL")
	String address;
	
	@Column(name = "phone", columnDefinition = "VARCHAR(13) NOT NULL")
	String phone;
	
	@Column(name = "email", columnDefinition = "VARCHAR(25) NOT NULL UNIQUE")
	String email;
	
	@Column(name = "password", columnDefinition = "VARCHAR(64) NOT NULL")
	String password;
	
	@ManyToOne(targetEntity = ZipCode.class)
	@JoinColumn(name = "zip_code", referencedColumnName = "code")
	ZipCode zipCode;
	
} // close Customer class