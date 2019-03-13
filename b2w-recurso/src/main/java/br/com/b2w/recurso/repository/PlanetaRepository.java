package br.com.b2w.recurso.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.b2w.recurso.model.Planeta;

public interface PlanetaRepository extends Repository<Planeta, Integer> {

	void save(Planeta planeta);

	void delete(Planeta planeta);

	List<Planeta> findAll();

	Planeta findById(Integer id);
	
	Planeta findByNome(String nome);
}
