import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.CoverageItem;
import repository.CoverageItemRepository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named("coverageBean")
@ViewScoped
public class CoverageBean implements Serializable {

    @Inject
    private CoverageItemRepository coverageItemRepository;

    private Integer filterId;
    private String filterName;
    private BigDecimal filterMinLimit;
    private BigDecimal filterMaxLimit;
    private BigDecimal filterMinPremium;
    private BigDecimal filterMaxPremium;
    private Boolean filterActive;

    private List<CoverageItem> foundCoveragesList;
    private CoverageItem selectedItem = new CoverageItem();
    @PostConstruct
    public void init() {
        // This runs automatically when the page is first opened
        searchCoveragesWithFilter();
    }

    public void prepareNew() {
        this.selectedItem = new CoverageItem(); // Reset for "Add" dialog
    }

    public void save() {
        coverageItemRepository.save(selectedItem);
        searchCoveragesWithFilter(); // Refresh table
        selectedItem = new CoverageItem(); // Reset
    }

    public void delete(Integer id) {
        coverageItemRepository.delete(id);
        searchCoveragesWithFilter(); // Refresh table
    }
    public void searchCoveragesWithFilter(){
        this.foundCoveragesList = coverageItemRepository.findCoveragesWithFilter(filterId,
                filterName,
                filterMinLimit,
                filterMaxLimit,
                filterMinPremium,
                filterMaxPremium,
                filterActive);

        System.out.println("the size is " +foundCoveragesList.size() );
    }

    public Integer getFilterId() {
        return filterId;
    }

    public void setFilterId(Integer filterId) {
        this.filterId = filterId;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public BigDecimal getFilterMaxLimit() {
        return filterMaxLimit;
    }

    public void setFilterMaxLimit(BigDecimal filterMaxLimit) {
        this.filterMaxLimit = filterMaxLimit;
    }

    public BigDecimal getFilterMinLimit() {
        return filterMinLimit;
    }

    public void setFilterMinLimit(BigDecimal filterMinLimit) {
        this.filterMinLimit = filterMinLimit;
    }

    public BigDecimal getFilterMinPremium() {
        return filterMinPremium;
    }

    public void setFilterMinPremium(BigDecimal filterMinPremium) {
        this.filterMinPremium = filterMinPremium;
    }

    public BigDecimal getFilterMaxPremium() {
        return filterMaxPremium;
    }

    public void setFilterMaxPremium(BigDecimal filterMaxPremium) {
        this.filterMaxPremium = filterMaxPremium;
    }

    public Boolean getFilterActive() {
        return filterActive;
    }

    public void setFilterActive(Boolean filterActive) {
        this.filterActive = filterActive;
    }

    public List<CoverageItem> getFoundCoveragesList() {
        return foundCoveragesList;
    }

    public void setFoundCoveragesList(List<CoverageItem> foundCoveragesList) {
        this.foundCoveragesList = foundCoveragesList;
    }

    public CoverageItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(CoverageItem selectedItem) {
        this.selectedItem = selectedItem;
    }
}
