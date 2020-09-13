package br.com.lucaslab.transportadoras.infrastructure.web.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.lucaslab.transportadoras.util.FileType;


@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = UploadValidator.class)
public @interface UploadConstraint {
	
	String message() default "Arquivo Invalido";
	FileType[] acceptedTypes();
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
