package info.novatec.testit.livingdoc.training.exercises.date;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.converter.TypeConverter;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeTable;

import java.util.TimeZone;

public class TimezoneFinderFixture {

    public static class TimezoneConverter implements TypeConverter {

        public boolean canConvertTo(Class<?> clazz) {
            return TimeZone.class.isAssignableFrom(clazz);
        }

        public Object parse(String text, Class<?> clazz) {
            for (String tzId : TimeZone.getAvailableIDs()) {
                TimeZone tz = TimeZone.getTimeZone(tzId);
                if (tz.getDisplayName().equalsIgnoreCase(text) || tzId.contains(text))
                    return tz;
            }
            return null;
        }

        public String toString(Object tzObj) {
            return ((TimeZone) tzObj).getDisplayName();
        }

    }


    private TimeZone timezone;

    public void setCity(TimeZone timezone) {
        this.timezone = timezone;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public int offsetToUtc() {
        return timezone.getRawOffset() / 3600000;
    }

    @BeforeTable
    public void setup() {
        LivingDoc.register(new TimezoneConverter());
    }

    @AfterTable
    public void clean() {
        LivingDoc.unregisterLastAddedCustomConverter();
    }
}
