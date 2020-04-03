package training.spring.dao;

import java.util.List;

import training.spring.entity.Categoria;

public interface CategoriaDAO {
	
	public List<Categoria> findAllCategorie();
	
	public Categoria findById(int id);
}
