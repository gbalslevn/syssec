package org.threeten.bp.temporal;

/* loaded from: classes3.dex */
public interface Temporal extends TemporalAccessor {
    Temporal minus(long j5, TemporalUnit temporalUnit);

    Temporal plus(long j5, TemporalUnit temporalUnit);

    long until(Temporal temporal, TemporalUnit temporalUnit);

    Temporal with(TemporalAdjuster temporalAdjuster);

    Temporal with(TemporalField temporalField, long j5);
}
