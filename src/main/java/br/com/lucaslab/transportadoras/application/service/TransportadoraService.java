package br.com.lucaslab.transportadoras.application.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraFilter;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Autowired
	private ImageService imageService;
	
	public List<Transportadora> listarTransportadoras(TransportadoraFilter filter){
		
		String cidade = filter.getCidade() == "" ? null : filter.getCidade();
		String nome = filter.getNome() == "" || filter.getNome() == null ? "%" : "%" + filter.getNome() + "%";
		String estado = filter.getEstado() == "" ? null : filter.getEstado();
		String modal = filter.getModal() == null ? "%" : filter.getModal().toString();
		
		return transportadoraRepository.listarTransportadoras(cidade, estado, nome, modal);
	}
	

	@Transactional
	public void saveTransportadora(Transportadora transportadora) {
		
		if (!validateEmail(transportadora.getEmail(), transportadora.getId())) {
			throw new ValidationException("O e-mail esta duplicado");
		}
		
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
	
	private boolean validateEmail(String email, Integer id) {
		
		Transportadora transportadora = transportadoraRepository.findByEmail(email);
		
		if (transportadora != null) {
			if (id == null) {
				return false;
			}
			
			if (!transportadora.getId().equals(id)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
}
