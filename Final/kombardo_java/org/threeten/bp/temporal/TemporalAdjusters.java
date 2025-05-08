package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes3.dex */
public abstract class TemporalAdjusters {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int dowValue;
        private final int relative;

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal temporal) {
            int i5 = temporal.get(ChronoField.DAY_OF_WEEK);
            int i6 = this.relative;
            if (i6 < 2 && i5 == this.dowValue) {
                return temporal;
            }
            if ((i6 & 1) == 0) {
                return temporal.plus(i5 - this.dowValue >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            }
            return temporal.minus(this.dowValue - i5 >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
        }

        private RelativeDayOfWeek(int i5, DayOfWeek dayOfWeek) {
            Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
            this.relative = i5;
            this.dowValue = dayOfWeek.getValue();
        }
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
