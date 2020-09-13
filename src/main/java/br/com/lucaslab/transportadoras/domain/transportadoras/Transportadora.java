package br.com.lucaslab.transportadoras.domain.transportadoras;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucaslab.transportadoras.domain.empresa.Empresa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "transportadora")
public class Transportadora extends Empresa {

		private Modal modal;

}
