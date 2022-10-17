package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Station;


@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
	
	public Station findByName(String name);
}