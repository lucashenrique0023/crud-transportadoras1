package br.com.lucaslab.transportadoras.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;

	public void saveTransportadora(Transportadora transportadora) {
		
		transportadoraRepository.save(transportadora);
		
	}
	
}
