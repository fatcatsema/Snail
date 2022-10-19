package com.basharin.snail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/*
 * POJO class of ZipCode entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "zipcode")
public class ZipCode implements Serializable {

	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "code", columnDefinition = "VARCHAR(5) NOT NULL UNIQUE")
	String code;
	
	@Column(name = "city", columnDefinition = "VARCHAR(25) NOT NULL")
	String city;
	
	@Column(name = "state", columnDefinition = "VARCHAR(25) NOT NULL")
	String state;
	
} // close ZipCode class