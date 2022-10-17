package com.basharin.snail.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "shippingtype")
public class ShippingType implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "type", columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
	String type;
	
	@Column(name = "rate", columnDefinition = "DECIMAL(3,1) NOT NULL")
	BigDecimal rate;
	
	@OneToMany(mappedBy = "shippingType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Cargo> cargos;
}