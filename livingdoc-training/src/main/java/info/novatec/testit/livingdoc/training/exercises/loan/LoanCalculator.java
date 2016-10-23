package info.novatec.testit.livingdoc.training.exercises.loan;

public class LoanCalculator {

    private int kaufpreis;
    private int eigenkapital;
    private int beleihungssumme;
    private int beleihungswert;

    public int getBeleihungssumme() {
        return beleihungssumme;
    }

    public int getBeleihungswert() {
        return beleihungswert;
    }

    public void setKaufpreis(int kaufpreis) {
        this.kaufpreis = kaufpreis;
    }

    public void setEigenkapital(int eigenkapital) {
        this.eigenkapital = eigenkapital;
    }

    public void calculate() {
        beleihungssumme = kaufpreis - eigenkapital;
        if (beleihungssumme < 1)
            throw new IllegalStateException("Loan not possible");
        beleihungswert = beleihungssumme * 100 / kaufpreis;

    }

}
