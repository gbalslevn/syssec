package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes3.dex */
public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, Comparable<ChronoZonedDateTime<?>> {
    private static Comparator<ChronoZonedDateTime<?>> INSTANT_COMPARATOR = new Comparator<ChronoZonedDateTime<?>>() { // from class: org.threeten.bp.chrono.ChronoZonedDateTime.1
        @Override // java.util.Comparator
        public int compare(ChronoZonedDateTime<?> chronoZonedDateTime, ChronoZonedDateTime<?> chronoZonedDateTime2) {
            int compareLongs = Jdk8Methods.compareLongs(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
            return compareLongs == 0 ? Jdk8Methods.compareLongs(chronoZonedDateTime.toLocalTime().toNanoOfDay(), chronoZonedDateTime2.toLocalTime().toNanoOfDay()) : compareLongs;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.chrono.ChronoZonedDateTime$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i5 != 1) {
            return i5 != 2 ? toLocalDateTime2().get(temporalField) : getOffset().getTotalSeconds();
        }
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public abstract long getLong(TemporalField temporalField);

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone()) ? (R) getZone() : temporalQuery == TemporalQueries.chronology() ? (R) toLocalDate().getChronology() : temporalQuery == TemporalQueries.precision() ? (R) ChronoUnit.NANOS : temporalQuery == TemporalQueries.offset() ? (R) getOffset() : temporalQuery == TemporalQueries.localDate() ? (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay()) : temporalQuery == TemporalQueries.localTime() ? (R) toLocalTime() : (R) super.query(temporalQuery);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - getOffset().getTotalSeconds();
    }

    public abstract D toLocalDate();

    /* renamed from: toLocalDateTime */
    public abstract ChronoLocalDateTime<D> toLocalDateTime2();

    public abstract LocalTime toLocalTime();

    /* JADX WARN: Type inference failed for: r5v1, types: [org.threeten.bp.chrono.ChronoLocalDate] */
    @Override // java.lang.Comparable
    public int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int compareLongs = Jdk8Methods.compareLongs(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        if (compareLongs != 0) {
            return compareLongs;
        }
        int nano = toLocalTime().getNano() - chronoZonedDateTime.toLocalTime().getNano();
        if (nano != 0) {
            return nano;
        }
        int compareTo = toLocalDateTime2().compareTo(chronoZonedDateTime.toLocalDateTime2());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(chronoZonedDateTime.getZone().getId());
        return compareTo2 == 0 ? toLocalDate().getChronology().compareTo(chronoZonedDateTime.toLocalDate().getChronology()) : compareTo2;
    }
}
