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
 * POJO class of Station entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "station")
public class Station implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "code", columnDefinition = "VARCHAR(3) NOT NULL UNIQUE")
	String code;
	
	@Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
	String name;
	
	@Column(name = "address", columnDefinition = "VARCHAR(50) NOT NULL")
	String address;
	
	@ManyToOne(targetEntity = ZipCode.class)
    @JoinColumn(name = "zip_code", referencedColumnName = "code")
	ZipCode zipCode;
	
} // close Station class