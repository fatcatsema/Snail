package com.basharin.snail.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/*
 * POJO class of ShippingType entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shippingtype")
public class ShippingType implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "type", columnDefinition = "VARCHAR(10) NOT NULL")
	String type;
	
	@Column(name = "rate", columnDefinition = "DECIMAL(3,1) NOT NULL")
	Double rate;
	
} // close ShippingType class