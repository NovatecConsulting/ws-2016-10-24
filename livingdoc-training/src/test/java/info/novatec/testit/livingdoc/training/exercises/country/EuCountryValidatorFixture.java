package info.novatec.testit.livingdoc.training.exercises.country;

import java.util.List;
import java.util.stream.Collectors;

import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("EU Staaten Validator")
public class EuCountryValidatorFixture {

	public List<EuCountryWrapper> query() {
		return new CountryProvider().getStaaten().stream().map(staat -> new EuCountryWrapper(staat))
				.collect(Collectors.toList());
	}

}
