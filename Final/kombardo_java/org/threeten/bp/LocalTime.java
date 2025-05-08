package org.threeten.bp;

import com.adjust.sdk.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.conscrypt.BuildConfig;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final TemporalQuery<LocalTime> FROM = new TemporalQuery<LocalTime>() { // from class: org.threeten.bp.LocalTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalTime.from(temporalAccessor);
        }
    };
    private static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX;
    public static final LocalTime MIDNIGHT;
    public static final LocalTime MIN;
    public static final LocalTime NOON;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.LocalTime$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
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
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.AMPM_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int i5 = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i5 >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                NOON = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[i5] = new LocalTime(i5, 0, 0, 0);
            i5++;
        }
    }

    private LocalTime(int i5, int i6, int i7, int i8) {
        this.hour = (byte) i5;
        this.minute = (byte) i6;
        this.second = (byte) i7;
        this.nano = i8;
    }

    private static LocalTime create(int i5, int i6, int i7, int i8) {
        return ((i6 | i7) | i8) == 0 ? HOURS[i5] : new LocalTime(i5, i6, i7, i8);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 3:
                return this.nano / Constants.ONE_SECOND;
            case 4:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int i5 = this.hour % 12;
                if (i5 % 12 == 0) {
                    return 12;
                }
                return i5;
            case 13:
                return this.hour;
            case 14:
                byte b5 = this.hour;
                if (b5 == 0) {
                    return 24;
                }
                return b5;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime of(int i5, int i6) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i5);
        if (i6 == 0) {
            return HOURS[i5];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i6);
        return new LocalTime(i5, i6, 0, 0);
    }

    public static LocalTime ofNanoOfDay(long j5) {
        ChronoField.NANO_OF_DAY.checkValidValue(j5);
        int i5 = (int) (j5 / 3600000000000L);
        long j6 = j5 - (i5 * 3600000000000L);
        int i6 = (int) (j6 / 60000000000L);
        long j7 = j6 - (i6 * 60000000000L);
        int i7 = (int) (j7 / 1000000000);
        return create(i5, i6, i7, (int) (j7 - (i7 * 1000000000)));
    }

    public static LocalTime ofSecondOfDay(long j5) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j5);
        int i5 = (int) (j5 / 3600);
        long j6 = j5 - (i5 * 3600);
        return create(i5, (int) (j6 / 60), (int) (j6 - (r1 * 60)), 0);
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalTime readExternal(DataInput dataInput) {
        int i5;
        int i6;
        int readByte = dataInput.readByte();
        int i7 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i5 = 0;
            i6 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i8 = ~readByte2;
                i6 = 0;
                i7 = i8;
                i5 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i5 = ~readByte3;
                } else {
                    i7 = dataInput.readInt();
                    i5 = readByte3;
                }
                i6 = i7;
                i7 = readByte2;
            }
        }
        return of(readByte, i7, i5, i6);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate localDate) {
        return LocalDateTime.of(localDate, this);
    }

    public OffsetTime atOffset(ZoneOffset zoneOffset) {
        return OffsetTime.of(this, zoneOffset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.NANO_OF_DAY ? toNanoOfDay() : temporalField == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : get0(temporalField) : temporalField.getFrom(this);
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalTime minusNanos(long j5) {
        return plusNanos(-(j5 % 86400000000000L));
    }

    public LocalTime plusHours(long j5) {
        return j5 == 0 ? this : create(((((int) (j5 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j5) {
        if (j5 == 0) {
            return this;
        }
        int i5 = (this.hour * 60) + this.minute;
        int i6 = ((((int) (j5 % 1440)) + i5) + 1440) % 1440;
        return i5 == i6 ? this : create(i6 / 60, i6 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j5) {
        if (j5 == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j6 = (((j5 % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        return nanoOfDay == j6 ? this : create((int) (j6 / 3600000000000L), (int) ((j6 / 60000000000L) % 60), (int) ((j6 / 1000000000) % 60), (int) (j6 % 1000000000));
    }

    public LocalTime plusSeconds(long j5) {
        if (j5 == 0) {
            return this;
        }
        int i5 = (this.hour * 3600) + (this.minute * 60) + this.second;
        int i6 = ((((int) (j5 % 86400)) + i5) + 86400) % 86400;
        return i5 == i6 ? this : create(i6 / 3600, (i6 / 60) % 60, i6 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toNanoOfDay() {
        return (this.hour * 3600000000000L) + (this.minute * 60000000000L) + (this.second * 1000000000) + this.nano;
    }

    public int toSecondOfDay() {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b5 = this.hour;
        byte b6 = this.minute;
        byte b7 = this.second;
        int i5 = this.nano;
        sb.append(b5 < 10 ? "0" : BuildConfig.FLAVOR);
        sb.append((int) b5);
        sb.append(b6 < 10 ? ":0" : ":");
        sb.append((int) b6);
        if (b7 > 0 || i5 > 0) {
            sb.append(b7 < 10 ? ":0" : ":");
            sb.append((int) b7);
            if (i5 > 0) {
                sb.append('.');
                if (i5 % 1000000 == 0) {
                    sb.append(Integer.toString((i5 / 1000000) + Constants.ONE_SECOND).substring(1));
                } else if (i5 % Constants.ONE_SECOND == 0) {
                    sb.append(Integer.toString((i5 / Constants.ONE_SECOND) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i5 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long nanoOfDay = from.toNanoOfDay() - toNanoOfDay();
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanoOfDay;
            case 2:
                return nanoOfDay / 1000;
            case 3:
                return nanoOfDay / 1000000;
            case 4:
                return nanoOfDay / 1000000000;
            case 5:
                return nanoOfDay / 60000000000L;
            case 6:
                return nanoOfDay / 3600000000000L;
            case 7:
                return nanoOfDay / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime withHour(int i5) {
        if (this.hour == i5) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue(i5);
        return create(i5, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int i5) {
        if (this.minute == i5) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i5);
        return create(this.hour, i5, this.second, this.nano);
    }

    public LocalTime withNano(int i5) {
        if (this.nano == i5) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue(i5);
        return create(this.hour, this.minute, this.second, i5);
    }

    public LocalTime withSecond(int i5) {
        if (this.second == i5) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i5);
        return create(this.hour, this.minute, i5, this.nano);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
            return;
        }
        if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(~this.second);
        } else if (this.minute == 0) {
            dataOutput.writeByte(~this.hour);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(~this.minute);
        }
    }

    public static LocalTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        long epochSecond = ((instant.getEpochSecond() % 86400) + clock.getZone().getRules().getOffset(instant).getTotalSeconds()) % 86400;
        if (epochSecond < 0) {
            epochSecond += 86400;
        }
        return ofSecondOfDay(epochSecond, instant.getNano());
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime localTime) {
        int compareInts = Jdk8Methods.compareInts(this.hour, localTime.hour);
        if (compareInts != 0) {
            return compareInts;
        }
        int compareInts2 = Jdk8Methods.compareInts(this.minute, localTime.minute);
        if (compareInts2 != 0) {
            return compareInts2;
        }
        int compareInts3 = Jdk8Methods.compareInts(this.second, localTime.second);
        return compareInts3 == 0 ? Jdk8Methods.compareInts(this.nano, localTime.nano) : compareInts3;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    public LocalTime plus(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j5);
                case 2:
                    return plusNanos((j5 % 86400000000L) * 1000);
                case 3:
                    return plusNanos((j5 % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j5);
                case 5:
                    return plusMinutes(j5);
                case 6:
                    return plusHours(j5);
                case 7:
                    return plusHours((j5 % 2) * 12);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalTime) temporalUnit.addTo(this, j5);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return (LocalTime) temporalAdjuster;
        }
        return (LocalTime) temporalAdjuster.adjustInto(this);
    }

    public static LocalTime of(int i5, int i6, int i7) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i5);
        if ((i6 | i7) == 0) {
            return HOURS[i5];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i6);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i7);
        return new LocalTime(i5, i6, i7, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalTime ofSecondOfDay(long j5, int i5) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j5);
        ChronoField.NANO_OF_SECOND.checkValidValue(i5);
        int i6 = (int) (j5 / 3600);
        long j6 = j5 - (i6 * 3600);
        return create(i6, (int) (j6 / 60), (int) (j6 - (r1 * 60)), i5);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j5);
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withNano((int) j5);
                case 2:
                    return ofNanoOfDay(j5);
                case 3:
                    return withNano(((int) j5) * Constants.ONE_SECOND);
                case 4:
                    return ofNanoOfDay(j5 * 1000);
                case 5:
                    return withNano(((int) j5) * 1000000);
                case 6:
                    return ofNanoOfDay(j5 * 1000000);
                case 7:
                    return withSecond((int) j5);
                case 8:
                    return plusSeconds(j5 - toSecondOfDay());
                case 9:
                    return withMinute((int) j5);
                case 10:
                    return plusMinutes(j5 - ((this.hour * 60) + this.minute));
                case 11:
                    return plusHours(j5 - (this.hour % 12));
                case 12:
                    if (j5 == 12) {
                        j5 = 0;
                    }
                    return plusHours(j5 - (this.hour % 12));
                case 13:
                    return withHour((int) j5);
                case 14:
                    if (j5 == 24) {
                        j5 = 0;
                    }
                    return withHour((int) j5);
                case 15:
                    return plusHours((j5 - (this.hour / 12)) * 12);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (LocalTime) temporalField.adjustInto(this, j5);
    }

    public static LocalTime of(int i5, int i6, int i7, int i8) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i5);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i6);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i7);
        ChronoField.NANO_OF_SECOND.checkValidValue(i8);
        return create(i5, i6, i7, i8);
    }
}
