package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u0002H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bH\u0010¢\u0006\u0002\b\u0017R\u0016\u0010\u0005\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/ULongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/ULongArray;", "bufferWithData", "([JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[J", "<set-?>", BuildConfig.FLAVOR, "position", "getPosition$kotlinx_serialization_core", "()I", "append", BuildConfig.FLAVOR, "c", "Lkotlin/ULong;", "append-VKZWuLQ$kotlinx_serialization_core", "(J)V", "build", "build-Y2RjT0g$kotlinx_serialization_core", "()[J", "ensureCapacity", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {
    private long[] buffer;
    private int position;

    public /* synthetic */ ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    /* renamed from: append-VKZWuLQ$kotlinx_serialization_core, reason: not valid java name */
    public final void m3812appendVKZWuLQ$kotlinx_serialization_core(long c5) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        long[] jArr = this.buffer;
        int position = getPosition();
        this.position = position + 1;
        ULongArray.m3640setk8EXiF4(jArr, position, c5);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ ULongArray build$kotlinx_serialization_core() {
        return ULongArray.m3628boximpl(m3813buildY2RjT0g$kotlinx_serialization_core());
    }

    /* renamed from: build-Y2RjT0g$kotlinx_serialization_core, reason: not valid java name */
    public long[] m3813buildY2RjT0g$kotlinx_serialization_core() {
        long[] copyOf = Arrays.copyOf(this.buffer, getPosition());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return ULongArray.m3630constructorimpl(copyOf);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int requiredCapacity) {
        if (ULongArray.m3636getSizeimpl(this.buffer) < requiredCapacity) {
            long[] jArr = this.buffer;
            long[] copyOf = Arrays.copyOf(jArr, RangesKt.coerceAtLeast(requiredCapacity, ULongArray.m3636getSizeimpl(jArr) * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.buffer = ULongArray.m3630constructorimpl(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: getPosition$kotlinx_serialization_core, reason: from getter */
    public int getPosition() {
        return this.position;
    }

    private ULongArrayBuilder(long[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = ULongArray.m3636getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }
}
