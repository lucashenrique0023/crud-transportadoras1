package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lucaslab.transportadoras.domain.transportadoras.RetornoFiltroTransportadora.Item;

public class ContadorPorUF implements ContadorTransportadora {
	
	private static final String NOME_CONTADOR = "transportadorasUF";

	@Override
	public RetornoFiltroTransportadora processar(List<Transportadora> transportadoras) {
		
		Map<String, Integer> transportadorasUF = new HashMap<String, Integer>();
		
		for (Transportadora transportadora : transportadoras) {
			if (transportadorasUF.containsKey(transportadora.getEstado())) {
				transportadorasUF.put(transportadora.getEstado(), transportadorasUF.get(transportadora.getEstado()) + 1);
			} else {
				transportadorasUF.put(transportadora.getEstado(), 1);
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
