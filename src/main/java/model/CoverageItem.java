package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;


@Entity
@NamedQueries({
        @NamedQuery(name = "findAll",query = "SELECT ci FROM CoverageItem ci"),
        @NamedQuery(name = "CoverageItem.findAllWithFilter",
                query = "SELECT ci FROM CoverageItem ci WHERE " +
                        "(:id IS NULL OR ci.coverageId = :id) AND " +
                        "(:name IS NULL OR LOWER(ci.coverageName) LIKE LOWER(:name)) AND " +
                        "(:minLimit IS NULL OR ci.limit >= :minLimit) AND " +
                        "(:maxLimit IS NULL OR ci.limit <= :maxLimit) AND " +
                        "(:minPremium IS NULL OR ci.premium >= :minPremium) AND " +
                        "(:maxPremium IS NULL OR ci.premium <= :maxPremium) AND " +
                        "(:active IS NULL OR ci.active = :active)")}
)
@Table(name = "CoverageItems")
public class CoverageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coverageId;
    @NotBlank
    @Size(min = 2,max = 50)
    private String coverageName;
    @NotBlank
    @Size(min = 5,max = 50)
    private String coverageDescription;
    @Column(name = "coverage_limit")
    @NotNull
    private BigDecimal limit;
    @NotNull
    private BigDecimal premium;
    private Boolean active = true;

    public CoverageItem() {
    }

    public CoverageItem(String coverageName, String coverageDescription, BigDecimal limit, BigDecimal premium, boolean active) {
        this.coverageName = coverageName;
        this.coverageDescription = coverageDescription;
        this.limit = limit;
        this.premium = premium;
        this.active = active;
    }

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }

    public String getCoverageDescription() {
        return coverageDescription;
    }

    public void setCoverageDescription(String coverageDescription) {
        this.coverageDescription = coverageDescription;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean  active) {
        this.active = active;
    }

    public Integer getCoverageId() {
        return coverageId;
    }

    public void setCoverageId(Integer coverageId) {
        this.coverageId = coverageId;
    }
}
