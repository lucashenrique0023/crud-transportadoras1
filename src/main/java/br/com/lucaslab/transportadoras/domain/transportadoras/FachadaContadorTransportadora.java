package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class FachadaContadorTransportadora {

	private List<ContadorTransportadora> itens = new ArrayList<ContadorTransportadora>();
	
	private void load() {
		itens.add(new ContadorPorCidade());
		itens.add(new ContadorPorUF());
		itens.add(new ContadorPorModal());
	}
	
	public FachadaContadorTransportadora() {
		this.load();
	}

}
