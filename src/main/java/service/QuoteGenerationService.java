package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import model.CoverageItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named("quoteGenerationService")
@ApplicationScoped
public class QuoteGenerationService {

    public List<CoverageItem> generateDefaultCoverages() {
        List<CoverageItem> coverageItemList = new ArrayList<>();

        coverageItemList.add(new CoverageItem(
                "Bodily Injury",
                "Covers costs if you injure someone in an accident.",
                new BigDecimal("20000"),
                new BigDecimal("215.50"),
                true
        ));

        coverageItemList.add(new CoverageItem(
                "Property Damage",
                "Covers costs if you damage someone else's property.",
                new BigDecimal("50000"),
                new BigDecimal("180.00"),
                true
        ));

        coverageItemList.add(new CoverageItem(
                "Towing and Storage",
                "Covers towing and labor costs if your car is disabled.",
                new BigDecimal("2000"),
                new BigDecimal("35.00"),
                true
        ));

        coverageItemList.add(new CoverageItem(
                "Medical Payments",
                "Covers medical expenses for you and your passengers.",
                new BigDecimal("5000"),
                new BigDecimal("65.25"),
                true
        ));

        return coverageItemList;
    }
}
