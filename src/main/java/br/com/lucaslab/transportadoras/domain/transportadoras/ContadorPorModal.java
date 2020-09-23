package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.lucaslab.transportadoras.domain.transportadoras.RetornoFiltroTransportadora.Item;

@Component
public class ContadorPorModal implements ContadorTransportadora {

	private static final String NOME_CONTADOR = "transportadorasModais";
	
	@Override
	public RetornoFiltroTransportadora processar(List<Transportadora> transportadoras) {

		Map<String, Integer> transportadorasUF = new HashMap<String, Integer>();
		
		for (Transportadora transportadora : transportadoras) {
			if (transportadorasUF.containsKey(transportadora.getModal().toString())) {
				transportadorasUF.put(transportadora.getModal().toString(), transportadorasUF.get(transportadora.getModal().toString()) + 1);
			} else {
				transportadorasUF.put(transportadora.getModal().toString(), 1);
			}
		} 
		
		RetornoFiltroTransportadora retorno = new RetornoFiltroTransportadora();
		retorno.setNome(NOME_CONTADOR);
		
		transportadorasUF.forEach((k, v) -> {
			retorno.getItens().add(new Item(k,v));
		});

		return retorno;
	}

}
