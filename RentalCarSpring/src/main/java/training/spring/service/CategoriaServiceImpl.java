package training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.spring.dao.CategoriaDAO;
import training.spring.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	
	@Autowired 
	CategoriaDAO categoriaDAO;
	@Override
	public List<Categoria> findAllCategoria() {
		return categoriaDAO.findAllCategorie();
	}
	@Override
	public Categoria findById(int id) {
		return categoriaDAO.findById(id);
	}
	
	

}
