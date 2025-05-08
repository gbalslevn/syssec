package org.threeten.bp;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;

/* loaded from: classes3.dex */
public final class Period extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);

    private Period(int i5, int i6, int i7) {
        this.years = i5;
        this.months = i6;
        this.days = i7;
    }

    private static Period create(int i5, int i6, int i7) {
        return ((i5 | i6) | i7) == 0 ? ZERO : new Period(i5, i6, i7);
    }

    public static Period ofDays(int i5) {
        return create(0, 0, i5);
    }

    private Object readResolve() {
        return ((this.years | this.months) | this.days) == 0 ? ZERO : this;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i5 = this.years;
        if (i5 != 0) {
            temporal = this.months != 0 ? temporal.plus(toTotalMonths(), ChronoUnit.MONTHS) : temporal.plus(i5, ChronoUnit.YEARS);
        } else {
            int i6 = this.months;
            if (i6 != 0) {
                temporal = temporal.plus(i6, ChronoUnit.MONTHS);
            }
        }
        int i7 = this.days;
        return i7 != 0 ? temporal.plus(i7, ChronoUnit.DAYS) : temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    public boolean isZero() {
        return this == ZERO;
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i5 = this.years;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('Y');
        }
        int i6 = this.months;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        int i7 = this.days;
        if (i7 != 0) {
            sb.append(i7);
            sb.append('D');
        }
        return sb.toString();
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
    }
}
