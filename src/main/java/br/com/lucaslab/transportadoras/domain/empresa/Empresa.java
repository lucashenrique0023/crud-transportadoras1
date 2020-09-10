package br.com.lucaslab.transportadoras.domain.empresa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Empresa implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max = 80)
	private String nome;
	
	@Size(max = 80)
	private String empresa;
	
	@Size(max = 80)
	private String email;
	
	@Size(max = 11)
	private String telefone;
	
	@Size(max = 11)
	private String celular;
	
	@Size(max = 11)
	private String whatsapp;
	
	@Size(max = 8)
	private Integer cep;
	
	@Size(max = 50)
	private String cidade;
	
	@Size(max = 80)
	private String bairro;
	
	@Size(max = 120)
	private String rua;
	
	@Size(max = 5)
	private Integer numero;

}
