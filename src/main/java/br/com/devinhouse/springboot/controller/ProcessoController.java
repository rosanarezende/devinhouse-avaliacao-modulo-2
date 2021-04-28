package br.com.devinhouse.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import br.com.devinhouse.springboot.dto.ProcessoDTO;
import br.com.devinhouse.springboot.service.ProcessoService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/processo")
public class ProcessoController {
	
	@Autowired
	private ProcessoService service;
	
	// ================================= NÃO FUNCIONA =================================
	//	1 - Deverá haver um endpoint para criação de um processo;
	//		{
	//	        "id": 50,
	//	        "cdAssunto": 50,
	//	        "cdInteressado": 50,
	//	        "descricao": "Processo 50de testes DEV In House ",
	//	        "descricaoAssunto": "Assunto 50 de testes DEV In House ",
	//	        "nmInteressado": "Jão Antonio ::: 49",
	//	        "nuAnoProcesso": "2020",
	//	        "nuProcesso": 50,
	//	        "sgOrgaoProcesso": "SOFT",
	//	        "chaveProcesso": "SOFT 50/2020"
	//	    }
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/cadastrar", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> cadastrarProcesso(@RequestBody ProcessoDTO processo ) {
		try {
			return service.cadastrarProcesso(processo);
		} catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
	}
	
	//	2 - Deverá haver um endpoint para listagem de todos os processos, retornando todos os atributos de cada processo;
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/listar-todos", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> listarTodosProcessos() {
		return service.recuperarTodosProcessos();
	}
		
	
	//	3 - Deverá haver um endpoint para buscar um processo baseado na sua identificação única (id);
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/listar-id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO listarProcessoPorId(@PathVariable Integer id) {
		try {
			return service.recuperarProcessosPorId(id);
		} catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
	}
		
	//	4 - Deverá haver um endpoint para buscar um processo baseado no seu número de processo (chaveProcesso);
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/listar-chave", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO listarProcessoPorChave(@RequestParam(name = "chaveProcesso") String chaveProcesso) {
		try {
			return service.recuperarProcessosPorChave(chaveProcesso);
		} catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
	}
		
	//	5 - Deverá haver um endpoint para atualização de todos os atributos de um processo baseado na sua identificação única (id);
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/atualizar/{id}", method = PUT , consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO atualizarInformacoesProcesso(@PathVariable Integer id, @RequestBody ProcessoDTO novasInfos) {
		try {
			return service.atualizarProcesso(id, novasInfos);			
		} catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
	}
	
	
	// ================================= NÃO FUNCIONA =================================
	//	6 - Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (id);
	@RequestMapping(headers = "api-version=v1", value= "v1" + "/deletar/{id}", method = DELETE , produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> deletarProcesso(@PathVariable Integer id) {
		try {
			return service.deletarProcessoPorId(id);			
		} catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
	}	
}
