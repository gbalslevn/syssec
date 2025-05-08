package coil.decode;

import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\f2\b\b\u0001\u0010\u0006\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcoil/decode/DecodeUtils;", BuildConfig.FLAVOR, "()V", "calculateInSampleSize", BuildConfig.FLAVOR, "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computeSizeMultiplier", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DecodeUtils() {
    }

    public static final int calculateInSampleSize(int srcWidth, int srcHeight, int dstWidth, int dstHeight, Scale scale) {
        int min;
        int highestOneBit = Integer.highestOneBit(srcWidth / dstWidth);
        int highestOneBit2 = Integer.highestOneBit(srcHeight / dstHeight);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            min = Math.min(highestOneBit, highestOneBit2);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            min = Math.max(highestOneBit, highestOneBit2);
        }
        return RangesKt.coerceAtLeast(min, 1);
    }

    public static final double computeSizeMultiplier(int srcWidth, int srcHeight, int dstWidth, int dstHeight, Scale scale) {
        double d5 = dstWidth / srcWidth;
        double d6 = dstHeight / srcHeight;
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d5, d6);
        }
        if (i5 == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float computeSizeMultiplier(float srcWidth, float srcHeight, float dstWidth, float dstHeight, Scale scale) {
        float f5 = dstWidth / srcWidth;
        float f6 = dstHeight / srcHeight;
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(f5, f6);
        }
        if (i5 == 2) {
            return Math.min(f5, f6);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double computeSizeMultiplier(double srcWidth, double srcHeight, double dstWidth, double dstHeight, Scale scale) {
        double d5 = dstWidth / srcWidth;
        double d6 = dstHeight / srcHeight;
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d5, d6);
        }
        if (i5 == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }
}
