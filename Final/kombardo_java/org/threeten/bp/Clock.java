package org.threeten.bp;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class Clock {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        public long millis() {
            return System.currentTimeMillis();
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }
    }

    protected Clock() {
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public abstract ZoneId getZone();

    public abstract Instant instant();
}
