package br.com.lucaslab.transportadoras.domain.empresa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
	
	@NotNull
	@Size(max = 80)
	private String nome;
	
	@NotNull
	@Size(max = 80)
	private String empresa;
	
	@NotNull
	@Size(max = 80)
	private String email;
	
	@Size(max = 11)
	private String telefone;
	
	@Size(max = 11)
	private String celular;
	
	@Size(max = 11)
	private String whatsapp;
	
	@NotNull
	@Min(00000000)
	@Max(99999999)
	private Integer cep;
	
	@NotNull
	@Size(max = 50)
	private String cidade;
	
	@NotNull
	@Size(max = 80)
	private String bairro;
	
	@NotNull
	@Size(max = 120)
	private String rua;
	
	@NotNull
	@Min(0)
	@Max(999)
	private Integer numero;

}
