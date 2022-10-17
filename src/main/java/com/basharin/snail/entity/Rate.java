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
@Table(name = "rate")
public class Rate implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "route", columnDefinition = "VARCHAR(6) NOT NULL UNIQUE")
	String route;
	
	@Column(name = "station_from", columnDefinition = "VARCHAR(20) NOT NULL")
	String stationFrom;
	
	@Column(name = "station_to", columnDefinition = "VARCHAR(20) NOT NULL")
	String stationTo;
	
	@Column(name = "fee_per_lb", columnDefinition = "DECIMAL(5,2) NOT NULL")
	BigDecimal feePerLb;
	
	@OneToMany(mappedBy = "rate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Cargo> cargos;
}