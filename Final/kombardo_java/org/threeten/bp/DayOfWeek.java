package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static final TemporalQuery<DayOfWeek> FROM = new TemporalQuery<DayOfWeek>() { // from class: org.threeten.bp.DayOfWeek.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public DayOfWeek queryFrom(TemporalAccessor temporalAccessor) {
            return DayOfWeek.from(temporalAccessor);
        }
    };
    private static final DayOfWeek[] ENUMS = values();

    public static DayOfWeek from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return of(temporalAccessor.get(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e5) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e5);
        }
    }

    public static DayOfWeek of(int i5) {
        if (i5 >= 1 && i5 <= 7) {
            return ENUMS[i5 - 1];
        }
        throw new DateTimeException("Invalid value for DayOfWeek: " + i5);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField == ChronoField.DAY_OF_WEEK ? getValue() : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.DAY_OF_WEEK : temporalField != null && temporalField.isSupportedBy(this);
    }

    public DayOfWeek plus(long j5) {
        return ENUMS[(ordinal() + (((int) (j5 % 7)) + 7)) % 7];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
