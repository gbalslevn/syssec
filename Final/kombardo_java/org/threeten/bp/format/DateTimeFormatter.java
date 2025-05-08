package org.threeten.bp.format;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseContext;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

/* loaded from: classes3.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter BASIC_ISO_DATE;
    public static final DateTimeFormatter ISO_DATE;
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME;
    public static final DateTimeFormatter ISO_LOCAL_TIME;
    public static final DateTimeFormatter ISO_OFFSET_DATE;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME;
    public static final DateTimeFormatter ISO_OFFSET_TIME;
    public static final DateTimeFormatter ISO_ORDINAL_DATE;
    public static final DateTimeFormatter ISO_TIME;
    public static final DateTimeFormatter ISO_WEEK_DATE;
    public static final DateTimeFormatter ISO_ZONED_DATE_TIME;
    private static final TemporalQuery<Period> PARSED_EXCESS_DAYS;
    private static final TemporalQuery<Boolean> PARSED_LEAP_SECOND;
    public static final DateTimeFormatter RFC_1123_DATE_TIME;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set<TemporalField> resolverFields;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder appendLiteral = dateTimeFormatterBuilder.appendValue(chronoField, 4, 10, signStyle).appendLiteral('-');
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder appendLiteral2 = appendLiteral.appendValue(chronoField2, 2).appendLiteral('-');
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder appendValue = appendLiteral2.appendValue(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        DateTimeFormatter formatter = appendValue.toFormatter(resolverStyle);
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter withChronology = formatter.withChronology(isoChronology);
        ISO_LOCAL_DATE = withChronology;
        ISO_OFFSET_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder appendLiteral3 = dateTimeFormatterBuilder2.appendValue(chronoField4, 2).appendLiteral(':');
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder appendLiteral4 = appendLiteral3.appendValue(chronoField5, 2).optionalStart().appendLiteral(':');
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter formatter2 = appendLiteral4.appendValue(chronoField6, 2).optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).toFormatter(resolverStyle);
        ISO_LOCAL_TIME = formatter2;
        ISO_OFFSET_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(formatter2).appendOffsetId().toFormatter(resolverStyle);
        ISO_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(formatter2).optionalStart().appendOffsetId().toFormatter(resolverStyle);
        DateTimeFormatter withChronology2 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).appendLiteral('T').append(formatter2).toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_LOCAL_DATE_TIME = withChronology2;
        DateTimeFormatter withChronology3 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology2).appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_OFFSET_DATE_TIME = withChronology3;
        ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder().append(withChronology3).optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_DATE_TIME = new DateTimeFormatterBuilder().append(withChronology2).optionalStart().appendOffsetId().optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_ORDINAL_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4, 10, signStyle).appendLiteral('-').appendValue(ChronoField.DAY_OF_YEAR, 3).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        DateTimeFormatterBuilder appendLiteral5 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, signStyle).appendLiteral("-W").appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2).appendLiteral('-');
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        ISO_WEEK_DATE = appendLiteral5.appendValue(chronoField7, 1).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_INSTANT = new DateTimeFormatterBuilder().parseCaseInsensitive().appendInstant().toFormatter(resolverStyle);
        BASIC_ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4).appendValue(chronoField2, 2).appendValue(chronoField3, 2).optionalStart().appendOffset("+HHMMss", "Z").toFormatter(resolverStyle).withChronology(isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(chronoField7, hashMap).appendLiteral(", ").optionalEnd().appendValue(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).appendLiteral(' ').appendText(chronoField2, hashMap2).appendLiteral(' ').appendValue(chronoField, 4).appendLiteral(' ').appendValue(chronoField4, 2).appendLiteral(':').appendValue(chronoField5, 2).optionalStart().appendLiteral(':').appendValue(chronoField6, 2).optionalEnd().appendLiteral(' ').appendOffset("+HHMM", "GMT").toFormatter(ResolverStyle.SMART).withChronology(isoChronology);
        PARSED_EXCESS_DAYS = new TemporalQuery<Period>() { // from class: org.threeten.bp.format.DateTimeFormatter.1
            @Override // org.threeten.bp.temporal.TemporalQuery
            public Period queryFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor instanceof DateTimeBuilder) {
                    return ((DateTimeBuilder) temporalAccessor).excessDays;
                }
                return Period.ZERO;
            }
        };
        PARSED_LEAP_SECOND = new TemporalQuery<Boolean>() { // from class: org.threeten.bp.format.DateTimeFormatter.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.threeten.bp.temporal.TemporalQuery
            public Boolean queryFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor instanceof DateTimeBuilder) {
                    return Boolean.valueOf(((DateTimeBuilder) temporalAccessor).leapSecond);
                }
                return Boolean.FALSE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale, DecimalStyle decimalStyle, ResolverStyle resolverStyle, Set<TemporalField> set, Chronology chronology, ZoneId zoneId) {
        this.printerParser = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.requireNonNull(compositePrinterParser, "printerParser");
        this.locale = (Locale) Jdk8Methods.requireNonNull(locale, "locale");
        this.decimalStyle = (DecimalStyle) Jdk8Methods.requireNonNull(decimalStyle, "decimalStyle");
        this.resolverStyle = (ResolverStyle) Jdk8Methods.requireNonNull(resolverStyle, "resolverStyle");
        this.resolverFields = set;
        this.chrono = chronology;
        this.zone = zoneId;
    }

    private DateTimeParseException createError(CharSequence charSequence, RuntimeException runtimeException) {
        String charSequence2;
        if (charSequence.length() > 64) {
            charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            charSequence2 = charSequence.toString();
        }
        return new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    public static DateTimeFormatter ofLocalizedDate(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, null).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofPattern(String str) {
        return new DateTimeFormatterBuilder().appendPattern(str).toFormatter();
    }

    private DateTimeBuilder parseToBuilder(CharSequence charSequence, ParsePosition parsePosition) {
        String charSequence2;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        DateTimeParseContext.Parsed parseUnresolved0 = parseUnresolved0(charSequence, parsePosition2);
        if (parseUnresolved0 != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return parseUnresolved0.toBuilder();
        }
        if (charSequence.length() > 64) {
            charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    private DateTimeParseContext.Parsed parseUnresolved0(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(parsePosition, "position");
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int parse = this.printerParser.parse(dateTimeParseContext, charSequence, parsePosition.getIndex());
        if (parse < 0) {
            parsePosition.setErrorIndex(~parse);
            return null;
        }
        parsePosition.setIndex(parse);
        return dateTimeParseContext.toParsed();
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        formatTo(temporalAccessor, sb);
        return sb.toString();
    }

    public void formatTo(TemporalAccessor temporalAccessor, Appendable appendable) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        Jdk8Methods.requireNonNull(appendable, "appendable");
        try {
            DateTimePrintContext dateTimePrintContext = new DateTimePrintContext(temporalAccessor, this);
            if (appendable instanceof StringBuilder) {
                this.printerParser.print(dateTimePrintContext, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb = new StringBuilder(32);
            this.printerParser.print(dateTimePrintContext, sb);
            appendable.append(sb);
        } catch (IOException e5) {
            throw new DateTimeException(e5.getMessage(), e5);
        }
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public <T> T parse(CharSequence charSequence, TemporalQuery<T> temporalQuery) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(temporalQuery, "type");
        try {
            return (T) parseToBuilder(charSequence, null).resolve(this.resolverStyle, this.resolverFields).build(temporalQuery);
        } catch (DateTimeParseException e5) {
            throw e5;
        } catch (RuntimeException e6) {
            throw createError(charSequence, e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatterBuilder.CompositePrinterParser toPrinterParser(boolean z5) {
        return this.printerParser.withOptional(z5);
    }

    public String toString() {
        String compositePrinterParser = this.printerParser.toString();
        return compositePrinterParser.startsWith("[") ? compositePrinterParser : compositePrinterParser.substring(1, compositePrinterParser.length() - 1);
    }

    public DateTimeFormatter withChronology(Chronology chronology) {
        return Jdk8Methods.equals(this.chrono, chronology) ? this : new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, chronology, this.zone);
    }

    public DateTimeFormatter withLocale(Locale locale) {
        return this.locale.equals(locale) ? this : new DateTimeFormatter(this.printerParser, locale, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverStyle(ResolverStyle resolverStyle) {
        Jdk8Methods.requireNonNull(resolverStyle, "resolverStyle");
        return Jdk8Methods.equals(this.resolverStyle, resolverStyle) ? this : new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, resolverStyle, this.resolverFields, this.chrono, this.zone);
    }
}
