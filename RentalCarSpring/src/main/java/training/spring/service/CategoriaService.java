package training.spring.service;

import java.util.List;

import training.spring.entity.Categoria;

public interface CategoriaService {

	public List<Categoria> findAllCategoria();
	
	public Categoria findById(int id);
}
