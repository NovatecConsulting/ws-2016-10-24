package info.novatec.testit.livingdoc.training.exercises.loan;

import info.novatec.testit.livingdoc.reflect.AfterRow;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Loan Calculator")
public class LoanValueCalculationFixture {

	private LoanCalculator loanCalculator;
	private int sellingPrice;
	private int ownCapital;
	private int beleihungssumme;
	private int loanValue;
	private RuntimeException throwabe;

	@BeforeTable
	public void setup(){
		loanCalculator = new LoanCalculator();
	}
	
	@BeforeRow
	public void reset(){
		sellingPrice = 0;
		ownCapital = 0;
		loanValue = 0;
		beleihungssumme = 0;
	}
	
	@BeforeFirstExpectation
	public void calculate(){
		//Arrange 
		loanCalculator.setKaufpreis(sellingPrice);
		loanCalculator.setEigenkapital(ownCapital);
		
		//Act
		try {
			loanCalculator.calculate();
			
			loanValue = loanCalculator.getBeleihungswert();
			beleihungssumme = loanCalculator.getBeleihungssumme();
		} catch (RuntimeException e) {
			throwabe = e;
		}
	}
	@AfterRow
	public void afterRow(){
		sellingPrice = 0;
		ownCapital = 0;
		loanValue = 0;
		beleihungssumme = 0;
	}
	
	
	@AfterTable
	public void cleanup(){
		loanCalculator = null;
	}
	
	
	@Alias("Lending value (€)")
	public int getTotalLoan() {
		if(throwabe != null)
			throw throwabe;
		return beleihungssumme;
	}
	@Alias("Lending quote (%)")
	public int getLoanValue() {
		if(throwabe != null)
			throw throwabe;
		return loanValue;
	}
	@Alias("Real estate price (€)")
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Alias("Own capital (€)")
	public void setOwnCapital(int ownCapital) {
		this.ownCapital = ownCapital;
	}
	
	
}
