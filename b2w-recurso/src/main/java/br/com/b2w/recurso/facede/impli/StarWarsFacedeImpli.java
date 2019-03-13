package br.com.b2w.recurso.facede.impli;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import br.com.b2w.recurso.dto.PlanetaDto;
import br.com.b2w.recurso.facede.StarWarsFacede;
import br.com.b2w.recurso.model.Planeta;
import br.com.b2w.recurso.service.PlanetaService;
import br.com.b2w.recurso.service.SwapiService;

@Component
public class StarWarsFacedeImpli implements StarWarsFacede{

	@Autowired
	private SwapiService swapiService;
	
	@Autowired
	private PlanetaService planetaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void save(PlanetaDto planetaDto) {

		int quantidadeAparicao = swapiService.quantidadeAparicao(planetaDto.getNome());
		
		Planeta planeta = this.convertToEntity(planetaDto);
		
		planeta.setQuantidadeAparicoes(quantidadeAparicao);
		
		planetaService.save(planeta);
		
	}

	@Override
	public void delete(Integer id) {
		planetaService.delete(id);
		
	}

	@Override
	public List<PlanetaDto> findAll() {
		List<Planeta> planetas = planetaService.findAll();
		
		List<PlanetaDto> planetaDtos = new ArrayList<>();
		for (Planeta planeta : planetas) {
			PlanetaDto planetaDto = this.convertToDto(planeta);
			planetaDtos.add(planetaDto);
		}
		
		return planetaDtos;
	}

	@Override
	public PlanetaDto findById(Integer id) {
		
		Planeta planeta = planetaService.findId(id);
		
		PlanetaDto planetaDto = this.convertToDto(planeta);
		
		return planetaDto;
	}

	@Override
	public List<String> planetas() {
		
		List<String> listaPlanetas = swapiService.listaPlanetas();
		
		return listaPlanetas;
	}
	
	@Override
	public PlanetaDto findByNome(String nome) {
		
		Planeta planeta = planetaService.findByNome(nome);
		
		PlanetaDto planetaDto = this.convertToDto(planeta);
		
		return planetaDto;
	}

    private PlanetaDto convertToDto(Planeta planeta) {
    	PlanetaDto planetaDto = modelMapper.map(planeta, PlanetaDto.class);
        return planetaDto;
    }
    
    private Planeta convertToEntity(PlanetaDto planetaDto) throws ParseException {
    	Planeta planeta = modelMapper.map(planetaDto, Planeta.class);
        return planeta;
    }



}
