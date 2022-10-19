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
 * POJO class of Cargo entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "weight", columnDefinition = "DECIMAL(10,1) NOT NULL")
	Double weight;
	
	@Column(name = "price", columnDefinition = "DECIMAL(10,2) NOT NULL")
	Double price;
	
	@ManyToOne(targetEntity = Rate.class)
    @JoinColumn(name = "rate", referencedColumnName = "route")
	Rate rate;
	
	@ManyToOne(targetEntity = CargoType.class)
    @JoinColumn(name = "cargo_type", referencedColumnName = "type")
	CargoType cargoType;
	
	@ManyToOne(targetEntity = ShippingType.class)
    @JoinColumn(name = "shipping_type", referencedColumnName = "type")
	ShippingType shippingType;
	
	@ManyToOne(targetEntity = ShoppingCart.class)
	@JoinColumn(name = "cart_id", referencedColumnName = "id")
	ShoppingCart shoppingCart;
	
} // close Cargo class