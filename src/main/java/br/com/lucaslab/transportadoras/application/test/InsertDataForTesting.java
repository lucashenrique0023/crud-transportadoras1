package br.com.lucaslab.transportadoras.application.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.lucaslab.transportadoras.domain.transportadoras.Modal;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Component
public class InsertDataForTesting {


	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Transportadora t = new Transportadora();
		
		t.setNome("GOL Linhas Aereas");
		t.setEmpresa("GOL");
		t.setEmail("voe@gol.com.br");
		t.setTelefone("81993847586");
		t.setCelular("82885869685");
		t.setWhatsapp("38478374857");
		t.setCep(45434568);
		t.setCidade("Recife");
		t.setBairro("Imbiribeira");	
		t.setRua("Rua Imbiribeira");
		t.setNumero(347);
		t.setModal(Modal.Aereo);
		
		transportadoraRepository.save(t);
		
		t = new Transportadora();
		t.setNome("Azul Linhas Aereas");
		t.setEmpresa("Azul");
		t.setEmail("voe@azul.com.br");
		t.setTelefone("81995557586");
		t.setCelular("82885555685");
		t.setWhatsapp("38475554857");
		t.setCep(3454567);
		t.setCidade("Sao Paulo");
		t.setBairro("Sao Paulo");	
		t.setRua("Rua Florenca");
		t.setNumero(574);
		t.setModal(Modal.Aereo);
		
		transportadoraRepository.save(t);
		
		t = new Transportadora();
		t.setNome("Metrorec");
		t.setEmpresa("Metro Recife");
		t.setEmail("metrorec@metrorec.com.br");
		t.setTelefone("81996667586");
		t.setCelular("82885666685");
		t.setWhatsapp("38476664857");
		t.setCep(45345675);
		t.setCidade("Recife");
		t.setBairro("Boa Vista");	
		t.setRua("Rua Boa Vista");
		t.setNumero(231);
		t.setModal(Modal.Rodoviario);
		
		transportadoraRepository.save(t);
		
		t = new Transportadora();
		t.setNome("Noth Star Shipping");
		t.setEmpresa("North Star");
		t.setEmail("northstar@northstar.com.br");
		t.setTelefone("81994237586");
		t.setCelular("82883426685");
		t.setWhatsapp("38422164857");
		t.setCep(34565678);
		t.setCidade("Fortaleza");
		t.setBairro("Fortaleza");	
		t.setRua("Rua Osvaldo Cruz");
		t.setNumero(345);
		t.setModal(Modal.Aquaviario);
		
		transportadoraRepository.save(t);
		
		t = new Transportadora();
		t.setNome("Bahia Marine");
		t.setEmpresa("Bahia Marine");
		t.setEmail("bahiamarine@bahiamarine.com.br");
		t.setTelefone("81454586");
		t.setCelular("8285436685");
		t.setWhatsapp("3844564857");
		t.setCep(34565678);
		t.setCidade("Bahia");
		t.setBairro("Vila Carneiro");	
		t.setRua("Rua Biongo");
		t.setNumero(567);
		t.setModal(Modal.Aquaviario);
		
		transportadoraRepository.save(t);
	}

}
