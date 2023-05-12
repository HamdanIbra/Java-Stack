package com.axsos.AdvancedQueries.models;

import java.math.BigDecimal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Language {
	@Id
    @Column(length = 30, nullable = false)
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IsOfficial isOfficial;

    @Column(insertable=false, updatable=false)
    private String countryCode;

    @Column(precision = 4, scale = 1, nullable = false)
    private BigDecimal percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryCode", referencedColumnName = "code", nullable = false)
    private Country country;

    // Constructor, getters, setters, etc.
    
    public Language() {
    	
    }

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public IsOfficial getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(IsOfficial isOfficial) {
		this.isOfficial = isOfficial;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
    
    
    
}

