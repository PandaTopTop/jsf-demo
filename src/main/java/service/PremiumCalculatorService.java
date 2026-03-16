package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import model.Car;
import model.CoverageItem;
import model.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Named("premiumCalculatorService")
@ApplicationScoped
public class PremiumCalculatorService {

    public BigDecimal calculatePremium(Person customer, Car vehicle, List<CoverageItem> selectedCoverages) {
        BigDecimal totalPremium = selectedCoverages.stream()
                .map(CoverageItem::getPremium)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (customer != null && customer.getDateOfBirth() != null) {
            int age = Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears();
            if (age < 25) {
                totalPremium = totalPremium.add(new BigDecimal("150.00"));
            }
        }

        return totalPremium.setScale(2,
                RoundingMode.HALF_UP);
    }
}
