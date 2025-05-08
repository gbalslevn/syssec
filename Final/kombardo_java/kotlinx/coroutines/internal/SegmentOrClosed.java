package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", BuildConfig.FLAVOR, "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SegmentOrClosed<S extends Segment<S>> {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <S extends Segment<S>> Object m3790constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final S m3791getSegmentimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            throw new IllegalStateException("Does not contain segment");
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m3792isClosedimpl(Object obj) {
        return obj == ConcurrentLinkedListKt.CLOSED;
    }
}
