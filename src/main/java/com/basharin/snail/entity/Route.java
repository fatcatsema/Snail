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
 * POJO class of Rate entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "route")
public class Route implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "code", columnDefinition = "VARCHAR(6) NOT NULL")
	String code;
	
	@Column(name = "station_from", columnDefinition = "VARCHAR(20) NOT NULL")
	String stationFrom;
	
	@Column(name = "station_to", columnDefinition = "VARCHAR(20) NOT NULL")
	String stationTo;
	
	@Column(name = "fee_per_lb", columnDefinition = "DECIMAL(5,2) NOT NULL")
	Double feePerLb;
	
	@Column(name = "delivery_time", columnDefinition = "INTEGER(2) NOT NULL")
	Integer deliveryTime;
	
} // close Rate class