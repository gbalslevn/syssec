package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;

/* loaded from: classes3.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    private Duration(long j5, int i5) {
        this.seconds = j5;
        this.nanos = i5;
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long until = temporal.until(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j5 = 0;
        if (temporal.isSupported(chronoField) && temporal2.isSupported(chronoField)) {
            try {
                long j6 = temporal.getLong(chronoField);
                long j7 = temporal2.getLong(chronoField) - j6;
                if (until > 0 && j7 < 0) {
                    j7 += 1000000000;
                } else if (until < 0 && j7 > 0) {
                    j7 -= 1000000000;
                } else if (until == 0 && j7 != 0) {
                    try {
                        until = temporal.until(temporal2.with(chronoField, j6), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j5 = j7;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return ofSeconds(until, j5);
    }

    private static Duration create(long j5, int i5) {
        return (((long) i5) | j5) == 0 ? ZERO : new Duration(j5, i5);
    }

    public static Duration ofDays(long j5) {
        return create(Jdk8Methods.safeMultiply(j5, 86400), 0);
    }

    public static Duration ofHours(long j5) {
        return create(Jdk8Methods.safeMultiply(j5, 3600), 0);
    }

    public static Duration ofMinutes(long j5) {
        return create(Jdk8Methods.safeMultiply(j5, 60), 0);
    }

    public static Duration ofNanos(long j5) {
        long j6 = j5 / 1000000000;
        int i5 = (int) (j5 % 1000000000);
        if (i5 < 0) {
            i5 += NANOS_PER_SECOND;
            j6--;
        }
        return create(j6, i5);
    }

    public static Duration ofSeconds(long j5) {
        return create(j5, 0);
    }

    private Duration plus(long j5, long j6) {
        if ((j5 | j6) == 0) {
            return this;
        }
        return ofSeconds(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j5), j6 / 1000000000), this.nanos + (j6 % 1000000000));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Duration readExternal(DataInput dataInput) {
        return ofSeconds(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long j5 = this.seconds;
        if (j5 != 0) {
            temporal = temporal.plus(j5, ChronoUnit.SECONDS);
        }
        int i5 = this.nanos;
        return i5 != 0 ? temporal.plus(i5, ChronoUnit.NANOS) : temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j5 = this.seconds;
        return ((int) (j5 ^ (j5 >>> 32))) + (this.nanos * 51);
    }

    public Duration minusHours(long j5) {
        return j5 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j5);
    }

    public Duration plusDays(long j5) {
        return plus(Jdk8Methods.safeMultiply(j5, 86400), 0L);
    }

    public Duration plusHours(long j5) {
        return plus(Jdk8Methods.safeMultiply(j5, 3600), 0L);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j5 = this.seconds;
        long j6 = j5 / 3600;
        int i5 = (int) ((j5 % 3600) / 60);
        int i6 = (int) (j5 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j6 != 0) {
            sb.append(j6);
            sb.append('H');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i6 == 0 && this.nanos == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i6 >= 0 || this.nanos <= 0) {
            sb.append(i6);
        } else if (i6 == -1) {
            sb.append("-0");
        } else {
            sb.append(i6 + 1);
        }
        if (this.nanos > 0) {
            int length = sb.length();
            if (i6 < 0) {
                sb.append(2000000000 - this.nanos);
            } else {
                sb.append(this.nanos + NANOS_PER_SECOND);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long j5, long j6) {
        return create(Jdk8Methods.safeAdd(j5, Jdk8Methods.floorDiv(j6, 1000000000L)), Jdk8Methods.floorMod(j6, NANOS_PER_SECOND));
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int compareLongs = Jdk8Methods.compareLongs(this.seconds, duration.seconds);
        return compareLongs != 0 ? compareLongs : this.nanos - duration.nanos;
    }
}
