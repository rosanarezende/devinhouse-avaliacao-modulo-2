package br.com.devinhouse.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jdi.Method;

import br.com.devinhouse.springboot.dto.ProcessoDTO;
import br.com.devinhouse.springboot.repository.ProcessoRepository;

import javassist.NotFoundException;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repository;
	
	public List<ProcessoDTO> recuperarTodosProcessos(){
		return repository.listarTodosProcessos();
	}
	
	public ProcessoDTO recuperarProcessosPorId(Integer id) throws NotFoundException {
		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		for (ProcessoDTO processo : todosProcessos) {
			if(id.equals(processo.getId())) {
				return processo;
			}
		}
		throw new NotFoundException("Não foi encontrado processo com ID '" + id + "'.");
	}
	
	
	// ================================= NÃO FUNCIONA =================================
	public List<ProcessoDTO> cadastrarProcesso(ProcessoDTO processo) throws NotFoundException {
		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		ProcessoDTO processoEncontrado = recuperarProcessosPorId(processo.getId());		
		if(processoEncontrado == null) {
			todosProcessos.add(processo);
			return todosProcessos;
		}
		throw new NotFoundException("Não foi possível cadastrar processo com ID '" + processo.getId() + " pois já existe no banco de dados'.");
	}
	
	public ProcessoDTO atualizarProcesso(Integer id, ProcessoDTO novasInfos) throws NotFoundException{
		ProcessoDTO processoEncontrado = recuperarProcessosPorId(id);
		
		if(processoEncontrado != null) {
			if(novasInfos.getId() != null) {
				processoEncontrado.setId(novasInfos.getId());
			}
			if (novasInfos.getCdAssunto() != null) {
				processoEncontrado.setCdAssunto(novasInfos.getCdAssunto());
			}
			if (novasInfos.getCdInteressado() != null) {
				processoEncontrado.setCdInteressado(novasInfos.getCdInteressado());
			}
			if (novasInfos.getDescricao() != null) {
				processoEncontrado.setDescricao(novasInfos.getDescricao());
			}
			if (novasInfos.getDescricaoAssunto() != null) {
				processoEncontrado.setDescricaoAssunto(novasInfos.getDescricaoAssunto());
			}
			if (novasInfos.getNmInteressado() != null) {
				processoEncontrado.setNmInteressado(novasInfos.getNmInteressado());
			}
			if (novasInfos.getNuAnoProcesso() != null) {
				processoEncontrado.setNuAnoProcesso(novasInfos.getNuAnoProcesso());
			}
			if (novasInfos.getNuProcesso() != null) {
				processoEncontrado.setNuProcesso(novasInfos.getNuProcesso());
			}
			if (novasInfos.getSgOrgaoProcesso() != null) {
				processoEncontrado.setSgOrgaoProcesso(novasInfos.getSgOrgaoProcesso());
			}
			if (novasInfos.getChaveProcesso() != null) {
				processoEncontrado.setChaveProcesso(novasInfos.getChaveProcesso());
			}
			return processoEncontrado;
		}
		
		throw new NotFoundException("Não existe processo com ID '" + id + "'.");	
	}
	
	public ProcessoDTO recuperarProcessosPorChave(String chaveProcesso) throws NotFoundException {
		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		for (ProcessoDTO processo : todosProcessos) {
			if(chaveProcesso.equals(processo.getChaveProcesso())) {
				return processo;
			}
		}
		throw new NotFoundException("Não foi encontrado processo com chave '" + chaveProcesso + "'.");
	}
	
	
	// ================================= NÃO FUNCIONA =================================
	public List<ProcessoDTO> deletarProcessoPorId(Integer id) throws NotFoundException{
		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		ProcessoDTO processoEncontrado = recuperarProcessosPorId(id);
		if(processoEncontrado != null) {
			todosProcessos.remove(processoEncontrado);
			return todosProcessos;			
		}
		throw new NotFoundException("Não foi encontrado processo com ID '" + id + "'.");
	}
}
