package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes3.dex */
public abstract class ZoneRules {

    /* loaded from: classes3.dex */
    static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;
        private final ZoneOffset offset;

        Fixed(ZoneOffset zoneOffset) {
            this.offset = zoneOffset;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.offset.equals(((Fixed) obj).offset);
            }
            if (!(obj instanceof StandardZoneRules)) {
                return false;
            }
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return standardZoneRules.isFixedOffset() && this.offset.equals(standardZoneRules.getOffset(Instant.EPOCH));
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(Instant instant) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
            return Collections.singletonList(this.offset);
        }

        public int hashCode() {
            return ((this.offset.hashCode() + 31) ^ (this.offset.hashCode() + 31)) ^ 1;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isDaylightSavings(Instant instant) {
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isFixedOffset() {
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.offset.equals(zoneOffset);
        }

        public String toString() {
            return "FixedRules:" + this.offset;
        }
    }

    public static ZoneRules of(ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return new Fixed(zoneOffset);
    }

    public abstract ZoneOffset getOffset(Instant instant);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime localDateTime);

    public abstract List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime);

    public abstract boolean isDaylightSavings(Instant instant);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset);
}
