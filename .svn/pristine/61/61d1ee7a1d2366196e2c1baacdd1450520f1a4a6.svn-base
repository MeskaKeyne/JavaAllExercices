package be.steformations.pc.service.contacts.soap.interfaces;

import be.steformations.pc.java_data.contacts.dto.CountryDto;

@javax.jws.WebService
public interface CountrySoapService {

	java.util.List<CountryDto> findAllCountries();
	CountryDto findOneCountryById(int id);
	CountryDto findOneCountryByAbbreviation(String abbreviation);
	CountryDto createAndSaveCountry(String abbreviation, String name);
}
