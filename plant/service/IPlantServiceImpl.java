package com.ec.onlineplantnursery.plant.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.plant.repository.PlantRepository;

@Service
public class IPlantServiceImpl implements IPlantService{

	@Autowired
	private PlantRepository repo;
	
	@Transactional
	@Override
	public Plant addPlant(Plant plant) {
		repo.save(plant);
		return plant;
	}

	public IPlantServiceImpl(PlantRepository repo) {
		super();
		this.repo = repo;
	}

	public IPlantServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plant updatePlant(Plant plant) {
		Plant existingPlant = repo.findById(plant.getPlantId()).orElse(null);
        existingPlant.setPlantId(plant.getPlantId());
        existingPlant.setPlantCost(plant.getPlantCost());
        existingPlant.setPlantDescription(plant.getPlantDescription());
        existingPlant.setPlantHeight(plant.getPlantHeight());
        existingPlant.setPlantSpread(plant.getPlantSpread());
        existingPlant.setPlantsStock(plant.getPlantsStock());
        existingPlant.setTypeOfPlant(plant.getTypeOfPlant());
        existingPlant.setBloomTime(plant.getBloomTime());
        existingPlant.setCommonName(plant.getCommonName());
        existingPlant.setDifficultyLevel(plant.getDifficultyLevel());
        existingPlant.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
        existingPlant.setTemparature(plant.getTemparature());
       
		return repo.save(existingPlant);
	}

	@Override
	public Plant deletePlant(Plant plant) {
		repo.delete(plant);	
		return plant;
	}

	@Override
	public Plant viewPlant(int plantId) {
		
		return repo.findById(plantId).get();
	}

//---------------------------------------------------------------------
	@Override
	public Plant viewPlant(String commonName) {
		
		
		return repo.viewPlant(commonName);
	}
//-------------------------------------------------------------------------
	@Override
	public List<Plant> viewAllPlants() {
		
		return repo.findAll();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {

		
		return repo.viewAllPlants(typeOfPlant);
	}

}












