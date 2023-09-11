package com.example.todolist.utils.constants;

import java.time.format.DateTimeFormatter;

public class AppConstants {
    public static final String ZONED_DATE_TIME_PATTERN_FOR_OUTPUT_REPORT_FILE
            = "dd-MM-yyyy'T'HH:mm:ssXXX";
    public static final DateTimeFormatter FORMATTER_FOR_PATTERN = DateTimeFormatter
            .ofPattern(ZONED_DATE_TIME_PATTERN_FOR_OUTPUT_REPORT_FILE);

    public static final String REGEX_FOR_DATE_TIME = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])"
            + "-(202[3-9]|20[3-9][0-9]|21[0-1][0-9]|212[0-3])"
            + "T([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])([+-](0[0-9]|1[0-4]):(00|15|30|45))$";

    public static final String START_WORKING_DATE_TIME = "10-09-2023T00:00:00+00:00";
    public static final String END_WORKING_DATE_TIME = "10-09-2123T00:00:00+00:00";
}
