package br.com.b2w.recurso.facede;

import java.util.List;

import br.com.b2w.recurso.dto.PlanetaDto;

public interface StarWarsFacede {
	
	public void save(PlanetaDto planetaDto);

	public void delete(Integer id);
	
	public List<PlanetaDto> findAll();

	public List<String> planetas();
	
	PlanetaDto findById(Integer id);
	
	PlanetaDto findByNome(String nome);
	
}
