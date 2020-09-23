package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.lucaslab.transportadoras.domain.transportadoras.RetornoFiltroTransportadora.Item;

@Component
public class ContadorPorCidade implements ContadorTransportadora {
	
	private static final String NOME_CONTADOR = "transportadorasCidades";

	@Override
	public RetornoFiltroTransportadora processar(List<Transportadora> transportadoras) {

		Map<String, Integer> transportadorasUF = new HashMap<String, Integer>();
		
		for (Transportadora transportadora : transportadoras) {
			if (transportadorasUF.containsKey(transportadora.getCidade())) {
				transportadorasUF.put(transportadora.getCidade(), transportadorasUF.get(transportadora.getCidade()) + 1);
			} else {
				transportadorasUF.put(transportadora.getCidade(), 1);
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
