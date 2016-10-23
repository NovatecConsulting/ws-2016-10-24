package info.novatec.testit.livingdoc.training.exercises.call;

import info.novatec.testit.livingdoc.training.exercises.country.CountryEnum;

public class MinutePrice {
	private CountryEnum country;
	private double price;
	public CountryEnum getCountry() {
		return country;
	}
	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MinutePrice(CountryEnum country, double price) {
		super();
		this.country = country;
		this.price = price;
	}
	
	
}
