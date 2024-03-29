package prueba.validaciones;

import java.util.regex.Pattern;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("vstock")


public class ValidacionStock implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

		String nombre = o.toString(); //permite quitar los espacios del caracter que pasa
		
		if(nombre.length()==0) {
			throw new ValidatorException(new FacesMessage ("Ingrese el Stock"));
	
		}else {
			
			String exNombre="[1-9]*";
			boolean estaBien=Pattern.matches(exNombre, nombre);
			
			if(!estaBien) {
				
				throw new ValidatorException(new FacesMessage("Ingrese solo numeros"));
				
			}	
		}
	}
	
	
	

}
