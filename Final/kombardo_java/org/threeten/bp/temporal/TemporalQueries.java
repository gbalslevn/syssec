package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

/* loaded from: classes3.dex */
public abstract class TemporalQueries {
    static final TemporalQuery<ZoneId> ZONE_ID = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.temporal.TemporalQueries.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.query(this);
        }
    };
    static final TemporalQuery<Chronology> CHRONO = new TemporalQuery<Chronology>() { // from class: org.threeten.bp.temporal.TemporalQueries.2
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.query(this);
        }
    };
    static final TemporalQuery<TemporalUnit> PRECISION = new TemporalQuery<TemporalUnit>() { // from class: org.threeten.bp.temporal.TemporalQueries.3
        @Override // org.threeten.bp.temporal.TemporalQuery
        public TemporalUnit queryFrom(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.query(this);
        }
    };
    static final TemporalQuery<ZoneId> ZONE = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.temporal.TemporalQueries.4
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(TemporalQueries.OFFSET);
        }
    };
    static final TemporalQuery<ZoneOffset> OFFSET = new TemporalQuery<ZoneOffset>() { // from class: org.threeten.bp.temporal.TemporalQueries.5
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.OFFSET_SECONDS;
            if (temporalAccessor.isSupported(chronoField)) {
                return ZoneOffset.ofTotalSeconds(temporalAccessor.get(chronoField));
            }
            return null;
        }
    };
    static final TemporalQuery<LocalDate> LOCAL_DATE = new TemporalQuery<LocalDate>() { // from class: org.threeten.bp.temporal.TemporalQueries.6
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.EPOCH_DAY;
            if (temporalAccessor.isSupported(chronoField)) {
                return LocalDate.ofEpochDay(temporalAccessor.getLong(chronoField));
            }
            return null;
        }
    };
    static final TemporalQuery<LocalTime> LOCAL_TIME = new TemporalQuery<LocalTime>() { // from class: org.threeten.bp.temporal.TemporalQueries.7
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.NANO_OF_DAY;
            if (temporalAccessor.isSupported(chronoField)) {
                return LocalTime.ofNanoOfDay(temporalAccessor.getLong(chronoField));
            }
            return null;
        }
    };

    public static final TemporalQuery<Chronology> chronology() {
        return CHRONO;
    }

    public static final TemporalQuery<LocalDate> localDate() {
        return LOCAL_DATE;
    }

    public static final TemporalQuery<LocalTime> localTime() {
        return LOCAL_TIME;
    }

    public static final TemporalQuery<ZoneOffset> offset() {
        return OFFSET;
    }

    public static final TemporalQuery<TemporalUnit> precision() {
        return PRECISION;
    }

    public static final TemporalQuery<ZoneId> zone() {
        return ZONE;
    }

    public static final TemporalQuery<ZoneId> zoneId() {
        return ZONE_ID;
    }
}
