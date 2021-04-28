package br.com.devinhouse.springboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.springboot.mock.ProcessoMock;
import br.com.devinhouse.springboot.dto.ProcessoDTO;

@Repository
public class ProcessoRepository {
	
	@Autowired
	private ProcessoMock mock;

	public List<ProcessoDTO> listarTodosProcessos() {
		return mock.getAllProcessos();
	}

}
