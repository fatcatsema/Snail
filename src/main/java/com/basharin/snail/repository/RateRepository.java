package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Rate;


@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
	
	public Rate findByRoute(String route);
}