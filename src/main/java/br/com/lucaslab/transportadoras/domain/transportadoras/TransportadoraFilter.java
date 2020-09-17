package br.com.lucaslab.transportadoras.domain.transportadoras;

import lombok.Data;

@Data
public class TransportadoraFilter {

	private String nome;
	private String cidade;
	private Modal modal;
	private String estado;

}
