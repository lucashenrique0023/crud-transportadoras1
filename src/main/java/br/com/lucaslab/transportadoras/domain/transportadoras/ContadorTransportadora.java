package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ContadorTransportadora {

	public RetornoFiltroTransportadora processar(List<Transportadora> transportadoras);

}
