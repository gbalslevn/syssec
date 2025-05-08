package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u0006\n"}, d2 = {"Landroidx/collection/FloatFloatPair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "first", "second", "constructor-impl", "(FF)J", BuildConfig.FLAVOR, "packedValue", "(J)J", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FloatFloatPair {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4constructorimpl(float f5, float f6) {
        return m5constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }
}
