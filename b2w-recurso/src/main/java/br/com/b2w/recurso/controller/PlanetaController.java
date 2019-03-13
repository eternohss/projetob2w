package br.com.b2w.recurso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.recurso.dto.PlanetaDto;
import br.com.b2w.recurso.facede.StarWarsFacede;
import br.com.b2w.recurso.model.ResponseModel;

@RestController
@RequestMapping("/service")
public class PlanetaController {
	
	@Autowired
	private StarWarsFacede StarWarsFacede;
	
		
	/**
	 * ATUALIZAR O REGISTRO DE UM Planeta
	 * @param PlanetaDto
	 * @return
	 */
	@RequestMapping(value="/planeta", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody PlanetaDto planetaDto){
 
		try {
 
			this.StarWarsFacede.save(planetaDto);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param ID
	 * @return
	 */
	@RequestMapping(value="/planeta/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
			
			StarWarsFacede.delete(id);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR TODAS AS Planetas
	 * @return
	 */
	@RequestMapping(value="/planeta", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PlanetaDto> consultar(){
 
		return this.StarWarsFacede.findAll();
	}
 
	/**
	 * CONSULTAR TODAS AS Planetas
	 * @return
	 */
	@RequestMapping(value="/planeta/api", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> consultarApi(){
 
		return this.StarWarsFacede.planetas();
	}
	
	/**
	 * BUSCAR UMA CLIENTE PELO ID
	 * @param ID
	 * @return
	 */
	@RequestMapping(value="/planeta/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PlanetaDto buscar(@PathVariable("id") Integer id){
 
		return this.StarWarsFacede.findById(id);
	}

	/**
	 * BUSCAR UMA CLIENTE PELO ID
	 * @param ID
	 * @return
	 */
	@RequestMapping(value="/planeta/nome/{nome}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PlanetaDto buscarPorNome(@PathVariable("nome") String nome){
 
		return this.StarWarsFacede.findByNome(nome);
	}

 

}
