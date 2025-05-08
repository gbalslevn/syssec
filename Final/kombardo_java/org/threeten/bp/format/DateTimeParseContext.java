package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DateTimeParseContext {
    private boolean caseSensitive;
    private Locale locale;
    private Chronology overrideChronology;
    private ZoneId overrideZone;
    private final ArrayList<Parsed> parsed;
    private boolean strict;
    private DecimalStyle symbols;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class Parsed extends DefaultInterfaceTemporalAccessor {
        List<Object[]> callbacks;
        Chronology chrono;
        Period excessDays;
        final Map<TemporalField, Long> fieldValues;
        boolean leapSecond;
        ZoneId zone;

        protected Parsed copy() {
            Parsed parsed = new Parsed();
            parsed.chrono = this.chrono;
            parsed.zone = this.zone;
            parsed.fieldValues.putAll(this.fieldValues);
            parsed.leapSecond = this.leapSecond;
            return parsed;
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public int get(TemporalField temporalField) {
            if (this.fieldValues.containsKey(temporalField)) {
                return Jdk8Methods.safeToInt(this.fieldValues.get(temporalField).longValue());
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField temporalField) {
            if (this.fieldValues.containsKey(temporalField)) {
                return this.fieldValues.get(temporalField).longValue();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField temporalField) {
            return this.fieldValues.containsKey(temporalField);
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public <R> R query(TemporalQuery<R> temporalQuery) {
            return temporalQuery == TemporalQueries.chronology() ? (R) this.chrono : (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone()) ? (R) this.zone : (R) super.query(temporalQuery);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DateTimeBuilder toBuilder() {
            DateTimeBuilder dateTimeBuilder = new DateTimeBuilder();
            dateTimeBuilder.fieldValues.putAll(this.fieldValues);
            dateTimeBuilder.chrono = DateTimeParseContext.this.getEffectiveChronology();
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                dateTimeBuilder.zone = zoneId;
            } else {
                dateTimeBuilder.zone = DateTimeParseContext.this.overrideZone;
            }
            dateTimeBuilder.leapSecond = this.leapSecond;
            dateTimeBuilder.excessDays = this.excessDays;
            return dateTimeBuilder;
        }

        public String toString() {
            return this.fieldValues.toString() + "," + this.chrono + "," + this.zone;
        }

        private Parsed() {
            this.chrono = null;
            this.zone = null;
            this.fieldValues = new HashMap();
            this.excessDays = Period.ZERO;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeFormatter.getLocale();
        this.symbols = dateTimeFormatter.getDecimalStyle();
        this.overrideChronology = dateTimeFormatter.getChronology();
        this.overrideZone = dateTimeFormatter.getZone();
        arrayList.add(new Parsed());
    }

    static boolean charEqualsIgnoreCase(char c5, char c6) {
        return c5 == c6 || Character.toUpperCase(c5) == Character.toUpperCase(c6) || Character.toLowerCase(c5) == Character.toLowerCase(c6);
    }

    private Parsed currentParsed() {
        return this.parsed.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChronologyChangedParser(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, long j5, int i5, int i6) {
        Parsed currentParsed = currentParsed();
        if (currentParsed.callbacks == null) {
            currentParsed.callbacks = new ArrayList(2);
        }
        currentParsed.callbacks.add(new Object[]{reducedPrinterParser, Long.valueOf(j5), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean charEquals(char c5, char c6) {
        return isCaseSensitive() ? c5 == c6 : charEqualsIgnoreCase(c5, c6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext copy() {
        return new DateTimeParseContext(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endOptional(boolean z5) {
        if (z5) {
            this.parsed.remove(r2.size() - 2);
        } else {
            this.parsed.remove(r2.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Chronology getEffectiveChronology() {
        Chronology chronology = currentParsed().chrono;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.overrideChronology;
        return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.locale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getParsed(TemporalField temporalField) {
        return currentParsed().fieldValues.get(temporalField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalStyle getSymbols() {
        return this.symbols;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStrict() {
        return this.strict;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCaseSensitive(boolean z5) {
        this.caseSensitive = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsed(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        currentParsed().zone = zoneId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setParsedField(TemporalField temporalField, long j5, int i5, int i6) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long put = currentParsed().fieldValues.put(temporalField, Long.valueOf(j5));
        return (put == null || put.longValue() == j5) ? i6 : ~i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrict(boolean z5) {
        this.strict = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean subSequenceEquals(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7) {
        if (i5 + i7 > charSequence.length() || i6 + i7 > charSequence2.length()) {
            return false;
        }
        if (isCaseSensitive()) {
            for (int i8 = 0; i8 < i7; i8++) {
                if (charSequence.charAt(i5 + i8) != charSequence2.charAt(i6 + i8)) {
                    return false;
                }
            }
            return true;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            char charAt = charSequence.charAt(i5 + i9);
            char charAt2 = charSequence2.charAt(i6 + i9);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parsed toParsed() {
        return currentParsed();
    }

    public String toString() {
        return currentParsed().toString();
    }

    DateTimeParseContext(DateTimeParseContext dateTimeParseContext) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeParseContext.locale;
        this.symbols = dateTimeParseContext.symbols;
        this.overrideChronology = dateTimeParseContext.overrideChronology;
        this.overrideZone = dateTimeParseContext.overrideZone;
        this.caseSensitive = dateTimeParseContext.caseSensitive;
        this.strict = dateTimeParseContext.strict;
        arrayList.add(new Parsed());
    }
}
