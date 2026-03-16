import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import model.Car;

import java.io.Serializable;

@Named("vehicleBean")
@SessionScoped
public class VehicleBean implements Serializable {
    private Car car = new Car();

    public String submitCarDetails() {
        return "coverageOptions?faces-redirect=true";
    }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}