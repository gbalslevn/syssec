package org.threeten.bp;

import com.adjust.sdk.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public static final TemporalQuery<YearMonth> FROM = new TemporalQuery<YearMonth>() { // from class: org.threeten.bp.YearMonth.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public YearMonth queryFrom(TemporalAccessor temporalAccessor) {
            return YearMonth.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.YearMonth$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.MONTHS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private YearMonth(int i5, int i6) {
        this.year = i5;
        this.month = i6;
    }

    public static YearMonth from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof YearMonth) {
            return (YearMonth) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR), temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private long getProlepticMonth() {
        return (this.year * 12) + (this.month - 1);
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth of(int i5, Month month) {
        Jdk8Methods.requireNonNull(month, "month");
        return of(i5, month.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static YearMonth readExternal(DataInput dataInput) {
        return of(dataInput.readInt(), dataInput.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i5) {
        return LocalDate.of(this.year, this.month, i5);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        return this.year == yearMonth.year && this.month == yearMonth.month;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i5;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i6 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i6 == 1) {
            i5 = this.month;
        } else {
            if (i6 == 2) {
                return getProlepticMonth();
            }
            if (i6 == 3) {
                int i7 = this.year;
                if (i7 < 1) {
                    i7 = 1 - i7;
                }
                return i7;
            }
            if (i6 != 4) {
                if (i6 == 5) {
                    return this.year < 1 ? 0 : 1;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i5 = this.year;
        }
        return i5;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        return this.year ^ (this.month << 27);
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public YearMonth minusMonths(long j5) {
        return j5 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j5);
    }

    public YearMonth plusMonths(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = (this.year * 12) + (this.month - 1) + j5;
        return with(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j6, 12L)), Jdk8Methods.floorMod(j6, 12) + 1);
    }

    public YearMonth plusYears(long j5) {
        return j5 == 0 ? this : with(ChronoField.YEAR.checkValidIntValue(this.year + j5), this.month);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
        }
        return super.range(temporalField);
    }

    public String toString() {
        int abs = Math.abs(this.year);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i5 = this.year;
            if (i5 < 0) {
                sb.append(i5 - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i5 + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.year);
        }
        sb.append(this.month < 10 ? "-0" : "-");
        sb.append(this.month);
        return sb.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return prolepticMonth;
            case 2:
                return prolepticMonth / 12;
            case 3:
                return prolepticMonth / 120;
            case 4:
                return prolepticMonth / 1200;
            case 5:
                return prolepticMonth / 12000;
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth withMonth(int i5) {
        ChronoField.MONTH_OF_YEAR.checkValidValue(i5);
        return with(this.year, i5);
    }

    public YearMonth withYear(int i5) {
        ChronoField.YEAR.checkValidValue(i5);
        return with(i5, this.month);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    public static YearMonth now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getYear(), now.getMonth());
    }

    @Override // java.lang.Comparable
    public int compareTo(YearMonth yearMonth) {
        int i5 = this.year - yearMonth.year;
        return i5 == 0 ? this.month - yearMonth.month : i5;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusMonths(j5);
                case 2:
                    return plusYears(j5);
                case 3:
                    return plusYears(Jdk8Methods.safeMultiply(j5, 10));
                case 4:
                    return plusYears(Jdk8Methods.safeMultiply(j5, 100));
                case 5:
                    return plusYears(Jdk8Methods.safeMultiply(j5, Constants.ONE_SECOND));
                case 6:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j5));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (YearMonth) temporalUnit.addTo(this, j5);
    }

    public static YearMonth of(int i5, int i6) {
        ChronoField.YEAR.checkValidValue(i5);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i6);
        return new YearMonth(i5, i6);
    }

    private YearMonth with(int i5, int i6) {
        return (this.year == i5 && this.month == i6) ? this : new YearMonth(i5, i6);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j5);
            int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i5 == 1) {
                return withMonth((int) j5);
            }
            if (i5 == 2) {
                return plusMonths(j5 - getLong(ChronoField.PROLEPTIC_MONTH));
            }
            if (i5 == 3) {
                if (this.year < 1) {
                    j5 = 1 - j5;
                }
                return withYear((int) j5);
            }
            if (i5 == 4) {
                return withYear((int) j5);
            }
            if (i5 == 5) {
                return getLong(ChronoField.ERA) == j5 ? this : withYear(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (YearMonth) temporalField.adjustInto(this, j5);
    }
}
