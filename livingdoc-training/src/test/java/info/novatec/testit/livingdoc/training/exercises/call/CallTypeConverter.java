package info.novatec.testit.livingdoc.training.exercises.call;

import org.apache.commons.lang3.StringUtils;

import info.novatec.testit.livingdoc.converter.TypeConverter;

public class CallTypeConverter implements TypeConverter {

    public boolean canConvertTo(Class<?> clazz) {
        return CallTypeEnum.class.isAssignableFrom(clazz);
    }

    public Object parse(String type, Class<?> clazz) {
        return CallTypeEnum.valueOf(type.toUpperCase());
    }

    public String toString(Object enumObj) {
        return StringUtils.capitalize(enumObj.toString().toLowerCase());
    }

}