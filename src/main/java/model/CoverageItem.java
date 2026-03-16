package model;

import java.math.BigDecimal;

public class CoverageItem {
    private String coverageName;
    private String coverageDescription;
    private BigDecimal limit;
    private BigDecimal premium;
    private boolean active;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
