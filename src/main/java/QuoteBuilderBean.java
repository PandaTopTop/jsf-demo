import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.CoverageItem;
import service.PremiumCalculatorService;
import service.QuoteGenerationService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Named("quoteBuilderBean")
@SessionScoped
public class QuoteBuilderBean implements Serializable {

    @Inject private CustomerBean customerBean;
    @Inject private VehicleBean vehicleBean;
    @Inject private QuoteGenerationService quoteGenerationService;
    @Inject private PremiumCalculatorService premiumCalculatorService;

    // These lists now hold your specific CoverageItem object
    private List<CoverageItem> availableCoverages;
    private List<CoverageItem> selectedCoverages;
    private BigDecimal totalPremium;

    private boolean hasPrivilege;
    private String privilegeDetails;

    @PostConstruct
    public void init() {
        selectedCoverages = new ArrayList<>();
        availableCoverages = quoteGenerationService.generateDefaultCoverages();
        recalculatePremium();
    }

    public void addCoverage(CoverageItem coverageToAdd) {
        selectedCoverages.add(coverageToAdd);
        availableCoverages.remove(coverageToAdd);
        recalculatePremium();
    }

    public void removeCoverage(CoverageItem coverageToRemove) {
        availableCoverages.add(coverageToRemove);
        selectedCoverages.remove(coverageToRemove);
        recalculatePremium();
    }

    public void recalculatePremium() {
        this.totalPremium = premiumCalculatorService.calculatePremium(
                customerBean.getPerson(),
                vehicleBean.getCar(),
                this.selectedCoverages
        );
    }

    public String confirmQuote() {
        recalculatePremium();
        return "quoteSummary?faces-redirect=true";
    }

    public List<CoverageItem> getAvailableCoverages() { return availableCoverages; }
    public void setAvailableCoverages(List<CoverageItem> availableCoverages) { this.availableCoverages = availableCoverages; }
    public List<CoverageItem> getSelectedCoverages() { return selectedCoverages; }
    public void setSelectedCoverages(List<CoverageItem> selectedCoverages) { this.selectedCoverages = selectedCoverages; }
    public BigDecimal getTotalPremium() { return totalPremium; }
    public void setTotalPremium(BigDecimal totalPremium) { this.totalPremium = totalPremium; }

    public boolean isHasPrivilege() {
        return hasPrivilege;
    }

    public void setHasPrivilege(boolean hasPrivilege) {
        this.hasPrivilege = hasPrivilege;
    }

    public String getPrivilegeDetails() {
        return privilegeDetails;
    }

    public void setPrivilegeDetails(String privilegeDetails) {
        this.privilegeDetails = privilegeDetails;
    }
}
