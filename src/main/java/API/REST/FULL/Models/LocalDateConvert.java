package API.REST.FULL.Models;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConvert implements AttributeConverter<LocalDate, java.sql.Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return date==null?null:Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return  date==null?null: new Date(date.getTime()).toLocalDate();
    }
}
