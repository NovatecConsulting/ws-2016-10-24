package info.novatec.testit.livingdoc.training.exercises.date;

import java.util.Date;

public class DateConversionFixture {

	public Date dateDE;
	public Date convertedDate;
	public String target;

	private String sourceLanguage;
	public DateConversionFixture(String quelleSprache) {
		this.sourceLanguage = quelleSprache;
	}

	
}
