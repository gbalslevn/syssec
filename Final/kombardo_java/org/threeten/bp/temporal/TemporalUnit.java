package org.threeten.bp.temporal;

/* loaded from: classes3.dex */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r5, long j5);

    long between(Temporal temporal, Temporal temporal2);

    boolean isDateBased();
}
