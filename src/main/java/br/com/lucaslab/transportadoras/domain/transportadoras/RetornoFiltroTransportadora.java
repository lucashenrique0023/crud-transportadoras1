package br.com.lucaslab.transportadoras.domain.transportadoras;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornoFiltroTransportadora {

	private String nome;
	private List<Item> itens = new ArrayList<Item>();

	
	@Getter
	@Setter
	@AllArgsConstructor
	public static class Item {
		
		private String nome;
		private Integer quantidade;
		
	}
}
