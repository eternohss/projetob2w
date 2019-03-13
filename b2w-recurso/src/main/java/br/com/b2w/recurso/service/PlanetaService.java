package br.com.b2w.recurso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.recurso.model.Planeta;
import br.com.b2w.recurso.repository.PlanetaRepository;

@Service
public class PlanetaService {
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	public void save(Planeta planeta){
		planetaRepository.save(planeta);
	}

	public void delete(Integer id){
		Planeta planeta = planetaRepository.findById(id);
		planetaRepository.delete(planeta);
	}

	public List<Planeta> findAll(){
		return planetaRepository.findAll();
	}

	public Planeta findId(Integer id){
		
		Planeta planeta = planetaRepository.findById(id);
		
		return planeta;
	}
	
	public Planeta findByNome(String nome){
		
		Planeta planeta = planetaRepository.findByNome(nome);
		
		return planeta;
	}
	

}
