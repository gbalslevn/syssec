package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* loaded from: classes3.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long j5, long j6, long j7, long j8) {
        this.minSmallest = j5;
        this.minLargest = j6;
        this.maxSmallest = j7;
        this.maxLargest = j8;
    }

    public static ValueRange of(long j5, long j6) {
        if (j5 <= j6) {
            return new ValueRange(j5, j5, j6, j6);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long j5, TemporalField temporalField) {
        if (isValidIntValue(j5)) {
            return (int) j5;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j5);
    }

    public long checkValidValue(long j5, TemporalField temporalField) {
        if (isValidValue(j5)) {
            return j5;
        }
        if (temporalField == null) {
            throw new DateTimeException("Invalid value (valid values " + this + "): " + j5);
        }
        throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j5);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        return this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public int hashCode() {
        long j5 = this.minSmallest;
        long j6 = this.minLargest;
        long j7 = (j5 + j6) << ((int) (j6 + 16));
        long j8 = this.maxSmallest;
        long j9 = (j7 >> ((int) (j8 + 48))) << ((int) (j8 + 32));
        long j10 = this.maxLargest;
        long j11 = ((j9 >> ((int) (32 + j10))) << ((int) (j10 + 48))) >> 16;
        return (int) (j11 ^ (j11 >>> 32));
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= 2147483647L;
    }

    public boolean isValidIntValue(long j5) {
        return isIntValue() && isValidValue(j5);
    }

    public boolean isValidValue(long j5) {
        return j5 >= getMinimum() && j5 <= getMaximum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            sb.append('/');
            sb.append(this.minLargest);
        }
        sb.append(" - ");
        sb.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            sb.append('/');
            sb.append(this.maxLargest);
        }
        return sb.toString();
    }

    public static ValueRange of(long j5, long j6, long j7) {
        return of(j5, j5, j6, j7);
    }

    public static ValueRange of(long j5, long j6, long j7, long j8) {
        if (j5 > j6) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (j7 > j8) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (j6 <= j8) {
            return new ValueRange(j5, j6, j7, j8);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }
}
