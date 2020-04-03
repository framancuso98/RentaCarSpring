package training.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.spring.dao.AutoDAO;
import training.spring.entity.Auto;
@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	AutoDAO autoDAO;

	@Override
	public List<Auto> findAllAuto() {
		return autoDAO.findAllAuto();
	}

	@Override
	public void addAuto(Auto auto) {
		autoDAO.addAuto(auto);
		
	}

	@Override
	public Auto findById(int id) {
		return autoDAO.findById(id);
	}

	@Override
	public void deleteAuto(int id) {
		autoDAO.deleteAuto(id);
	}

	@Override
	public void update(Auto auto) {
		autoDAO.update(auto);
	}
}
