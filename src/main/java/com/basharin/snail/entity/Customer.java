package com.basharin.snail.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
//	@Column(name = "zip_code", columnDefinition = "VARCHAR(5) NOT NULL")
//	String zipCode;
	
	@Column(name = "phone", columnDefinition = "VARCHAR(13) NOT NULL")
	String phone;
	
	@Column(name = "email", columnDefinition = "VARCHAR(25) NOT NULL UNIQUE")
	String email;
	
//	@Column(name = "password", columnDefinition = "VARCHAR(15) NOT NULL")
//	String password;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "zip_code", columnDefinition = "VARCHAR(5) NOT NULL")
	ZipCode zipCode;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<CustomerOrder> customerOrders;
	
	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	ShoppingCart shoppingCart;
}