package org.threeten.bp;

import com.adjust.sdk.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
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
public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    private static final long MILLIS_PER_SEC = 1000;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;
    public static final Instant EPOCH = new Instant(0, 0);
    private static final long MIN_SECOND = -31557014167219200L;
    public static final Instant MIN = ofEpochSecond(MIN_SECOND, 0);
    private static final long MAX_SECOND = 31556889864403199L;
    public static final Instant MAX = ofEpochSecond(MAX_SECOND, 999999999);
    public static final TemporalQuery<Instant> FROM = new TemporalQuery<Instant>() { // from class: org.threeten.bp.Instant.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Instant queryFrom(TemporalAccessor temporalAccessor) {
            return Instant.from(temporalAccessor);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.Instant$2, reason: invalid class name */
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
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.INSTANT_SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Instant(long j5, int i5) {
        this.seconds = j5;
        this.nanos = i5;
    }

    private static Instant create(long j5, int i5) {
        if ((i5 | j5) == 0) {
            return EPOCH;
        }
        if (j5 < MIN_SECOND || j5 > MAX_SECOND) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j5, i5);
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e5) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e5);
        }
    }

    private long nanosUntil(Instant instant) {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(instant.seconds, this.seconds), NANOS_PER_SECOND), instant.nanos - this.nanos);
    }

    public static Instant ofEpochMilli(long j5) {
        return create(Jdk8Methods.floorDiv(j5, MILLIS_PER_SEC), Jdk8Methods.floorMod(j5, Constants.ONE_SECOND) * NANOS_PER_MILLI);
    }

    public static Instant ofEpochSecond(long j5) {
        return create(j5, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Instant readExternal(DataInput dataInput) {
        return ofEpochSecond(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant instant) {
        long safeSubtract = Jdk8Methods.safeSubtract(instant.seconds, this.seconds);
        long j5 = instant.nanos - this.nanos;
        return (safeSubtract <= 0 || j5 >= 0) ? (safeSubtract >= 0 || j5 <= 0) ? safeSubtract : safeSubtract + 1 : safeSubtract - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i5 == 1) {
            return this.nanos;
        }
        if (i5 == 2) {
            return this.nanos / Constants.ONE_SECOND;
        }
        if (i5 == 3) {
            return this.nanos / NANOS_PER_MILLI;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i5;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i6 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i6 == 1) {
            i5 = this.nanos;
        } else if (i6 == 2) {
            i5 = this.nanos / Constants.ONE_SECOND;
        } else {
            if (i6 != 3) {
                if (i6 == 4) {
                    return this.seconds;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i5 = this.nanos / NANOS_PER_MILLI;
        }
        return i5;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j5 = this.seconds;
        return ((int) (j5 ^ (j5 >>> 32))) + (this.nanos * 51);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    public Instant plusMillis(long j5) {
        return plus(j5 / MILLIS_PER_SEC, (j5 % MILLIS_PER_SEC) * 1000000);
    }

    public Instant plusNanos(long j5) {
        return plus(0L, j5);
    }

    public Instant plusSeconds(long j5) {
        return plus(j5, 0L);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toEpochMilli() {
        long j5 = this.seconds;
        return j5 >= 0 ? Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(j5, MILLIS_PER_SEC), this.nanos / NANOS_PER_MILLI) : Jdk8Methods.safeSubtract(Jdk8Methods.safeMultiply(j5 + 1, MILLIS_PER_SEC), MILLIS_PER_SEC - (this.nanos / NANOS_PER_MILLI));
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanosUntil(from);
            case 2:
                return nanosUntil(from) / MILLIS_PER_SEC;
            case 3:
                return Jdk8Methods.safeSubtract(from.toEpochMilli(), toEpochMilli());
            case 4:
                return secondsUntil(from);
            case 5:
                return secondsUntil(from) / 60;
            case 6:
                return secondsUntil(from) / 3600;
            case 7:
                return secondsUntil(from) / 43200;
            case 8:
                return secondsUntil(from) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Instant ofEpochSecond(long j5, long j6) {
        return create(Jdk8Methods.safeAdd(j5, Jdk8Methods.floorDiv(j6, 1000000000L)), Jdk8Methods.floorMod(j6, NANOS_PER_SECOND));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int compareLongs = Jdk8Methods.compareLongs(this.seconds, instant.seconds);
        return compareLongs != 0 ? compareLongs : this.nanos - instant.nanos;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j5);
                case 2:
                    return plus(j5 / 1000000, (j5 % 1000000) * MILLIS_PER_SEC);
                case 3:
                    return plusMillis(j5);
                case 4:
                    return plusSeconds(j5);
                case 5:
                    return plusSeconds(Jdk8Methods.safeMultiply(j5, 60));
                case 6:
                    return plusSeconds(Jdk8Methods.safeMultiply(j5, 3600));
                case 7:
                    return plusSeconds(Jdk8Methods.safeMultiply(j5, 43200));
                case 8:
                    return plusSeconds(Jdk8Methods.safeMultiply(j5, 86400));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (Instant) temporalUnit.addTo(this, j5);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j5);
            int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i5 == 1) {
                return j5 != ((long) this.nanos) ? create(this.seconds, (int) j5) : this;
            }
            if (i5 == 2) {
                int i6 = ((int) j5) * Constants.ONE_SECOND;
                return i6 != this.nanos ? create(this.seconds, i6) : this;
            }
            if (i5 == 3) {
                int i7 = ((int) j5) * NANOS_PER_MILLI;
                return i7 != this.nanos ? create(this.seconds, i7) : this;
            }
            if (i5 == 4) {
                return j5 != this.seconds ? create(j5, this.nanos) : this;
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (Instant) temporalField.adjustInto(this, j5);
    }

    private Instant plus(long j5, long j6) {
        if ((j5 | j6) == 0) {
            return this;
        }
        return ofEpochSecond(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j5), j6 / 1000000000), this.nanos + (j6 % 1000000000));
    }
}
