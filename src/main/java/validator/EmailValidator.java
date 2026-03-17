package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String s) throws ValidatorException {

        if(s==null) throw new ValidatorException(new FacesMessage("The email has to be provided"));
        if(s.trim().endsWith(".ru") || s.trim().endsWith(".cu") || s.trim().endsWith(".ir"))
            throw new ValidatorException(
                    new FacesMessage("The email addresses from Russia, Cuba and Iran are forbidden."));
    }
}
