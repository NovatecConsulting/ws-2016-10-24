package info.novatec.testit.livingdoc.training.exercises.country;

import info.novatec.testit.livingdoc.reflect.annotation.Alias;

public class EuCountryWrapper {

	private EuCountry euCountry;
			
	public EuCountryWrapper(EuCountry euCountry) {
		this.euCountry = euCountry;
	}

	@Alias("Staat")
	public String getStaat(){
		return euCountry.getStaat();
	}
	
	@Alias("Kürzel")
	public String getKuerzel(){
		return euCountry.getKuerzel();
	}
	
}
