package com.ec.onlineplantnursery.plant.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.plant.entity.Plant;

public interface IPlantService {
	public Plant addPlant(Plant plant);

	public Plant updatePlant(Plant plant);

	public Plant deletePlant(Plant plant);

	public Plant viewPlant(int plantId);

	public Plant viewPlant(String commonName);

	public List<Plant> viewAllPlants();

	public List<Plant> viewAllPlants(String typeOfPlant);
}
