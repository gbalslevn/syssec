package org.threeten.bp;

import com.adjust.sdk.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public final class LocalDate extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(-999999999, 1, 1);
    public static final LocalDate MAX = of(999999999, 12, 31);
    public static final TemporalQuery<LocalDate> FROM = new TemporalQuery<LocalDate>() { // from class: org.threeten.bp.LocalDate.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDate.from(temporalAccessor);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.LocalDate$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int i5, int i6, int i7) {
        this.year = i5;
        this.month = (short) i6;
        this.day = (short) i7;
    }

    private static LocalDate create(int i5, Month month, int i6) {
        if (i6 <= 28 || i6 <= month.length(IsoChronology.INSTANCE.isLeapYear(i5))) {
            return new LocalDate(i5, month.getValue(), i6);
        }
        if (i6 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i5 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month.name() + " " + i6 + "'");
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i5 = this.year;
                return i5 >= 1 ? i5 : 1 - i5;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long getProlepticMonth() {
        return (this.year * 12) + (this.month - 1);
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + localDate.getDayOfMonth()) - ((getProlepticMonth() * 32) + getDayOfMonth())) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int i5, Month month, int i6) {
        ChronoField.YEAR.checkValidValue(i5);
        Jdk8Methods.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i6);
        return create(i5, month, i6);
    }

    public static LocalDate ofEpochDay(long j5) {
        long j6;
        ChronoField.EPOCH_DAY.checkValidValue(j5);
        long j7 = 719468 + j5;
        if (j7 < 0) {
            long j8 = ((j5 + 719469) / 146097) - 1;
            j6 = j8 * 400;
            j7 += (-j8) * 146097;
        } else {
            j6 = 0;
        }
        long j9 = ((j7 * 400) + 591) / 146097;
        long j10 = j7 - ((((j9 * 365) + (j9 / 4)) - (j9 / 100)) + (j9 / 400));
        if (j10 < 0) {
            j9--;
            j10 = j7 - ((((365 * j9) + (j9 / 4)) - (j9 / 100)) + (j9 / 400));
        }
        int i5 = (int) j10;
        int i6 = ((i5 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j9 + j6 + (i6 / 10)), ((i6 + 2) % 12) + 1, (i5 - (((i6 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i5, int i6) {
        long j5 = i5;
        ChronoField.YEAR.checkValidValue(j5);
        ChronoField.DAY_OF_YEAR.checkValidValue(i6);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j5);
        if (i6 != 366 || isLeapYear) {
            Month of = Month.of(((i6 - 1) / 31) + 1);
            if (i6 > (of.firstDayOfYear(isLeapYear) + of.length(isLeapYear)) - 1) {
                of = of.plus(1L);
            }
            return create(i5, of, (i6 - of.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i5 + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, FROM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalDate readExternal(DataInput dataInput) {
        return of(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i5, int i6, int i7) {
        if (i6 == 2) {
            i7 = Math.min(i7, IsoChronology.INSTANCE.isLeapYear((long) i5) ? 29 : 28);
        } else if (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) {
            i7 = Math.min(i7, 30);
        }
        return of(i5, i6, i7);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareTo0(LocalDate localDate) {
        int i5 = this.year - localDate.year;
        if (i5 != 0) {
            return i5;
        }
        int i6 = this.month - localDate.month;
        return i6 == 0 ? this.day - localDate.day : i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(Jdk8Methods.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.EPOCH_DAY ? toEpochDay() : temporalField == ChronoField.PROLEPTIC_MONTH ? getProlepticMonth() : get0(temporalField) : temporalField.getFrom(this);
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
        int i5 = this.year;
        return (((i5 << 11) + (this.month << 6)) + this.day) ^ (i5 & (-2048));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) > 0 : super.isAfter(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) < 0 : super.isBefore(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) == 0 : super.isEqual(chronoLocalDate);
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        short s5 = this.month;
        return s5 != 2 ? (s5 == 4 || s5 == 6 || s5 == 9 || s5 == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public LocalDate minusDays(long j5) {
        return j5 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j5);
    }

    public LocalDate minusYears(long j5) {
        return j5 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j5);
    }

    public LocalDate plusDays(long j5) {
        return j5 == 0 ? this : ofEpochDay(Jdk8Methods.safeAdd(toEpochDay(), j5));
    }

    public LocalDate plusMonths(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = (this.year * 12) + (this.month - 1) + j5;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j6, 12L)), Jdk8Methods.floorMod(j6, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j5) {
        return plusDays(Jdk8Methods.safeMultiply(j5, 7));
    }

    public LocalDate plusYears(long j5) {
        return j5 == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j5), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (!chronoField.isDateBased()) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i5 == 1) {
            return ValueRange.of(1L, lengthOfMonth());
        }
        if (i5 == 2) {
            return ValueRange.of(1L, lengthOfYear());
        }
        if (i5 == 3) {
            return ValueRange.of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
        }
        if (i5 != 4) {
            return temporalField.range();
        }
        return ValueRange.of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j5 = this.year;
        long j6 = this.month;
        long j7 = 365 * j5;
        long j8 = (j5 >= 0 ? j7 + (((3 + j5) / 4) - ((99 + j5) / 100)) + ((j5 + 399) / 400) : j7 - (((j5 / (-4)) - (j5 / (-100))) + (j5 / (-400)))) + (((367 * j6) - 362) / 12) + (this.day - 1);
        if (j6 > 2) {
            j8 = !isLeapYear() ? j8 - 2 : j8 - 1;
        }
        return j8 - 719528;
    }

    public String toString() {
        int i5 = this.year;
        short s5 = this.month;
        short s6 = this.day;
        int abs = Math.abs(i5);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i5 > 9999) {
                sb.append('+');
            }
            sb.append(i5);
        } else if (i5 < 0) {
            sb.append(i5 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i5 + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s5 < 10 ? "-0" : "-");
        sb.append((int) s5);
        sb.append(s6 < 10 ? "-0" : "-");
        sb.append((int) s6);
        return sb.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return daysUntil(from);
            case 2:
                return daysUntil(from) / 7;
            case 3:
                return monthsUntil(from);
            case 4:
                return monthsUntil(from) / 12;
            case 5:
                return monthsUntil(from) / 120;
            case 6:
                return monthsUntil(from) / 1200;
            case 7:
                return monthsUntil(from) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalDate withDayOfMonth(int i5) {
        return this.day == i5 ? this : of(this.year, this.month, i5);
    }

    public LocalDate withDayOfYear(int i5) {
        return getDayOfYear() == i5 ? this : ofYearDay(this.year, i5);
    }

    public LocalDate withMonth(int i5) {
        if (this.month == i5) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(i5);
        return resolvePreviousValid(this.year, i5, this.day);
    }

    public LocalDate withYear(int i5) {
        if (this.year == i5) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(i5);
        return resolvePreviousValid(i5, this.month, this.day);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static LocalDate now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return ofEpochDay(Jdk8Methods.floorDiv(clock.instant().getEpochSecond() + clock.getZone().getRules().getOffset(r0).getTotalSeconds(), 86400L));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // java.lang.Comparable
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public LocalDateTime atTime(int i5, int i6) {
        return atTime(LocalTime.of(i5, i6));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDate minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public LocalDate plus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.addTo(this);
    }

    public static LocalDate of(int i5, int i6, int i7) {
        ChronoField.YEAR.checkValidValue(i5);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i6);
        ChronoField.DAY_OF_MONTH.checkValidValue(i7);
        return create(i5, Month.of(i6), i7);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDate plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j5);
                case 2:
                    return plusWeeks(j5);
                case 3:
                    return plusMonths(j5);
                case 4:
                    return plusYears(j5);
                case 5:
                    return plusYears(Jdk8Methods.safeMultiply(j5, 10));
                case 6:
                    return plusYears(Jdk8Methods.safeMultiply(j5, 100));
                case 7:
                    return plusYears(Jdk8Methods.safeMultiply(j5, Constants.ONE_SECOND));
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j5));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalDate) temporalUnit.addTo(this, j5);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j5);
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withDayOfMonth((int) j5);
                case 2:
                    return withDayOfYear((int) j5);
                case 3:
                    return plusWeeks(j5 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.year < 1) {
                        j5 = 1 - j5;
                    }
                    return withYear((int) j5);
                case 5:
                    return plusDays(j5 - getDayOfWeek().getValue());
                case 6:
                    return plusDays(j5 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j5 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(j5);
                case 9:
                    return plusWeeks(j5 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    return withMonth((int) j5);
                case 11:
                    return plusMonths(j5 - getLong(ChronoField.PROLEPTIC_MONTH));
                case 12:
                    return withYear((int) j5);
                case 13:
                    return getLong(ChronoField.ERA) == j5 ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (LocalDate) temporalField.adjustInto(this, j5);
    }
}
