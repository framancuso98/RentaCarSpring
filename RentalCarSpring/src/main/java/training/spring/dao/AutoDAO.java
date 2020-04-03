package training.spring.dao;

import java.util.List;

import training.spring.entity.Auto;

public interface AutoDAO {

	public List<Auto> findAllAuto();
	
	public void addAuto(Auto auto);
	
	public Auto findById(int id);
	
	public void deleteAuto(int id);
	
	public void update(Auto auto);
}
