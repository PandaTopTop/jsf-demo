import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import model.Car;

import java.io.Serializable;
import java.util.List;

@Named("cars")
@ViewScoped
public class CarsBean implements Serializable {

    private final List<Car> carList = List.of(
            new Car("Ford","Focus","2009"),
            new Car("Chevrolet","Corvette","2003"),
            new Car("Volvo","CX90","2025")
    );


    public List<Car> getCarList() {
        return carList;
    }
}
