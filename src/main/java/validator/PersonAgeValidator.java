package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.time.LocalDate;
import java.time.Period;
@FacesValidator("ageValidator")
public class PersonAgeValidator implements Validator<LocalDate> {
    @Override
    public void validate(FacesContext facesContext,
                         UIComponent uiComponent,
                         LocalDate val) throws ValidatorException {
        if(val== null)
            throw new ValidatorException(new FacesMessage("The date of birth has to be provided"));

        LocalDate nowDate = LocalDate.now();
        if (Period.between(val, nowDate).getYears() < 18) {
            throw new ValidatorException(new FacesMessage("The age has to be at least 18 years"));
        }
    }
}
