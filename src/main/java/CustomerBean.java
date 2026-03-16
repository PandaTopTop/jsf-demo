import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import model.Person;

import java.io.Serializable;

@Named("customerBean")
@SessionScoped
public class CustomerBean implements Serializable {
    private Person person = new Person();

    public String submitPersonDetails() {
        return "carDetails?faces-redirect=true";
    }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
