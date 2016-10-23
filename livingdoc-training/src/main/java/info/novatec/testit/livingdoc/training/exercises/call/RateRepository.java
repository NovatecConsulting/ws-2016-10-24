package info.novatec.testit.livingdoc.training.exercises.call;

import info.novatec.testit.livingdoc.training.exercises.country.CountryEnum;

import java.util.Arrays;
import java.util.List;

public class RateRepository {

	public List<MinutePrice> getPrices() {
		return Arrays.asList(new MinutePrice(CountryEnum.DE, 0.01), new MinutePrice(CountryEnum.FR, 0.05),
				new MinutePrice(CountryEnum.ES, 0.08), new MinutePrice(CountryEnum.TN, 0.50));
	}
}
