package info.novatec.testit.livingdoc.training.exercises.call;

import info.novatec.testit.livingdoc.converter.TypeConverter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class PriceConverter implements TypeConverter {

    private static NumberFormat NFC = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    public boolean canConvertTo(Class<?> clazz) {
        return Double.class.isAssignableFrom(clazz);
    }

    public Object parse(String price, Class<?> clazz) {
        try {
            Number nf = NFC.parse(price);
            return Double.valueOf(nf.doubleValue());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid price: " + price);
        }
    }

    public String toString(Object arg0) {
        return NFC.format(arg0);
    }

}