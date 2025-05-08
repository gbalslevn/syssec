package androidx.compose.animation.core;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/animation/core/Motion;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "getValue-impl", "(J)F", "value", "getVelocity-impl", "velocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Motion {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m65constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m66getValueimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getVelocity-impl, reason: not valid java name */
    public static final float m67getVelocityimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }
}
