package com.tailoredshapes.underbar;

import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class Dates {

    public static Date date(Instant instant) {
        return Date.from(instant);
    }

    public static Date date(YearMonth yearMonth) {
        return Date.from(yearMonth.atDay(1).atStartOfDay(ZoneOffset.UTC).toInstant());
    }

    public static Date date(String string) {
        TemporalAccessor parse = DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC).parse(string);
        return date(Instant.from(parse));
    }

    public static Instant instant(String string){
        return Instant.from(ISO_DATE.parse(string));
    }

    public static String isoString(Date time) {
        return ISO_INSTANT.format(time.toInstant());
    }

    public static String isoString(Instant instant){
        return ISO_INSTANT.format(instant);
    }
}
