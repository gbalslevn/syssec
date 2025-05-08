package org.threeten.bp.format;

import com.adjust.sdk.Constants;
import com.google.android.gms.internal.measurement.a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.conscrypt.BuildConfig;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

/* loaded from: classes3.dex */
public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP;
    static final Comparator<String> LENGTH_SORT;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$format$SignStyle;

        static {
            int[] iArr = new int[SignStyle.values().length];
            $SwitchMap$org$threeten$bp$format$SignStyle = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char c5) {
            this.literal = c5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            if (i5 == charSequence.length()) {
                return ~i5;
            }
            return !dateTimeParseContext.charEquals(this.literal, charSequence.charAt(i5)) ? ~i5 : i5 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List<DateTimePrinterParser> list, boolean z5) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z5);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            if (!this.optional) {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    i5 = dateTimePrinterParser.parse(dateTimeParseContext, charSequence, i5);
                    if (i5 < 0) {
                        break;
                    }
                }
                return i5;
            }
            dateTimeParseContext.startOptional();
            int i6 = i5;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.printerParsers) {
                i6 = dateTimePrinterParser2.parse(dateTimeParseContext, charSequence, i6);
                if (i6 < 0) {
                    dateTimeParseContext.endOptional(false);
                    return i5;
                }
            }
            dateTimeParseContext.endOptional(true);
            return i6;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.optional) {
                dateTimePrintContext.startOptional();
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    if (!dateTimePrinterParser.print(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.printerParsers != null) {
                sb.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.optional ? "]" : ")");
            }
            return sb.toString();
        }

        public CompositePrinterParser withOptional(boolean z5) {
            return z5 == this.optional ? this : new CompositePrinterParser(this.printerParsers, z5);
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z5) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface DateTimePrinterParser {
        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5);

        boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb);
    }

    /* loaded from: classes3.dex */
    static class DefaultingParser implements DateTimePrinterParser {
        private final TemporalField field;
        private final long value;

        DefaultingParser(TemporalField temporalField, long j5) {
            this.field = temporalField;
            this.value = j5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            if (dateTimeParseContext.getParsed(this.field) == null) {
                dateTimeParseContext.setParsedField(this.field, this.value, i5, i5);
            }
            return i5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField temporalField, int i5, int i6, boolean z5) {
            Jdk8Methods.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            }
            if (i5 < 0 || i5 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i5);
            }
            if (i6 < 1 || i6 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i6);
            }
            if (i6 >= i5) {
                this.field = temporalField;
                this.minWidth = i5;
                this.maxWidth = i6;
                this.decimalPoint = z5;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i6 + " < " + i5);
        }

        private long convertFromFraction(BigDecimal bigDecimal) {
            ValueRange range = this.field.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        private BigDecimal convertToFraction(long j5) {
            ValueRange range = this.field.range();
            range.checkValidValue(j5, this.field);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(j5).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimal = BigDecimal.ZERO;
            return divide.compareTo(bigDecimal) == 0 ? bigDecimal : a.a(divide);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int i6 = 0;
            int i7 = dateTimeParseContext.isStrict() ? this.minWidth : 0;
            int i8 = dateTimeParseContext.isStrict() ? this.maxWidth : 9;
            int length = charSequence.length();
            if (i5 == length) {
                return i7 > 0 ? ~i5 : i5;
            }
            if (this.decimalPoint) {
                if (charSequence.charAt(i5) != dateTimeParseContext.getSymbols().getDecimalSeparator()) {
                    return i7 > 0 ? ~i5 : i5;
                }
                i5++;
            }
            int i9 = i5;
            int i10 = i7 + i9;
            if (i10 > length) {
                return ~i9;
            }
            int min = Math.min(i8 + i9, length);
            int i11 = i9;
            while (true) {
                if (i11 >= min) {
                    break;
                }
                int i12 = i11 + 1;
                int convertToDigit = dateTimeParseContext.getSymbols().convertToDigit(charSequence.charAt(i11));
                if (convertToDigit >= 0) {
                    i6 = (i6 * 10) + convertToDigit;
                    i11 = i12;
                } else if (i12 < i10) {
                    return ~i9;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, convertFromFraction(new BigDecimal(i6).movePointLeft(i11 - i9)), i9, i11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle symbols = dateTimePrintContext.getSymbols();
            BigDecimal convertToFraction = convertToFraction(value.longValue());
            if (convertToFraction.scale() != 0) {
                String convertNumberToI18N = symbols.convertNumberToI18N(convertToFraction.setScale(Math.min(Math.max(convertToFraction.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb.append(symbols.getDecimalSeparator());
                }
                sb.append(convertNumberToI18N);
                return true;
            }
            if (this.minWidth <= 0) {
                return true;
            }
            if (this.decimalPoint) {
                sb.append(symbols.getDecimalSeparator());
            }
            for (int i5 = 0; i5 < this.minWidth; i5++) {
                sb.append(symbols.getZeroDigit());
            }
            return true;
        }

        public String toString() {
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + (this.decimalPoint ? ",DecimalPoint" : BuildConfig.FLAVOR) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long SECONDS_0000_TO_1970 = 62167219200L;
        private static final long SECONDS_PER_10000_YEARS = 315569520000L;
        private final int fractionalDigits;

        InstantPrinterParser(int i5) {
            this.fractionalDigits = i5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int i6;
            int i7;
            DateTimeParseContext copy = dateTimeParseContext.copy();
            int i8 = this.fractionalDigits;
            int i9 = 0;
            int i10 = i8 < 0 ? 0 : i8;
            if (i8 < 0) {
                i8 = 9;
            }
            DateTimeFormatterBuilder appendLiteral = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder appendLiteral2 = appendLiteral.appendValue(chronoField, 2).appendLiteral(':');
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder appendLiteral3 = appendLiteral2.appendValue(chronoField2, 2).appendLiteral(':');
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder appendValue = appendLiteral3.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int parse = appendValue.appendFraction(chronoField4, i10, i8, true).appendLiteral('Z').toFormatter().toPrinterParser(false).parse(copy, charSequence, i5);
            if (parse < 0) {
                return parse;
            }
            long longValue = copy.getParsed(ChronoField.YEAR).longValue();
            int intValue = copy.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = copy.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = copy.getParsed(chronoField).intValue();
            int intValue4 = copy.getParsed(chronoField2).intValue();
            Long parsed = copy.getParsed(chronoField3);
            Long parsed2 = copy.getParsed(chronoField4);
            int intValue5 = parsed != null ? parsed.intValue() : 0;
            int intValue6 = parsed2 != null ? parsed2.intValue() : 0;
            int i11 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                i6 = 0;
                i7 = intValue5;
                i9 = 1;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                dateTimeParseContext.setParsedLeapSecond();
                i7 = 59;
                i6 = intValue3;
            } else {
                i6 = intValue3;
                i7 = intValue5;
            }
            try {
                return dateTimeParseContext.setParsedField(chronoField4, intValue6, i5, dateTimeParseContext.setParsedField(ChronoField.INSTANT_SECONDS, Jdk8Methods.safeMultiply(longValue / 10000, SECONDS_PER_10000_YEARS) + LocalDateTime.of(i11, intValue, intValue2, i6, intValue4, i7, 0).plusDays(i9).toEpochSecond(ZoneOffset.UTC), i5, parse));
            } catch (RuntimeException unused) {
                return ~i5;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long valueOf = temporal.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.getTemporal().getLong(chronoField)) : 0L;
            int i5 = 0;
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(valueOf.longValue());
            if (longValue >= -62167219200L) {
                long j5 = longValue - 253402300800L;
                long floorDiv = 1 + Jdk8Methods.floorDiv(j5, SECONDS_PER_10000_YEARS);
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(Jdk8Methods.floorMod(j5, SECONDS_PER_10000_YEARS) - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                if (floorDiv > 0) {
                    sb.append('+');
                    sb.append(floorDiv);
                }
                sb.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb.append(":00");
                }
            } else {
                long j6 = longValue + SECONDS_0000_TO_1970;
                long j7 = j6 / SECONDS_PER_10000_YEARS;
                long j8 = j6 % SECONDS_PER_10000_YEARS;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j8 - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb.append(":00");
                }
                if (j7 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j7 - 1));
                    } else if (j8 == 0) {
                        sb.insert(length, j7);
                    } else {
                        sb.insert(length + 1, Math.abs(j7));
                    }
                }
            }
            int i6 = this.fractionalDigits;
            if (i6 == -2) {
                if (checkValidIntValue != 0) {
                    sb.append('.');
                    if (checkValidIntValue % 1000000 == 0) {
                        sb.append(Integer.toString((checkValidIntValue / 1000000) + Constants.ONE_SECOND).substring(1));
                    } else if (checkValidIntValue % Constants.ONE_SECOND == 0) {
                        sb.append(Integer.toString((checkValidIntValue / Constants.ONE_SECOND) + 1000000).substring(1));
                    } else {
                        sb.append(Integer.toString(checkValidIntValue + 1000000000).substring(1));
                    }
                }
            } else if (i6 > 0 || (i6 == -1 && checkValidIntValue > 0)) {
                sb.append('.');
                int i7 = 100000000;
                while (true) {
                    int i8 = this.fractionalDigits;
                    if ((i8 != -1 || checkValidIntValue <= 0) && i5 >= i8) {
                        break;
                    }
                    int i9 = checkValidIntValue / i7;
                    sb.append((char) (i9 + 48));
                    checkValidIntValue -= i9 * i7;
                    i7 /= 10;
                    i5++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.style = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            char charAt;
            if (!dateTimeParseContext.subSequenceEquals(charSequence, i5, "GMT", 0, 3)) {
                return ~i5;
            }
            int i6 = i5 + 3;
            if (this.style == TextStyle.FULL) {
                return new OffsetIdPrinterParser(BuildConfig.FLAVOR, "+HH:MM:ss").parse(dateTimeParseContext, charSequence, i6);
            }
            int length = charSequence.length();
            if (i6 == length) {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i6, i6);
            }
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 != '+' && charAt2 != '-') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i6, i6);
            }
            int i7 = charAt2 == '-' ? -1 : 1;
            if (i6 == length) {
                return ~i6;
            }
            int i8 = i5 + 4;
            char charAt3 = charSequence.charAt(i8);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i8;
            }
            int i9 = i5 + 5;
            int i10 = charAt3 - '0';
            if (i9 != length && (charAt = charSequence.charAt(i9)) >= '0' && charAt <= '9') {
                i10 = (i10 * 10) + (charAt - '0');
                if (i10 > 23) {
                    return ~i9;
                }
                i9 = i5 + 6;
            }
            int i11 = i9;
            if (i11 == length || charSequence.charAt(i11) != ':') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, i7 * 3600 * i10, i11, i11);
            }
            int i12 = i11 + 1;
            int i13 = length - 2;
            if (i12 > i13) {
                return ~i12;
            }
            char charAt4 = charSequence.charAt(i12);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i12;
            }
            int i14 = i11 + 2;
            int i15 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i14);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i14;
            }
            int i16 = i11 + 3;
            if ((i15 * 10) + (charAt5 - '0') > 59) {
                return ~i16;
            }
            if (i16 == length || charSequence.charAt(i16) != ':') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, i7 * ((i10 * 3600) + (r11 * 60)), i16, i16);
            }
            int i17 = i11 + 4;
            if (i17 > i13) {
                return ~i17;
            }
            char charAt6 = charSequence.charAt(i17);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i17;
            }
            int i18 = i11 + 5;
            int i19 = charAt6 - '0';
            char charAt7 = charSequence.charAt(i18);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i18;
            }
            int i20 = i11 + 6;
            return (i19 * 10) + (charAt7 - '0') > 59 ? ~i20 : dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, i7 * ((i10 * 3600) + (r11 * 60) + r1), i20, i20);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            sb.append("GMT");
            if (this.style == TextStyle.FULL) {
                return new OffsetIdPrinterParser(BuildConfig.FLAVOR, "+HH:MM:ss").print(dateTimePrintContext, sb);
            }
            int safeToInt = Jdk8Methods.safeToInt(value.longValue());
            if (safeToInt == 0) {
                return true;
            }
            int abs = Math.abs((safeToInt / 3600) % 100);
            int abs2 = Math.abs((safeToInt / 60) % 60);
            int abs3 = Math.abs(safeToInt % 60);
            sb.append(safeToInt < 0 ? "-" : "+");
            sb.append(abs);
            if (abs2 <= 0 && abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs2 / 10) + 48));
            sb.append((char) ((abs2 % 10) + 48));
            if (abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs3 / 10) + 48));
            sb.append((char) ((abs3 % 10) + 48));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private final FormatStyle dateStyle;
        private final FormatStyle timeStyle;

        LocalizedPrinterParser(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.dateStyle = formatStyle;
            this.timeStyle = formatStyle2;
        }

        private DateTimeFormatter formatter(Locale locale, Chronology chronology) {
            return DateTimeFormatStyleProvider.getInstance().getFormatter(this.dateStyle, this.timeStyle, chronology, locale);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            return formatter(dateTimeParseContext.getLocale(), dateTimeParseContext.getEffectiveChronology()).toPrinterParser(false).parse(dateTimeParseContext, charSequence, i5);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return formatter(dateTimePrintContext.getLocale(), Chronology.from(dateTimePrintContext.getTemporal())).toPrinterParser(false).print(dateTimePrintContext, sb);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Localized(");
            Object obj = this.dateStyle;
            Object obj2 = BuildConfig.FLAVOR;
            if (obj == null) {
                obj = BuildConfig.FLAVOR;
            }
            sb.append(obj);
            sb.append(",");
            FormatStyle formatStyle = this.timeStyle;
            if (formatStyle != null) {
                obj2 = formatStyle;
            }
            sb.append(obj2);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] EXCEED_POINTS = {0, 10, 100, Constants.ONE_SECOND, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        final SignStyle signStyle;
        final int subsequentWidth;

        long getValue(DateTimePrintContext dateTimePrintContext, long j5) {
            return j5;
        }

        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            int i5 = this.subsequentWidth;
            return i5 == -1 || (i5 > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x017f  */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int i6;
            boolean z5;
            boolean z6;
            BigInteger bigInteger;
            int i7;
            long j5;
            long j6;
            int i8;
            int i9;
            int i10;
            int length = charSequence.length();
            if (i5 == length) {
                return ~i5;
            }
            char charAt = charSequence.charAt(i5);
            int i11 = 0;
            if (charAt == dateTimeParseContext.getSymbols().getPositiveSign()) {
                if (!this.signStyle.parse(true, dateTimeParseContext.isStrict(), this.minWidth == this.maxWidth)) {
                    return ~i5;
                }
                i6 = i5 + 1;
                z5 = false;
                z6 = true;
            } else if (charAt == dateTimeParseContext.getSymbols().getNegativeSign()) {
                if (!this.signStyle.parse(false, dateTimeParseContext.isStrict(), this.minWidth == this.maxWidth)) {
                    return ~i5;
                }
                i6 = i5 + 1;
                z6 = false;
                z5 = true;
            } else {
                if (this.signStyle == SignStyle.ALWAYS && dateTimeParseContext.isStrict()) {
                    return ~i5;
                }
                i6 = i5;
                z5 = false;
                z6 = false;
            }
            int i12 = (dateTimeParseContext.isStrict() || isFixedWidth(dateTimeParseContext)) ? this.minWidth : 1;
            int i13 = i6 + i12;
            if (i13 > length) {
                return ~i6;
            }
            int max = ((dateTimeParseContext.isStrict() || isFixedWidth(dateTimeParseContext)) ? this.maxWidth : 9) + Math.max(this.subsequentWidth, 0);
            while (true) {
                bigInteger = null;
                if (i11 >= 2) {
                    i7 = i6;
                    j5 = 0;
                    break;
                }
                int min = Math.min(max + i6, length);
                i8 = i6;
                j5 = 0;
                while (true) {
                    if (i8 >= min) {
                        break;
                    }
                    int i14 = i8 + 1;
                    int convertToDigit = dateTimeParseContext.getSymbols().convertToDigit(charSequence.charAt(i8));
                    if (convertToDigit >= 0) {
                        if (i14 - i6 > 18) {
                            if (bigInteger == null) {
                                bigInteger = BigInteger.valueOf(j5);
                            }
                            bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.valueOf(convertToDigit));
                            i9 = i13;
                            i10 = min;
                        } else {
                            i9 = i13;
                            i10 = min;
                            j5 = (j5 * 10) + convertToDigit;
                        }
                        i13 = i9;
                        min = i10;
                        i8 = i14;
                    } else if (i8 < i13) {
                        return ~i6;
                    }
                }
                int i15 = i13;
                int i16 = this.subsequentWidth;
                if (i16 <= 0 || i11 != 0) {
                    break;
                }
                max = Math.max(i12, (i8 - i6) - i16);
                i11++;
                i13 = i15;
            }
            i7 = i8;
            if (z5) {
                if (bigInteger == null) {
                    if (j5 == 0 && dateTimeParseContext.isStrict()) {
                        return ~(i6 - 1);
                    }
                    j6 = -j5;
                    if (bigInteger != null) {
                        return setValue(dateTimeParseContext, j6, i6, i7);
                    }
                    if (bigInteger.bitLength() > 63) {
                        bigInteger = bigInteger.divide(BigInteger.TEN);
                        i7--;
                    }
                    return setValue(dateTimeParseContext, bigInteger.longValue(), i6, i7);
                }
                if (bigInteger.equals(BigInteger.ZERO) && dateTimeParseContext.isStrict()) {
                    return ~(i6 - 1);
                }
                bigInteger = bigInteger.negate();
            } else if (this.signStyle == SignStyle.EXCEEDS_PAD && dateTimeParseContext.isStrict()) {
                int i17 = i7 - i6;
                if (z6) {
                    if (i17 <= this.minWidth) {
                        return ~(i6 - 1);
                    }
                } else if (i17 > this.minWidth) {
                    return ~i6;
                }
            }
            j6 = j5;
            if (bigInteger != null) {
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            long value2 = getValue(dateTimePrintContext, value.longValue());
            DecimalStyle symbols = dateTimePrintContext.getSymbols();
            String l5 = value2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(value2));
            if (l5.length() > this.maxWidth) {
                throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " exceeds the maximum print width of " + this.maxWidth);
            }
            String convertNumberToI18N = symbols.convertNumberToI18N(l5);
            if (value2 >= 0) {
                int i5 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
                if (i5 == 1) {
                    if (this.minWidth < 19 && value2 >= EXCEED_POINTS[r4]) {
                        sb.append(symbols.getPositiveSign());
                    }
                } else if (i5 == 2) {
                    sb.append(symbols.getPositiveSign());
                }
            } else {
                int i6 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
                if (i6 == 1 || i6 == 2 || i6 == 3) {
                    sb.append(symbols.getNegativeSign());
                } else if (i6 == 4) {
                    throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i7 = 0; i7 < this.minWidth - convertNumberToI18N.length(); i7++) {
                sb.append(symbols.getZeroDigit());
            }
            sb.append(convertNumberToI18N);
            return true;
        }

        int setValue(DateTimeParseContext dateTimeParseContext, long j5, int i5, int i6) {
            return dateTimeParseContext.setParsedField(this.field, j5, i5, i6);
        }

        public String toString() {
            int i5 = this.minWidth;
            if (i5 == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                return "Value(" + this.field + ")";
            }
            if (i5 == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                return "Value(" + this.field + "," + this.minWidth + ")";
            }
            return "Value(" + this.field + "," + this.minWidth + "," + this.maxWidth + "," + this.signStyle + ")";
        }

        NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int i5) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + i5);
        }

        NumberPrinterParser(TemporalField temporalField, int i5, int i6, SignStyle signStyle) {
            this.field = temporalField;
            this.minWidth = i5;
            this.maxWidth = i6;
            this.signStyle = signStyle;
            this.subsequentWidth = 0;
        }

        private NumberPrinterParser(TemporalField temporalField, int i5, int i6, SignStyle signStyle, int i7) {
            this.field = temporalField;
            this.minWidth = i5;
            this.maxWidth = i6;
            this.signStyle = signStyle;
            this.subsequentWidth = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String noOffsetText;
        private final int type;
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser INSTANCE_ID = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("0", "+HH:MM:ss");

        OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.requireNonNull(str, "noOffsetText");
            Jdk8Methods.requireNonNull(str2, "pattern");
            this.noOffsetText = str;
            this.type = checkPattern(str2);
        }

        private int checkPattern(String str) {
            int i5 = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i5 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i5].equals(str)) {
                    return i5;
                }
                i5++;
            }
        }

        private boolean parseNumber(int[] iArr, int i5, CharSequence charSequence, boolean z5) {
            int i6;
            int i7 = this.type;
            if ((i7 + 3) / 2 < i5) {
                return false;
            }
            int i8 = iArr[0];
            if (i7 % 2 == 0 && i5 > 1) {
                int i9 = i8 + 1;
                if (i9 > charSequence.length() || charSequence.charAt(i8) != ':') {
                    return z5;
                }
                i8 = i9;
            }
            if (i8 + 2 > charSequence.length()) {
                return z5;
            }
            int i10 = i8 + 1;
            char charAt = charSequence.charAt(i8);
            int i11 = i8 + 2;
            char charAt2 = charSequence.charAt(i10);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i6 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || i6 > 59) {
                return z5;
            }
            iArr[i5] = i6;
            iArr[0] = i11;
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int length = charSequence.length();
            int length2 = this.noOffsetText.length();
            if (length2 == 0) {
                if (i5 == length) {
                    return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i5, i5);
                }
            } else {
                if (i5 == length) {
                    return ~i5;
                }
                if (dateTimeParseContext.subSequenceEquals(charSequence, i5, this.noOffsetText, 0, length2)) {
                    return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i5, i5 + length2);
                }
            }
            char charAt = charSequence.charAt(i5);
            if (charAt == '+' || charAt == '-') {
                int i6 = charAt == '-' ? -1 : 1;
                int[] iArr = new int[4];
                iArr[0] = i5 + 1;
                if (!parseNumber(iArr, 1, charSequence, true)) {
                    if (!parseNumber(iArr, 2, charSequence, this.type >= 3) && !parseNumber(iArr, 3, charSequence, false)) {
                        return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, i6 * ((iArr[1] * 3600) + (iArr[2] * 60) + iArr[3]), i5, iArr[0]);
                    }
                }
            }
            return length2 == 0 ? dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i5, i5 + length2) : ~i5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            int safeToInt = Jdk8Methods.safeToInt(value.longValue());
            if (safeToInt == 0) {
                sb.append(this.noOffsetText);
            } else {
                int abs = Math.abs((safeToInt / 3600) % 100);
                int abs2 = Math.abs((safeToInt / 60) % 60);
                int abs3 = Math.abs(safeToInt % 60);
                int length = sb.length();
                sb.append(safeToInt < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i5 = this.type;
                if (i5 >= 3 || (i5 >= 1 && abs2 > 0)) {
                    int i6 = i5 % 2;
                    String str = BuildConfig.FLAVOR;
                    sb.append(i6 == 0 ? ":" : BuildConfig.FLAVOR);
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i7 = this.type;
                    if (i7 >= 7 || (i7 >= 5 && abs3 > 0)) {
                        if (i7 % 2 == 0) {
                            str = ":";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                    sb.append(this.noOffsetText);
                }
            }
            return true;
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i5, char c5) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i5;
            this.padChar = c5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            boolean isStrict = dateTimeParseContext.isStrict();
            boolean isCaseSensitive = dateTimeParseContext.isCaseSensitive();
            if (i5 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (i5 == charSequence.length()) {
                return ~i5;
            }
            int i6 = this.padWidth + i5;
            if (i6 > charSequence.length()) {
                if (isStrict) {
                    return ~i5;
                }
                i6 = charSequence.length();
            }
            int i7 = i5;
            while (i7 < i6) {
                if (!isCaseSensitive) {
                    if (!dateTimeParseContext.charEquals(charSequence.charAt(i7), this.padChar)) {
                        break;
                    }
                    i7++;
                } else {
                    if (charSequence.charAt(i7) != this.padChar) {
                        break;
                    }
                    i7++;
                }
            }
            int parse = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, i6), i7);
            return (parse == i6 || !isStrict) ? parse : ~(i5 + i7);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.printerParser.print(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.padWidth) {
                for (int i5 = 0; i5 < this.padWidth - length2; i5++) {
                    sb.insert(length, this.padChar);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.padWidth);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Pad(");
            sb.append(this.printerParser);
            sb.append(",");
            sb.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                str = ",'" + this.padChar + "')";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        ReducedPrinterParser(TemporalField temporalField, int i5, int i6, int i7, ChronoLocalDate chronoLocalDate) {
            super(temporalField, i5, i6, SignStyle.NOT_NEGATIVE);
            if (i5 < 1 || i5 > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i5);
            }
            if (i6 < 1 || i6 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i6);
            }
            if (i6 >= i5) {
                if (chronoLocalDate == null) {
                    long j5 = i7;
                    if (!temporalField.range().isValidValue(j5)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    }
                    if (j5 + NumberPrinterParser.EXCEED_POINTS[i5] > 2147483647L) {
                        throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.baseValue = i7;
                this.baseDate = chronoLocalDate;
                return;
            }
            throw new IllegalArgumentException("The maxWidth must be greater than the width");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext dateTimePrintContext, long j5) {
            long abs = Math.abs(j5);
            int i5 = this.baseValue;
            if (this.baseDate != null) {
                i5 = Chronology.from(dateTimePrintContext.getTemporal()).date(this.baseDate).get(this.field);
            }
            if (j5 >= i5) {
                int i6 = NumberPrinterParser.EXCEED_POINTS[this.minWidth];
                if (j5 < i5 + i6) {
                    return abs % i6;
                }
            }
            return abs % NumberPrinterParser.EXCEED_POINTS[this.maxWidth];
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.isStrict()) {
                return super.isFixedWidth(dateTimeParseContext);
            }
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(DateTimeParseContext dateTimeParseContext, long j5, int i5, int i6) {
            int i7 = this.baseValue;
            if (this.baseDate != null) {
                i7 = dateTimeParseContext.getEffectiveChronology().date(this.baseDate).get(this.field);
                dateTimeParseContext.addChronologyChangedParser(this, j5, i5, i6);
            }
            int i8 = i6 - i5;
            int i9 = this.minWidth;
            if (i8 == i9 && j5 >= 0) {
                long j6 = NumberPrinterParser.EXCEED_POINTS[i9];
                long j7 = i7;
                long j8 = j7 - (j7 % j6);
                j5 = i7 > 0 ? j8 + j5 : j8 - j5;
                if (j5 < j7) {
                    j5 += j6;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, j5, i5, i6);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReducedValue(");
            sb.append(this.field);
            sb.append(",");
            sb.append(this.minWidth);
            sb.append(",");
            sb.append(this.maxWidth);
            sb.append(",");
            Object obj = this.baseDate;
            if (obj == null) {
                obj = Integer.valueOf(this.baseValue);
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withSubsequentWidth(int i5) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + i5);
        }

        private ReducedPrinterParser(TemporalField temporalField, int i5, int i6, int i7, ChronoLocalDate chronoLocalDate, int i8) {
            super(temporalField, i5, i6, SignStyle.NOT_NEGATIVE, i8);
            this.baseValue = i7;
            this.baseDate = chronoLocalDate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.setCaseSensitive(true);
            } else if (ordinal == 1) {
                dateTimeParseContext.setCaseSensitive(false);
            } else if (ordinal == 2) {
                dateTimeParseContext.setStrict(true);
            } else if (ordinal == 3) {
                dateTimeParseContext.setStrict(false);
            }
            return i5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            if (i5 > charSequence.length() || i5 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            return !dateTimeParseContext.subSequenceEquals(charSequence, i5, str, 0, str.length()) ? ~i5 : i5 + this.literal.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        public String toString() {
            return "'" + this.literal.replace("'", "''") + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            if (r0.hasNext() == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        
            r1 = r0.next();
            r2 = r1.getKey();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        
            if (r11.subSequenceEquals(r2, 0, r12, r13, r2.length()) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
        
            return r11.setParsedField(r10.field, r1.getValue().longValue(), r13, r13 + r2.length());
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        
            if (r11.isStrict() == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        
            return ~r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
        
            return numberPrinterParser().parse(r11, r12, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        
            if (r0 != null) goto L11;
         */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int length = charSequence.length();
            if (i5 < 0 || i5 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> textIterator = this.provider.getTextIterator(this.field, dateTimeParseContext.isStrict() ? this.textStyle : null, dateTimeParseContext.getLocale());
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            String text = this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale());
            if (text == null) {
                return numberPrinterParser().print(dateTimePrintContext, sb);
            }
            sb.append(text);
            return true;
        }

        public String toString() {
            if (this.textStyle == TextStyle.FULL) {
                return "Text(" + this.field + ")";
            }
            return "Text(" + this.field + "," + this.textStyle + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int count;
        private final char letter;

        public WeekFieldsPrinterParser(char c5, int i5) {
            this.letter = c5;
            this.count = i5;
        }

        private DateTimePrinterParser evaluate(WeekFields weekFields) {
            char c5 = this.letter;
            if (c5 == 'W') {
                return new NumberPrinterParser(weekFields.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c5 == 'Y') {
                if (this.count == 2) {
                    return new ReducedPrinterParser(weekFields.weekBasedYear(), 2, 2, 0, ReducedPrinterParser.BASE_DATE);
                }
                TemporalField weekBasedYear = weekFields.weekBasedYear();
                int i5 = this.count;
                return new NumberPrinterParser(weekBasedYear, i5, 19, i5 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            }
            if (c5 != 'c' && c5 != 'e') {
                if (c5 != 'w') {
                    return null;
                }
                return new NumberPrinterParser(weekFields.weekOfWeekBasedYear(), this.count, 2, SignStyle.NOT_NEGATIVE);
            }
            return new NumberPrinterParser(weekFields.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            return evaluate(WeekFields.of(dateTimeParseContext.getLocale())).parse(dateTimeParseContext, charSequence, i5);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return evaluate(WeekFields.of(dateTimePrintContext.getLocale())).print(dateTimePrintContext, sb);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c5 = this.letter;
            if (c5 == 'Y') {
                int i5 = this.count;
                if (i5 == 1) {
                    sb.append("WeekBasedYear");
                } else if (i5 == 2) {
                    sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.count);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
            } else {
                if (c5 == 'c' || c5 == 'e') {
                    sb.append("DayOfWeek");
                } else if (c5 == 'w') {
                    sb.append("WeekOfWeekBasedYear");
                } else if (c5 == 'W') {
                    sb.append("WeekOfMonth");
                }
                sb.append(",");
                sb.append(this.count);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> cachedSubstringTree;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SubstringTree {
            final int length;
            private final Map<CharSequence, SubstringTree> substringMap;
            private final Map<String, SubstringTree> substringMapCI;

            /* JADX INFO: Access modifiers changed from: private */
            public void add(String str) {
                int length = str.length();
                int i5 = this.length;
                if (length == i5) {
                    this.substringMap.put(str, null);
                    this.substringMapCI.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i5) {
                    String substring = str.substring(0, i5);
                    SubstringTree substringTree = this.substringMap.get(substring);
                    if (substringTree == null) {
                        substringTree = new SubstringTree(length);
                        this.substringMap.put(substring, substringTree);
                        this.substringMapCI.put(substring.toLowerCase(Locale.ENGLISH), substringTree);
                    }
                    substringTree.add(str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public SubstringTree get(CharSequence charSequence, boolean z5) {
                return z5 ? this.substringMap.get(charSequence) : this.substringMapCI.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            private SubstringTree(int i5) {
                this.substringMap = new HashMap();
                this.substringMapCI = new HashMap();
                this.length = i5;
            }
        }

        ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private ZoneId convertToZone(Set<String> set, String str, boolean z5) {
            if (str == null) {
                return null;
            }
            if (z5) {
                if (set.contains(str)) {
                    return ZoneId.of(str);
                }
                return null;
            }
            for (String str2 : set) {
                if (str2.equalsIgnoreCase(str)) {
                    return ZoneId.of(str2);
                }
            }
            return null;
        }

        private int parsePrefixedOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5, int i6) {
            String upperCase = charSequence.subSequence(i5, i6).toString().toUpperCase();
            DateTimeParseContext copy = dateTimeParseContext.copy();
            if (i6 < charSequence.length() && dateTimeParseContext.charEquals(charSequence.charAt(i6), 'Z')) {
                dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i6;
            }
            int parse = OffsetIdPrinterParser.INSTANCE_ID.parse(copy, charSequence, i6);
            if (parse < 0) {
                dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i6;
            }
            dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) copy.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
            return parse;
        }

        private static SubstringTree prepareParser(Set<String> set) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.LENGTH_SORT);
            SubstringTree substringTree = new SubstringTree(((String) arrayList.get(0)).length());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                substringTree.add((String) it.next());
            }
            return substringTree;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int i6;
            int length = charSequence.length();
            if (i5 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i5 == length) {
                return ~i5;
            }
            char charAt = charSequence.charAt(i5);
            if (charAt == '+' || charAt == '-') {
                DateTimeParseContext copy = dateTimeParseContext.copy();
                int parse = OffsetIdPrinterParser.INSTANCE_ID.parse(copy, charSequence, i5);
                if (parse < 0) {
                    return parse;
                }
                dateTimeParseContext.setParsed(ZoneOffset.ofTotalSeconds((int) copy.getParsed(ChronoField.OFFSET_SECONDS).longValue()));
                return parse;
            }
            int i7 = i5 + 2;
            if (length >= i7) {
                char charAt2 = charSequence.charAt(i5 + 1);
                if (dateTimeParseContext.charEquals(charAt, 'U') && dateTimeParseContext.charEquals(charAt2, 'T')) {
                    int i8 = i5 + 3;
                    return (length < i8 || !dateTimeParseContext.charEquals(charSequence.charAt(i7), 'C')) ? parsePrefixedOffset(dateTimeParseContext, charSequence, i5, i7) : parsePrefixedOffset(dateTimeParseContext, charSequence, i5, i8);
                }
                if (dateTimeParseContext.charEquals(charAt, 'G') && length >= (i6 = i5 + 3) && dateTimeParseContext.charEquals(charAt2, 'M') && dateTimeParseContext.charEquals(charSequence.charAt(i7), 'T')) {
                    return parsePrefixedOffset(dateTimeParseContext, charSequence, i5, i6);
                }
            }
            Set<String> availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map.Entry<Integer, SubstringTree> entry = cachedSubstringTree;
            if (entry == null || entry.getKey().intValue() != size) {
                synchronized (this) {
                    try {
                        entry = cachedSubstringTree;
                        if (entry != null) {
                            if (entry.getKey().intValue() != size) {
                            }
                        }
                        entry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), prepareParser(availableZoneIds));
                        cachedSubstringTree = entry;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            SubstringTree value = entry.getValue();
            String str = null;
            String str2 = null;
            while (value != null) {
                int i9 = value.length + i5;
                if (i9 > length) {
                    break;
                }
                String charSequence2 = charSequence.subSequence(i5, i9).toString();
                value = value.get(charSequence2, dateTimeParseContext.isCaseSensitive());
                str2 = str;
                str = charSequence2;
            }
            ZoneId convertToZone = convertToZone(availableZoneIds, str, dateTimeParseContext.isCaseSensitive());
            if (convertToZone == null) {
                convertToZone = convertToZone(availableZoneIds, str2, dateTimeParseContext.isCaseSensitive());
                if (convertToZone == null) {
                    if (!dateTimeParseContext.charEquals(charAt, 'Z')) {
                        return ~i5;
                    }
                    dateTimeParseContext.setParsed(ZoneOffset.UTC);
                    return i5 + 1;
                }
                str = str2;
            }
            dateTimeParseContext.setParsed(convertToZone);
            return i5 + str.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(this.query);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> LENGTH_COMPARATOR = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        };
        private final TextStyle textStyle;

        ZoneTextPrinterParser(TextStyle textStyle) {
            this.textStyle = (TextStyle) Jdk8Methods.requireNonNull(textStyle, "textStyle");
        }

        private int parseOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5, String str) {
            int length = str.length();
            int i6 = i5 + length;
            if (i6 >= charSequence.length()) {
                dateTimeParseContext.setParsed(ZoneId.of(str));
                return i6;
            }
            char charAt = charSequence.charAt(i6);
            if (charAt != '+' && charAt != '-') {
                dateTimeParseContext.setParsed(ZoneId.of(str));
                return i6;
            }
            DateTimeParseContext copy = dateTimeParseContext.copy();
            try {
                int parse = OffsetIdPrinterParser.INSTANCE_ID_ZERO.parse(copy, charSequence, i6);
                if (parse < 0) {
                    dateTimeParseContext.setParsed(ZoneId.of(str));
                    return i6;
                }
                ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds((int) copy.getParsed(ChronoField.OFFSET_SECONDS).longValue());
                dateTimeParseContext.setParsed(length == 0 ? ofTotalSeconds : ZoneId.ofOffset(str, ofTotalSeconds));
                return parse;
            } catch (DateTimeException unused) {
                return ~i5;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i5) {
            int length = charSequence.length();
            if (i5 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i5 == length) {
                return ~i5;
            }
            char charAt = charSequence.charAt(i5);
            if (charAt == '+' || charAt == '-') {
                return i5 + 6 > length ? ~i5 : parseOffset(dateTimeParseContext, charSequence, i5, BuildConfig.FLAVOR);
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i5, "GMT", 0, 3)) {
                return parseOffset(dateTimeParseContext, charSequence, i5, "GMT");
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i5, "UTC", 0, 3)) {
                return parseOffset(dateTimeParseContext, charSequence, i5, "UTC");
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i5, "UT", 0, 2)) {
                return parseOffset(dateTimeParseContext, charSequence, i5, "UT");
            }
            TreeMap treeMap = new TreeMap(LENGTH_COMPARATOR);
            for (String str : ZoneId.getAvailableZoneIds()) {
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                int i6 = this.textStyle.asNormal() == TextStyle.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i6, dateTimeParseContext.getLocale());
                if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, str);
                }
                String displayName2 = timeZone.getDisplayName(true, i6, dateTimeParseContext.getLocale());
                if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, str);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (dateTimeParseContext.subSequenceEquals(charSequence, i5, str2, 0, str2.length())) {
                    dateTimeParseContext.setParsed(ZoneId.of((String) entry.getValue()));
                    return i5 + str2.length();
                }
            }
            if (charAt != 'Z') {
                return ~i5;
            }
            dateTimeParseContext.setParsed(ZoneOffset.UTC);
            return i5 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(TemporalQueries.zoneId());
            if (zoneId == null) {
                return false;
            }
            if (zoneId.normalized() instanceof ZoneOffset) {
                sb.append(zoneId.getId());
                return true;
            }
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            sb.append(TimeZone.getTimeZone(zoneId.getId()).getDisplayName(temporal.isSupported(chronoField) ? zoneId.getRules().isDaylightSavings(Instant.ofEpochSecond(temporal.getLong(chronoField))) : false, this.textStyle.asNormal() == TextStyle.FULL ? 1 : 0, dateTimePrintContext.getLocale()));
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.textStyle + ")";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.3
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
            }
        };
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i5 = dateTimeFormatterBuilder.padNextWidth;
        if (i5 > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i5, dateTimeFormatterBuilder.padNextChar);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = (char) 0;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        this.active.valueParserIndex = -1;
        return r4.printerParsers.size() - 1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x002f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseField(char c5, int i5, TemporalField temporalField) {
        if (c5 != 'Q') {
            if (c5 == 'S') {
                appendFraction(ChronoField.NANO_OF_SECOND, i5, i5, false);
                return;
            }
            if (c5 == 'a') {
                if (i5 == 1) {
                    appendText(temporalField, TextStyle.SHORT);
                    return;
                }
                throw new IllegalArgumentException("Too many pattern letters: " + c5);
            }
            if (c5 != 'h' && c5 != 'k' && c5 != 'm') {
                if (c5 != 'q') {
                    if (c5 != 's') {
                        if (c5 == 'u' || c5 == 'y') {
                            if (i5 == 2) {
                                appendValueReduced(temporalField, 2, 2, ReducedPrinterParser.BASE_DATE);
                                return;
                            } else if (i5 < 4) {
                                appendValue(temporalField, i5, 19, SignStyle.NORMAL);
                                return;
                            } else {
                                appendValue(temporalField, i5, 19, SignStyle.EXCEEDS_PAD);
                                return;
                            }
                        }
                        switch (c5) {
                            case 'D':
                                if (i5 == 1) {
                                    appendValue(temporalField);
                                    return;
                                } else {
                                    if (i5 <= 3) {
                                        appendValue(temporalField, i5);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                                }
                            case 'E':
                            case 'G':
                                if (i5 == 1 || i5 == 2 || i5 == 3) {
                                    appendText(temporalField, TextStyle.SHORT);
                                    return;
                                }
                                if (i5 == 4) {
                                    appendText(temporalField, TextStyle.FULL);
                                    return;
                                } else {
                                    if (i5 == 5) {
                                        appendText(temporalField, TextStyle.NARROW);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                                }
                            case 'F':
                                if (i5 == 1) {
                                    appendValue(temporalField);
                                    return;
                                }
                                throw new IllegalArgumentException("Too many pattern letters: " + c5);
                            default:
                                switch (c5) {
                                    case 'K':
                                        break;
                                    case 'L':
                                        break;
                                    case 'M':
                                        break;
                                    default:
                                        switch (c5) {
                                            case 'c':
                                                if (i5 == 1) {
                                                    appendInternal(new WeekFieldsPrinterParser('c', i5));
                                                    return;
                                                }
                                                if (i5 == 2) {
                                                    throw new IllegalArgumentException("Invalid number of pattern letters: " + c5);
                                                }
                                                if (i5 == 3) {
                                                    appendText(temporalField, TextStyle.SHORT_STANDALONE);
                                                    return;
                                                }
                                                if (i5 == 4) {
                                                    appendText(temporalField, TextStyle.FULL_STANDALONE);
                                                    return;
                                                } else {
                                                    if (i5 == 5) {
                                                        appendText(temporalField, TextStyle.NARROW_STANDALONE);
                                                        return;
                                                    }
                                                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                                                }
                                            case 'd':
                                                break;
                                            case 'e':
                                                if (i5 == 1 || i5 == 2) {
                                                    appendInternal(new WeekFieldsPrinterParser('e', i5));
                                                    return;
                                                }
                                                if (i5 == 3) {
                                                    appendText(temporalField, TextStyle.SHORT);
                                                    return;
                                                }
                                                if (i5 == 4) {
                                                    appendText(temporalField, TextStyle.FULL);
                                                    return;
                                                } else {
                                                    if (i5 == 5) {
                                                        appendText(temporalField, TextStyle.NARROW);
                                                        return;
                                                    }
                                                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                                                }
                                            default:
                                                if (i5 == 1) {
                                                    appendValue(temporalField);
                                                    return;
                                                } else {
                                                    appendValue(temporalField, i5);
                                                    return;
                                                }
                                        }
                                }
                            case 'H':
                                if (i5 != 1) {
                                    appendValue(temporalField);
                                    return;
                                } else {
                                    if (i5 == 2) {
                                        appendValue(temporalField, i5);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                                }
                        }
                    }
                }
                if (i5 == 1) {
                    appendValue(temporalField);
                    return;
                }
                if (i5 == 2) {
                    appendValue(temporalField, 2);
                    return;
                }
                if (i5 == 3) {
                    appendText(temporalField, TextStyle.SHORT_STANDALONE);
                    return;
                }
                if (i5 == 4) {
                    appendText(temporalField, TextStyle.FULL_STANDALONE);
                    return;
                } else {
                    if (i5 == 5) {
                        appendText(temporalField, TextStyle.NARROW_STANDALONE);
                        return;
                    }
                    throw new IllegalArgumentException("Too many pattern letters: " + c5);
                }
            }
            if (i5 != 1) {
            }
        }
        if (i5 == 1) {
            appendValue(temporalField);
            return;
        }
        if (i5 == 2) {
            appendValue(temporalField, 2);
            return;
        }
        if (i5 == 3) {
            appendText(temporalField, TextStyle.SHORT);
            return;
        }
        if (i5 == 4) {
            appendText(temporalField, TextStyle.FULL);
        } else {
            if (i5 == 5) {
                appendText(temporalField, TextStyle.NARROW);
                return;
            }
            throw new IllegalArgumentException("Too many pattern letters: " + c5);
        }
    }

    private void parsePattern(String str) {
        int i5;
        int i6 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i7 = i6 + 1;
                while (i7 < str.length() && str.charAt(i7) == charAt) {
                    i7++;
                }
                int i8 = i7 - i6;
                if (charAt == 'p') {
                    if (i7 >= str.length() || (((charAt = str.charAt(i7)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i5 = i8;
                        i8 = 0;
                    } else {
                        int i9 = i7 + 1;
                        while (i9 < str.length() && str.charAt(i9) == charAt) {
                            i9++;
                        }
                        i5 = i9 - i7;
                        i7 = i9;
                    }
                    if (i8 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    padNext(i8);
                    i8 = i5;
                }
                TemporalField temporalField = FIELD_MAP.get(Character.valueOf(charAt));
                if (temporalField != null) {
                    parseField(charAt, i8, temporalField);
                } else if (charAt == 'z') {
                    if (i8 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    }
                    if (i8 == 4) {
                        appendZoneText(TextStyle.FULL);
                    } else {
                        appendZoneText(TextStyle.SHORT);
                    }
                } else if (charAt != 'V') {
                    String str2 = "+0000";
                    if (charAt == 'Z') {
                        if (i8 < 4) {
                            appendOffset("+HHMM", "+0000");
                        } else if (i8 == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else {
                            if (i8 != 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                            appendOffset("+HH:MM:ss", "Z");
                        }
                    } else if (charAt == 'O') {
                        if (i8 == 1) {
                            appendLocalizedOffset(TextStyle.SHORT);
                        } else {
                            if (i8 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + charAt);
                            }
                            appendLocalizedOffset(TextStyle.FULL);
                        }
                    } else if (charAt == 'X') {
                        if (i8 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        appendOffset(OffsetIdPrinterParser.PATTERNS[i8 + (i8 == 1 ? 0 : 1)], "Z");
                    } else if (charAt == 'x') {
                        if (i8 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        if (i8 == 1) {
                            str2 = "+00";
                        } else if (i8 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        appendOffset(OffsetIdPrinterParser.PATTERNS[i8 + (i8 == 1 ? 0 : 1)], str2);
                    } else if (charAt == 'W') {
                        if (i8 > 1) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        appendInternal(new WeekFieldsPrinterParser('W', i8));
                    } else if (charAt == 'w') {
                        if (i8 > 2) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        appendInternal(new WeekFieldsPrinterParser('w', i8));
                    } else {
                        if (charAt != 'Y') {
                            throw new IllegalArgumentException("Unknown pattern letter: " + charAt);
                        }
                        appendInternal(new WeekFieldsPrinterParser('Y', i8));
                    }
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + charAt);
                    }
                    appendZoneId();
                }
                i6 = i7 - 1;
            } else if (charAt == '\'') {
                int i10 = i6 + 1;
                int i11 = i10;
                while (i11 < str.length()) {
                    if (str.charAt(i11) == '\'') {
                        int i12 = i11 + 1;
                        if (i12 >= str.length() || str.charAt(i12) != '\'') {
                            break;
                        } else {
                            i11 = i12;
                        }
                    }
                    i11++;
                }
                if (i11 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String substring = str.substring(i10, i11);
                if (substring.length() == 0) {
                    appendLiteral('\'');
                } else {
                    appendLiteral(substring.replace("''", "'"));
                }
                i6 = i11;
            } else if (charAt == '[') {
                optionalStart();
            } else if (charAt == ']') {
                if (this.active.parent == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                optionalEnd();
            } else {
                if (charAt == '{' || charAt == '}' || charAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
                }
                appendLiteral(charAt);
            }
            i6++;
        }
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int i5, int i6, boolean z5) {
        appendInternal(new FractionPrinterParser(temporalField, i5, i6, z5));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c5) {
        appendInternal(new CharLiteralPrinterParser(c5));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalized(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        appendInternal(new LocalizedPrinterParser(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Jdk8Methods.requireNonNull(textStyle, "style");
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        appendInternal(new LocalizedOffsetPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID);
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        Jdk8Methods.requireNonNull(str, "pattern");
        parsePattern(str);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i5, int i6, ChronoLocalDate chronoLocalDate) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(chronoLocalDate, "baseDate");
        appendValue(new ReducedPrinterParser(temporalField, i5, i6, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
            this.active = this.active.parent;
            appendInternal(compositePrinterParser);
        } else {
            this.active = this.active.parent;
        }
        return this;
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i5) {
        return padNext(i5, ' ');
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseDefaulting(TemporalField temporalField, long j5) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendInternal(new DefaultingParser(temporalField, j5));
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Jdk8Methods.requireNonNull(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                appendInternal(new CharLiteralPrinterParser(str.charAt(0)));
            } else {
                appendInternal(new StringLiteralPrinterParser(str));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i5, char c5) {
        if (i5 >= 1) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
            dateTimeFormatterBuilder.padNextWidth = i5;
            dateTimeFormatterBuilder.padNextChar = c5;
            dateTimeFormatterBuilder.valueParserIndex = -1;
            return this;
        }
        throw new IllegalArgumentException("The pad width must be at least one but was " + i5);
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, ResolverStyle.SMART, null, null, null);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i5) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        if (i5 >= 1 && i5 <= 19) {
            appendValue(new NumberPrinterParser(temporalField, i5, i5, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i5);
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map<Long, String> map) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.2
            @Override // org.threeten.bp.format.DateTimeTextProvider
            public String getText(TemporalField temporalField2, long j5, TextStyle textStyle2, Locale locale) {
                return localeStore.getText(j5, textStyle2);
            }

            @Override // org.threeten.bp.format.DateTimeTextProvider
            public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField2, TextStyle textStyle2, Locale locale) {
                return localeStore.getTextIterator(textStyle2);
            }
        }));
        return this;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z5) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z5;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i5, int i6, SignStyle signStyle) {
        if (i5 == i6 && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(temporalField, i6);
        }
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(signStyle, "signStyle");
        if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i5);
        }
        if (i6 < 1 || i6 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i6);
        }
        if (i6 >= i5) {
            appendValue(new NumberPrinterParser(temporalField, i5, i6, signStyle));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i6 + " < " + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle) {
        return toFormatter().withResolverStyle(resolverStyle);
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser withFixedWidth;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i5 = dateTimeFormatterBuilder.valueParserIndex;
        if (i5 >= 0 && (dateTimeFormatterBuilder.printerParsers.get(i5) instanceof NumberPrinterParser)) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            int i6 = dateTimeFormatterBuilder2.valueParserIndex;
            NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder2.printerParsers.get(i6);
            int i7 = numberPrinterParser.minWidth;
            int i8 = numberPrinterParser.maxWidth;
            if (i7 == i8 && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                withFixedWidth = numberPrinterParser2.withSubsequentWidth(i8);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = i6;
            } else {
                withFixedWidth = numberPrinterParser2.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i6, withFixedWidth);
        } else {
            this.active.valueParserIndex = appendInternal(numberPrinterParser);
        }
        return this;
    }
}
