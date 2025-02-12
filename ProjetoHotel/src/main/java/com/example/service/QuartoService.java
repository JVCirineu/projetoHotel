package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Quarto;
import com.example.repository.QuartoRepository;

@Service
public class QuartoService {

	private final QuartoRepository quartoRepository;

	@Autowired
	public QuartoService(QuartoRepository quartoRepository) {
		this.quartoRepository = quartoRepository;
	}
	
	public List<Quarto> buscaTodosQuartos(){
		return quartoRepository.findAll();
	}
	
	public Quarto buscaQuartoId(Long id) {
		Optional <Quarto> Quarto = quartoRepository.findById(id);
		return Quarto.orElse(null);
	}
	
	public Quarto salvaQuarto(Quarto quarto) {
		return quartoRepository.save(quarto);		
	}
	
	public Quarto alterarQuarto(Long id, Quarto alterarQuarto) {
		Optional <Quarto> existeQuarto = quartoRepository.findById(id);
		if (existeQuarto.isPresent()) {
			alterarQuarto.setId(id);;
			return quartoRepository.save(alterarQuarto);
		}
		return null;
	}
	public boolean apagarQuarto(Long id) {
		Optional <Quarto> existeQuarto = quartoRepository.findById(id);
		if (existeQuarto.isPresent()) {
			quartoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
