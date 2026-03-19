import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Person;
import repository.PersonRepository;

import java.io.Serializable;
import java.util.Optional;

@Named("customerDbBean")
@ViewScoped
public class CustomerFromDBBean implements Serializable {

    @Inject
    private PersonRepository personRepository;

    private String id;

    // 2. Property to hold the result of the database lookup
    private Person person;


    public void loadPerson() {
        if (id != null && !id.trim().isEmpty()) {
            Optional<Person> optionalPerson = personRepository.getPersonById(Integer.valueOf(id));
            this.person = optionalPerson.orElse(null);
        }
    }

    // --- Standard Getters and Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
}
