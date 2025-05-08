package org.threeten.bp.chrono;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* loaded from: classes3.dex */
public abstract class Chronology implements Comparable<Chronology> {
    private static final Method LOCALE_METHOD;
    public static final TemporalQuery<Chronology> FROM = new TemporalQuery<Chronology>() { // from class: org.threeten.bp.chrono.Chronology.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor);
        }
    };
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();

    static {
        Method method;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
            method = null;
        }
        LOCALE_METHOD = method;
    }

    public static Chronology from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        return chronology != null ? chronology : IsoChronology.INSTANCE;
    }

    public abstract ChronoLocalDate date(int i5, int i6, int i7);

    public abstract ChronoLocalDate date(TemporalAccessor temporalAccessor);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Chronology) && compareTo((Chronology) obj) == 0;
    }

    public abstract String getId();

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public String toString() {
        return getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateResolveMap(Map<TemporalField, Long> map, ChronoField chronoField, long j5) {
        Long l5 = map.get(chronoField);
        if (l5 == null || l5.longValue() == j5) {
            map.put(chronoField, Long.valueOf(j5));
            return;
        }
        throw new DateTimeException("Invalid state, field: " + chronoField + " " + l5 + " conflicts with " + chronoField + " " + j5);
    }

    public abstract ChronoZonedDateTime<?> zonedDateTime(Instant instant, ZoneId zoneId);

    @Override // java.lang.Comparable
    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }
}
