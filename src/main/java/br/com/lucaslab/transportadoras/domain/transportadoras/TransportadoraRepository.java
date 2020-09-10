package br.com.lucaslab.transportadoras.domain.transportadoras;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer>{

	public Transportadora findByEmail(String email);

}
