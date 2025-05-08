package androidx.compose.ui.unit.fontscaling;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u0012\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001b¨\u0006\""}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", BuildConfig.FLAVOR, "fromSp", "toDp", "<init>", "([F[F)V", BuildConfig.FLAVOR, "dp", "convertDpToSp", "(F)F", "sp", "convertSpToDp", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "mFromSpValues", "[F", "getMFromSpValues", "()[F", "getMFromSpValues$annotations", "()V", "mToDpValues", "getMToDpValues", "getMToDpValues$annotations", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontScaleConverterTable implements FontScaleConverter {
    private final float[] mFromSpValues;

    /* renamed from: mToDpValues, reason: from kotlin metadata and from toString */
    private final float[] toDpValues;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", BuildConfig.FLAVOR, "()V", "lookupAndInterpolate", BuildConfig.FLAVOR, "sourceValue", "sourceValues", BuildConfig.FLAVOR, "targetValues", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float lookupAndInterpolate(float sourceValue, float[] sourceValues, float[] targetValues) {
            float f5;
            float f6;
            float f7;
            float constrainedMap;
            float abs = Math.abs(sourceValue);
            float signum = Math.signum(sourceValue);
            int binarySearch = Arrays.binarySearch(sourceValues, abs);
            if (binarySearch >= 0) {
                constrainedMap = targetValues[binarySearch];
            } else {
                int i5 = -(binarySearch + 1);
                int i6 = i5 - 1;
                float f8 = 0.0f;
                if (i6 >= sourceValues.length - 1) {
                    float f9 = sourceValues[sourceValues.length - 1];
                    float f10 = targetValues[sourceValues.length - 1];
                    if (f9 == 0.0f) {
                        return 0.0f;
                    }
                    return sourceValue * (f10 / f9);
                }
                if (i6 == -1) {
                    float f11 = sourceValues[0];
                    f7 = targetValues[0];
                    f6 = f11;
                    f5 = 0.0f;
                } else {
                    float f12 = sourceValues[i6];
                    float f13 = sourceValues[i5];
                    f5 = targetValues[i6];
                    f8 = f12;
                    f6 = f13;
                    f7 = targetValues[i5];
                }
                constrainedMap = MathUtils.INSTANCE.constrainedMap(f5, f7, f8, f6, abs);
            }
            return signum * constrainedMap;
        }

        private Companion() {
        }
    }

    public FontScaleConverterTable(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.mFromSpValues = fArr;
        this.toDpValues = fArr2;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertDpToSp(float dp) {
        return INSTANCE.lookupAndInterpolate(dp, this.toDpValues, this.mFromSpValues);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertSpToDp(float sp) {
        return INSTANCE.lookupAndInterpolate(sp, this.mFromSpValues, this.toDpValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof FontScaleConverterTable)) {
            return false;
        }
        FontScaleConverterTable fontScaleConverterTable = (FontScaleConverterTable) other;
        return Arrays.equals(this.mFromSpValues, fontScaleConverterTable.mFromSpValues) && Arrays.equals(this.toDpValues, fontScaleConverterTable.toDpValues);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.mFromSpValues) * 31) + Arrays.hashCode(this.toDpValues);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontScaleConverter{fromSpValues=");
        String arrays = Arrays.toString(this.mFromSpValues);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        sb.append(", toDpValues=");
        String arrays2 = Arrays.toString(this.toDpValues);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        sb.append(arrays2);
        sb.append('}');
        return sb.toString();
    }
}
