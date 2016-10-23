package info.novatec.testit.livingdoc.training.exercises.country;

import info.novatec.testit.livingdoc.training.exercises.country.EuCountry;

import java.util.ArrayList;
import java.util.List;

public class CountryProvider {
	
	
	
	public List<EuCountry> getStaaten() {
		
		List<EuCountry> countries = new ArrayList<>();
		countries.add(new EuCountry("Belgien","B"));
		countries.add(new EuCountry("Deutschland","D"));
		countries.add(new EuCountry("Österreich","A"));
		countries.add(new EuCountry("Polen","PL"));
		return countries;
	}

}
