package br.com.lucaslab.transportadoras.domain.empresa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import br.com.lucaslab.transportadoras.infrastructure.web.validator.UploadConstraint;
import br.com.lucaslab.transportadoras.util.FileType;
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
	
	@NotBlank(message = "O campo nome nao pode ser vazio")
	@Size(max = 80, message = "Tamanho maximo 80 caracteres.")
	private String nome;
	
	@NotBlank(message = "O campo empresa nao pode ser vazio")
	@Size(max = 80, message = "Tamanho maximo empresa 80 caracteres.")
	private String empresa;
	
	@NotBlank(message = "O campo email nao pode ser vazio")
	@Size(max = 80, message = "Tamanho maximo email 80 caracteres.")
	private String email;
	
	@Size(max = 11, message = "Tamanho maximo telefone 11 caracteres.")
	private String telefone;
	
	@Size(max = 11, message = "Tamanho maximo celular 11 caracteres.")
	private String celular;
	
	@Size(max = 11, message = "Tamanho maximo whatsapp 11 caracteres.")
	private String whatsapp;
	
	@NotNull(message = "O campo cep nao pode ser vazio")
	//@Pattern(regexp="^[0-9]{8}",message="Tamanho deve ser 8 numeros")  
	private Integer cep;
	
	@NotBlank(message = "O campo estado nao pode ser vazio")
	private String estado;
	
	@NotBlank(message = "O campo cidade nao pode ser vazio")
	@Size(max = 50, message = "Tamanho maximo cidade 50 caracteres")
	private String cidade;
	
	@NotBlank(message = "O campo bairro nao pode ser vazio")
	@Size(max = 80, message = "Tamanho maximo bairro 80 caracteres.")
	private String bairro;
	
	@NotBlank(message = "O campo rua nao pode ser vazio")
	@Size(max = 120, message = "Tamanho maximo rua 120 caracteres.")
	private String rua;
	
	@NotNull(message = "O campo numero nao pode ser vazio")
	//@Pattern(regexp="^[0-9]{3}",message="Tamanho deve ser 3 numeros") 
	private Integer numero;
	
	@Size(max = 80, message = "Tamanho maximo logotipo 80 caracteres.")
	private String logotipo;
	
	@UploadConstraint(acceptedTypes = { FileType.PNG, FileType.JPG }, message = "O arquivo nao e uma imagem valida.")
	private transient MultipartFile logotipoFile;
	
	public void setLogoTipoFileName() {
		if (getId() == null) {
			throw new IllegalStateException("E preciso primeiro gravar o registro");
		}
		
		this.logotipo = String.format("%04d-logotipo.%s", getId(), FileType.of(logotipoFile.getContentType()).getExtension());
	}

}
