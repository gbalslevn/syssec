package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087@\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\f\u0088\u0001\t\u0092\u0001\u00020\b¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "offsetMillis", "Landroidx/compose/animation/core/StartOffsetType;", "offsetType", "constructor-impl", "(II)J", BuildConfig.FLAVOR, "value", "(J)J", "hashCode-impl", "(J)I", "hashCode", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class StartOffset {
    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m70constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m71constructorimpl$default(int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i7 & 2) != 0) {
            i6 = StartOffsetType.INSTANCE.m75getDelayEo1U57Q();
        }
        return m69constructorimpl(i5, i6);
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m72equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m73hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m69constructorimpl(int i5, int i6) {
        return m70constructorimpl(i5 * i6);
    }
}
