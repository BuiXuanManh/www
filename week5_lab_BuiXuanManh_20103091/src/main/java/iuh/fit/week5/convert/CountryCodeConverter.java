package iuh.fit.week5.convert;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.core.convert.converter.Converter;

public class CountryCodeConverter implements Converter<String, CountryCode> {
    @Override
    public CountryCode convert(String source) {
        return CountryCode.getByCode(source);
    }
}

