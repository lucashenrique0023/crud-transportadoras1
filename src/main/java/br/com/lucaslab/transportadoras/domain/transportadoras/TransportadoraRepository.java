package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer>{

	public Transportadora findByEmail(String email);
	
	@Query("SELECT COUNT(t.id), estado FROM Transportadora t WHERE t.cidade LIKE COALESCE(?1,'%') AND t.estado LIKE COALESCE(?2,'%') AND t.nome LIKE COALESCE(?3,'%')  AND t.modal LIKE COALESCE(?4,'%') GROUP BY estado ORDER BY COUNT(t.id) DESC")
	public List<Object[]> listarTransportadorasUF(String cidade, String estado, String nome, String modal);
	
	@Query("SELECT COUNT(t.id), cidade FROM Transportadora t WHERE t.cidade LIKE COALESCE(?1,'%') AND t.estado LIKE COALESCE(?2,'%') AND t.nome LIKE COALESCE(?3,'%')  AND t.modal LIKE COALESCE(?4,'%') GROUP BY cidade ORDER BY COUNT(t.id) DESC")
	public List<Object[]> listarTransportadorasCidades(String cidade, String estado, String nome, String modal);
	
	@Query("SELECT COUNT(t.id), modal FROM Transportadora t WHERE t.cidade LIKE COALESCE(?1,'%') AND t.estado LIKE COALESCE(?2,'%') AND t.nome LIKE COALESCE(?3,'%')  AND t.modal LIKE COALESCE(?4,'%') GROUP BY modal ORDER BY COUNT(t.id) DESC")
	public List<Object[]> listarTransportadorasModais(String cidade, String estado, String nome, String modal);
	
	@Query("SELECT t FROM Transportadora t WHERE t.cidade LIKE COALESCE(?1,'%') AND t.estado LIKE COALESCE(?2,'%') AND t.nome LIKE COALESCE(?3,'%')  AND t.modal LIKE COALESCE(?4,'%')")
	public List<Transportadora> listarTransportadoras(String cidade, String estado, String nome, String modal);
	
}
