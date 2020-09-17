package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer>{

	public Transportadora findByEmail(String email);
	
	@Query("SELECT COUNT(t.id), estado FROM Transportadora t GROUP BY estado ORDER BY COUNT(t.id) DESC")
	public List<Object[]> findTransportadorasUF();
	
	@Query("SELECT COUNT(t.id), cidade FROM Transportadora t GROUP BY cidade ORDER BY COUNT(t.id) DESC")
	public List<Object[]> findTransportadorasCidades();
	
	@Query("SELECT COUNT(t.id), modal FROM Transportadora t GROUP BY modal ORDER BY COUNT(t.id) DESC")
	public List<Object[]> findTransportadorasModais();
	
	@Query("SELECT t FROM Transportadora t WHERE t.cidade LIKE ?1 AND t.estado LIKE ?2 AND t.nome LIKE ?3")
	public List<Transportadora> listarTransportadoras(String cidade, String estado, String nome);
	
}
