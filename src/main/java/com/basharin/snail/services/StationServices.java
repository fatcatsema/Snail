package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Station;
import com.basharin.snail.repository.StationRepository;

/*
 * Class to hold methods of Station manipulation data.
 */
@Service
public class StationServices {
	
	@Autowired
	private StationRepository stationRepository;
	
	// method to retrieve a 'station' object by its name
	public Station findStationByName(String name) {
		List<Station> stations = stationRepository.findAll();
		for (Station station : stations) {
			if (station.getName().equals(name)) {
				return station;
			}
		}
		return null;
	} // close findStationByName()
	
} // close StationServices class