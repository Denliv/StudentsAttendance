package validator.simple_validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

public class DateValidator {
    public DateValidator isCorrectDate(String date, List<String> errors, String fieldName) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT));
            return this;
        } catch (DateTimeParseException ex) {
            errors.add(fieldName + " should be in dd/mm/yyyy format with correct date");
            return this;
        }
    }
}
