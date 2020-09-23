package br.com.lucaslab.transportadoras.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.lucaslab.transportadoras.domain.transportadoras.Modal;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@DataJpaTest
@ActiveProfiles("test")
class TransportadoraRepositoryTests {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;

	@Test
	void testInsertAndDelete()  throws Exception {
		
			Transportadora t1 = new Transportadora();
			t1.setCep(63273454);
			t1.setNome("Transp 1");
			t1.setNumero(123);
			t1.setModal(Modal.Aereo);
			t1.setEmail("a@a.com");
			t1.setCidade("cidade");
			t1.setRua("rua");
			t1.setBairro("bairro");
			t1.setEstado("estado");
			t1.setEmpresa("empresa");
			
			
			transportadoraRepository.saveAndFlush(t1);
			
			// Testa se esta inserindo
			assertThat(t1.getId()).isNotNull();
			
			Transportadora t2 = transportadoraRepository.findById(t1.getId()).orElseThrow();
			
			// Confirma os dados de t1
			assertThat(t1.getNome()).isEqualTo(t2.getNome());
			
			// Testa se a quantidade de dados esta batendo com a de teste.
			assertThat(transportadoraRepository.findAll()).hasSize(1);
			
			transportadoraRepository.delete(t2);
			
			// Testa se a remocao esta funcionando
			assertThat(transportadoraRepository.findAll()).hasSize(0);
			
		
	}

}
