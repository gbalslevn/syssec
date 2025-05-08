package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* loaded from: classes3.dex */
public interface TemporalField {
    <R extends Temporal> R adjustInto(R r5, long j5);

    long getFrom(TemporalAccessor temporalAccessor);

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor temporalAccessor);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor);

    TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle);
}
