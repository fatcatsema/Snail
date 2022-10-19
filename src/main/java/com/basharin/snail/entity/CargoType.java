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
 * POJO class of CargoType entity.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cargotype")
public class CargoType implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "type", columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
	String type;
	
	@Column(name = "rate", columnDefinition = "DECIMAL(3,1) NOT NULL")
	Double rate;

	@Override
	public String toString() {
		return "CargoType [id=" + id + ", type=" + type + ", rate=" + rate + "]";
	}
	
} // close CargoType class