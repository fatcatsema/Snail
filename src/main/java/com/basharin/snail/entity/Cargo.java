package com.basharin.snail.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cargo")
public class Cargo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "weight", columnDefinition = "DECIMAL(10,1) NOT NULL")
	BigDecimal weight;
	
	@Column(name = "price", columnDefinition = "DECIMAL(10,2) NOT NULL")
	BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route", columnDefinition = "VARCHAR(6) NOT NULL")
	Rate rate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cargo_type", columnDefinition = "VARCHAR(10) NOT NULL")
	CargoType cargoType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipping_type", columnDefinition = "VARCHAR(10) NOT NULL")
	ShippingType shippingType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cart_id", columnDefinition = "INT NOT NULL")
	ShoppingCart shoppingCart;
	
	@OneToOne(mappedBy = "cargo")
    CustomerOrder customerOrder;
}