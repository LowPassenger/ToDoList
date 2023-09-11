package com.example.todolist.utils;

import com.example.todolist.utils.constants.AppConstants;
import java.time.ZonedDateTime;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class DateTimeFormatValidator {
    private final Pattern validationPattern = Pattern
            .compile(AppConstants.REGEX_FOR_DATE_TIME);

    public boolean isValid(String dateTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime
                .parse(dateTime, AppConstants.FORMATTER_FOR_PATTERN);

        return (validationPattern.matcher(dateTime).matches())
                & !zonedDateTime
                .isBefore(ZonedDateTime
                        .parse(AppConstants.START_WORKING_DATE_TIME,
                                AppConstants.FORMATTER_FOR_PATTERN))
                & !zonedDateTime
                .isAfter(ZonedDateTime
                        .parse(AppConstants.END_WORKING_DATE_TIME,
                                AppConstants.FORMATTER_FOR_PATTERN));
    }
}
