package com.basharin.snail.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "customerorder")
public class CustomerOrder implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "order_date", columnDefinition = "DATE NOT NULL")
	Date orderDate;
	
	@Column(name = "shipped_date", columnDefinition = "DATE")
	Date shippedDate;
	
	@Column(name = "arrived_date", columnDefinition = "DATE")
	Date arrivedDate;
	
	@Column(name = "received_date", columnDefinition = "DATE")
	Date receivedDate;
	
	@Column(name = "status", columnDefinition = "VARCHAR(10) NOT NULL")
	String status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id", columnDefinition = "INT NOT NULL")
    Cargo cargo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", columnDefinition = "INT NOT NULL")
	Customer customer;
}