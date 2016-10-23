package info.novatec.testit.livingdoc.training.exercises.lessons;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;


@FixtureClass("Simple Calculator")
public class SimpleCalculatorFixture {

    private NumberFormat format;
    private Calculator cut;

    private Float a;
    private Float b;

    @BeforeRow
    public void init() {
        format = NumberFormat.getInstance(Locale.UK);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(0);
        format.setRoundingMode(RoundingMode.HALF_UP);
        cut = new Calculator();
    }

    @Alias("Variable A")
    public void setA(Float a) {
        this.a = a;
    }

    @Alias("Variable B")
    public void setB(Float b) {
        this.b = b;
    }

    @Alias("added")
    public String add() {
        return format.format(cut.add(a, b));
    }

    @Alias("subtracted")
    public String subtract() {
        return format.format(cut.subtract(a, b));
    }

    @Alias("multiplied")
    public String multiply() {
        return format.format(cut.multiply(a, b));
    }

    @Alias("divided")
    public String divide() {
        float result = cut.divide(a, b);
        if (result == Float.POSITIVE_INFINITY || result == Float.NEGATIVE_INFINITY) {
            return "-";
        }
        return format.format(result);
    }

}
