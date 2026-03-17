import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import model.Person;

import java.io.Serializable;
import java.time.LocalDate;
@Named("person")
@ViewScoped
public class PersonBean implements Serializable {
    private final  Person person = new Person("Vadym","Iharov",
            LocalDate.of(2002,1,4),"+38044044013");

    public Person getPerson() {
        return person;
    }

    public String getFirstName() {
        return person.getFirstName();
    }

    public String getLastName() {
        return person.getLastName();
    }

    public LocalDate getDateOfBirth() {
        return person.getDateOfBirth();
    }

    public String getPhone() {
        return person.getPhoneNumber();
    }

}
