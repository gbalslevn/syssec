package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* loaded from: classes3.dex */
public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    private static final Comparator<ChronoLocalDateTime<?>> DATE_TIME_COMPARATOR = new Comparator<ChronoLocalDateTime<?>>() { // from class: org.threeten.bp.chrono.ChronoLocalDateTime.1
        /* JADX WARN: Type inference failed for: r0v0, types: [org.threeten.bp.chrono.ChronoLocalDate] */
        /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.ChronoLocalDate] */
        @Override // java.util.Comparator
        public int compare(ChronoLocalDateTime<?> chronoLocalDateTime, ChronoLocalDateTime<?> chronoLocalDateTime2) {
            int compareLongs = Jdk8Methods.compareLongs(chronoLocalDateTime.toLocalDate().toEpochDay(), chronoLocalDateTime2.toLocalDate().toEpochDay());
            return compareLongs == 0 ? Jdk8Methods.compareLongs(chronoLocalDateTime.toLocalTime().toNanoOfDay(), chronoLocalDateTime2.toLocalTime().toNanoOfDay()) : compareLongs;
        }
    };

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    /* renamed from: atZone */
    public abstract ChronoZonedDateTime<D> atZone2(ZoneId zoneId);

    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int compareTo = toLocalDate().compareTo(chronoLocalDateTime.toLocalDate());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = toLocalTime().compareTo(chronoLocalDateTime.toLocalTime());
        return compareTo2 == 0 ? getChronology().compareTo(chronoLocalDateTime.getChronology()) : compareTo2;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.ChronoLocalDate] */
    public boolean isAfter(ChronoLocalDateTime<?> chronoLocalDateTime) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = chronoLocalDateTime.toLocalDate().toEpochDay();
        return epochDay > epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() > chronoLocalDateTime.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.ChronoLocalDate] */
    public boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = chronoLocalDateTime.toLocalDate().toEpochDay();
        return epochDay < epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() < chronoLocalDateTime.toLocalTime().toNanoOfDay());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) toLocalTime();
        }
        if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    public long toEpochSecond(ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    public Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(toEpochSecond(zoneOffset), toLocalTime().getNano());
    }

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();
}
