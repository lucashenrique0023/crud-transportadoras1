package br.com.lucaslab.transportadoras.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Autowired
	private ImageService imageService;

	@Transactional
	public void saveTransportadora(Transportadora transportadora) {
		
		if (transportadora.getId() != null) {
			Transportadora transportadoraDB = transportadoraRepository.findById(transportadora.getId()).orElseThrow();
			transportadora.setLogotipo(transportadoraDB.getLogotipo());
			imageService.uploadLogotipo(transportadora.getLogotipoFile(), transportadora.getLogotipo());
			transportadoraRepository.save(transportadora);
		} else {
			transportadora = transportadoraRepository.save(transportadora);
			transportadora.setLogoTipoFileName();
			imageService.uploadLogotipo(transportadora.getLogotipoFile(), transportadora.getLogotipo());
		}
	}
	
}
