package com.axsos.AdvancedQueries.models;

import java.math.BigDecimal;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Country {
    @Id
    @Column(length = 3)
    private String code;

    @Column(length = 52, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Continent continent;

    @Column(length = 26, nullable = false)
    private String region;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column
    private Short indepYear;

    @Column(nullable = false)
    private int population;

    @Column(precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "gnp_old", precision = 10, scale = 2)
    private BigDecimal gnpOld;

    @Column(length = 45, nullable = false)
    private String localName;

    @Column(length = 45, nullable = false)
    private String governmentForm;

    @Column(length = 60)
    private String headOfState;

    @Column
    private Integer capital;

    @Column(length = 2, nullable = false)
    private String code2;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Language> languages;

    // Constructor, getters, setters, etc.
    
    public Country() {
    	
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(BigDecimal surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Short getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public BigDecimal getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(BigDecimal lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public BigDecimal getGnp() {
		return gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public BigDecimal getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(BigDecimal gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
    
    
    
}
