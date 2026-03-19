package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name= "Persons")
public class Person {

    @Id
    @Column(name = "personId")
    private Integer id;
    @NotBlank
    @Size(min = 2, max = 25, message = "The firstname has to be min 2, max 25 letters")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 25, message = "The lastname has to be min 2, max 25 letters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone number must not be blank")
    @Size(min = 14, max = 14, message = "Phone number must be in the format (000) 000-0000")
    @Pattern(regexp = "^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}$", message = "Format must be (000) 000-0000")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber.trim();
    }


    public String getFullName(){
        return firstName +" " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
            this.phoneNumber = digitsOnly;
            System.out.println("Cleaned value being stored: '" + this.phoneNumber + "'");
        } else {
            this.phoneNumber = null;
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
