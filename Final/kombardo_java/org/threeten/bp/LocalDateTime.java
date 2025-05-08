package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
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
public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);
    public static final TemporalQuery<LocalDateTime> FROM = new TemporalQuery<LocalDateTime>() { // from class: org.threeten.bp.LocalDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDateTime.from(temporalAccessor);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.LocalDateTime$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.toLocalDate());
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.toLocalTime()) : compareTo0;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [org.threeten.bp.LocalDateTime] */
    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime2();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime of(int i5, int i6, int i7, int i8, int i9) {
        return new LocalDateTime(LocalDate.of(i5, i6, i7), LocalTime.of(i8, i9));
    }

    public static LocalDateTime ofEpochSecond(long j5, int i5, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return new LocalDateTime(LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j5 + zoneOffset.getTotalSeconds(), 86400L)), LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r2, 86400), i5));
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j5, long j6, long j7, long j8, int i5) {
        if ((j5 | j6 | j7 | j8) == 0) {
            return with(localDate, this.time);
        }
        long j9 = i5;
        long nanoOfDay = this.time.toNanoOfDay();
        long j10 = (((j8 % 86400000000000L) + ((j7 % 86400) * 1000000000) + ((j6 % 1440) * 60000000000L) + ((j5 % 24) * 3600000000000L)) * j9) + nanoOfDay;
        long floorDiv = (((j8 / 86400000000000L) + (j7 / 86400) + (j6 / 1440) + (j5 / 24)) * j9) + Jdk8Methods.floorDiv(j10, 86400000000000L);
        long floorMod = Jdk8Methods.floorMod(j10, 86400000000000L);
        return with(localDate.plusDays(floorDiv), floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalDateTime readExternal(DataInput dataInput) {
        return of(LocalDate.readExternal(dataInput), LocalTime.readExternal(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isAfter(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) > 0 : super.isAfter(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) < 0 : super.isBefore(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalDateTime minusDays(long j5) {
        return j5 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j5);
    }

    public LocalDateTime minusMinutes(long j5) {
        return plusWithOverflow(this.date, 0L, j5, 0L, 0L, -1);
    }

    public LocalDateTime plusDays(long j5) {
        return with(this.date.plusDays(j5), this.time);
    }

    public LocalDateTime plusHours(long j5) {
        return plusWithOverflow(this.date, j5, 0L, 0L, 0L, 1);
    }

    public LocalDateTime plusMinutes(long j5) {
        return plusWithOverflow(this.date, 0L, j5, 0L, 0L, 1);
    }

    public LocalDateTime plusNanos(long j5) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j5, 1);
    }

    public LocalDateTime plusSeconds(long j5) {
        return plusWithOverflow(this.date, 0L, 0L, j5, 0L, 1);
    }

    public LocalDateTime plusYears(long j5) {
        return with(this.date.plusYears(j5), this.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? (R) toLocalDate() : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDateTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (!chronoUnit.isTimeBased()) {
            LocalDate localDate = from.date;
            if (localDate.isAfter(this.date) && from.time.isBefore(this.time)) {
                localDate = localDate.minusDays(1L);
            } else if (localDate.isBefore(this.date) && from.time.isAfter(this.time)) {
                localDate = localDate.plusDays(1L);
            }
            return this.date.until(localDate, temporalUnit);
        }
        long daysUntil = this.date.daysUntil(from.date);
        long nanoOfDay = from.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (daysUntil > 0 && nanoOfDay < 0) {
            daysUntil--;
            nanoOfDay += 86400000000000L;
        } else if (daysUntil < 0 && nanoOfDay > 0) {
            daysUntil++;
            nanoOfDay -= 86400000000000L;
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[chronoUnit.ordinal()]) {
            case 1:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 86400000000000L), nanoOfDay);
            case 2:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 86400000000L), nanoOfDay / 1000);
            case 3:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 86400000L), nanoOfDay / 1000000);
            case 4:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 86400), nanoOfDay / 1000000000);
            case 5:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 1440), nanoOfDay / 60000000000L);
            case 6:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 24), nanoOfDay / 3600000000000L);
            case 7:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(daysUntil, 2), nanoOfDay / 43200000000000L);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        this.date.writeExternal(dataOutput);
        this.time.writeExternal(dataOutput);
    }

    public static LocalDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), clock.getZone().getRules().getOffset(instant));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* renamed from: atZone, reason: merged with bridge method [inline-methods] */
    public ChronoZonedDateTime<LocalDate> atZone2(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // java.lang.Comparable
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime);
        }
        return super.compareTo(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    public LocalDateTime plus(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.addTo(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j5);
                case 2:
                    return plusDays(j5 / 86400000000L).plusNanos((j5 % 86400000000L) * 1000);
                case 3:
                    return plusDays(j5 / 86400000).plusNanos((j5 % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j5);
                case 5:
                    return plusMinutes(j5);
                case 6:
                    return plusHours(j5);
                case 7:
                    return plusDays(j5 / 256).plusHours((j5 % 256) * 12);
                default:
                    return with(this.date.plus(j5, temporalUnit), this.time);
            }
        }
        return (LocalDateTime) temporalUnit.addTo(this, j5);
    }

    public static LocalDateTime of(int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return new LocalDateTime(LocalDate.of(i5, i6, i7), LocalTime.of(i8, i9, i10, i11));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return with((LocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return (LocalDateTime) temporalAdjuster;
        }
        return (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.requireNonNull(localDate, "date");
        Jdk8Methods.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            if (temporalField.isTimeBased()) {
                return with(this.date, this.time.with(temporalField, j5));
            }
            return with(this.date.with(temporalField, j5), this.time);
        }
        return (LocalDateTime) temporalField.adjustInto(this, j5);
    }
}
