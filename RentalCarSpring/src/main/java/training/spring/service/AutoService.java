package training.spring.service;

import java.util.List;

import training.spring.entity.Auto;

public interface AutoService {

	public List<Auto> findAllAuto();
	
	public void addAuto(Auto auto);
	
	public Auto findById(int id);
	
	public void deleteAuto(int id);
	
	public void update(Auto auto);
}
