package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BE\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"J/\u0010%\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b-\u0010,R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010.R\u001a\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u00109\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u00106R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u00104R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "Landroidx/collection/IntList;", "timestamps", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "keyframes", BuildConfig.FLAVOR, "durationMillis", "delayMillis", "Landroidx/compose/animation/core/Easing;", "defaultEasing", "Landroidx/compose/animation/core/ArcMode;", "initialArcMode", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialValue", "targetValue", "initialVelocity", BuildConfig.FLAVOR, "init", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "timeMillis", BuildConfig.FLAVOR, "getEasedTime", "(I)F", "index", BuildConfig.FLAVOR, "asFraction", "getEasedTimeFromIndex", "(IIZ)F", "findEntryForTimeMillis", "(I)I", BuildConfig.FLAVOR, "playTimeNanos", "getValueFromNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "I", "getDurationMillis", "()I", "getDelayMillis", "Landroidx/compose/animation/core/Easing;", BuildConfig.FLAVOR, "modes", "[I", BuildConfig.FLAVOR, "times", "[F", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "lastInitialValue", "lastTargetValue", "posArray", "slopeArray", "Landroidx/compose/animation/core/ArcSpline;", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i5, int i6, Easing easing, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i5, i6, easing, i7);
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int binarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return binarySearch$default < -1 ? -(binarySearch$default + 2) : binarySearch$default;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        float f5;
        IntList intList = this.timestamps;
        if (index >= intList._size - 1) {
            f5 = timeMillis;
        } else {
            int i5 = intList.get(index);
            int i6 = this.timestamps.get(index + 1);
            if (timeMillis == i5) {
                f5 = i5;
            } else {
                int i7 = i6 - i5;
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i5);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f6 = i7;
                float transform = easing.transform((timeMillis - i5) / f6);
                if (asFraction) {
                    return transform;
                }
                f5 = (f6 * transform) + i5;
            }
        }
        return f5 / ((float) 1000);
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        float[] fArr2;
        boolean z5 = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int i5 = this.timestamps.get_size();
            float[] fArr3 = new float[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                fArr3[i6] = this.timestamps.get(i6) / ((float) 1000);
            }
            this.times = fArr3;
            int i7 = this.timestamps.get_size();
            int[] iArr = new int[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i8));
                int arcMode = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.getArcMode() : this.initialArcMode;
                if (!ArcMode.m60equalsimpl0(arcMode, ArcMode.INSTANCE.m63getArcLinear9TMq4())) {
                    z5 = true;
                }
                iArr[i8] = arcMode;
            }
            this.modes = iArr;
        }
        if (z5) {
            float[] fArr4 = null;
            if (this.arcSpline != null) {
                V v5 = this.lastInitialValue;
                if (v5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                    v5 = null;
                }
                if (Intrinsics.areEqual(v5, initialValue)) {
                    V v6 = this.lastTargetValue;
                    if (v6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                        v6 = null;
                    }
                    if (Intrinsics.areEqual(v6, targetValue)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = initialValue;
            this.lastTargetValue = targetValue;
            int size = (initialValue.getSize() % 2) + initialValue.getSize();
            this.posArray = new float[size];
            this.slopeArray = new float[size];
            int i9 = this.timestamps.get_size();
            float[][] fArr5 = new float[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                int i11 = this.timestamps.get(i10);
                if (i11 != 0) {
                    if (i11 != getDurationMillis()) {
                        fArr = new float[size];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i11);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                        V vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i12 = 0; i12 < size; i12++) {
                            fArr[i12] = vectorValue.get$animation_core_release(i12);
                        }
                    } else if (this.keyframes.contains(i11)) {
                        fArr = new float[size];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i11);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                        V vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                        for (int i13 = 0; i13 < size; i13++) {
                            fArr[i13] = vectorValue2.get$animation_core_release(i13);
                        }
                    } else {
                        fArr2 = new float[size];
                        for (int i14 = 0; i14 < size; i14++) {
                            fArr2[i14] = targetValue.get$animation_core_release(i14);
                        }
                    }
                    fArr2 = fArr;
                } else if (this.keyframes.contains(i11)) {
                    fArr = new float[size];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i11);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                    V vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                    for (int i15 = 0; i15 < size; i15++) {
                        fArr[i15] = vectorValue3.get$animation_core_release(i15);
                    }
                    fArr2 = fArr;
                } else {
                    fArr2 = new float[size];
                    for (int i16 = 0; i16 < size; i16++) {
                        fArr2[i16] = initialValue.get$animation_core_release(i16);
                    }
                }
                fArr5[i10] = fArr2;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modes");
                iArr2 = null;
            }
            float[] fArr6 = this.times;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
            } else {
                fArr4 = fArr6;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr4, fArr5);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / 1000000);
        if (this.keyframes.contains(clampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(clampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (clampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (clampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        int i5 = 0;
        if (this.arcSpline == null) {
            int findEntryForTimeMillis = findEntryForTimeMillis(clampPlayTime);
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis, clampPlayTime, true);
            int i6 = this.timestamps.get(findEntryForTimeMillis);
            if (this.keyframes.contains(i6)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i6);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                initialValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
            }
            int i7 = this.timestamps.get(findEntryForTimeMillis + 1);
            if (this.keyframes.contains(i7)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i7);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                targetValue = vectorizedKeyframeSpecElementInfo3.getVectorValue();
            }
            V v5 = this.valueVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v5 = null;
            }
            int size = v5.getSize();
            while (i5 < size) {
                V v6 = this.valueVector;
                if (v6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v6 = null;
                }
                v6.set$animation_core_release(i5, VectorConvertersKt.lerp(initialValue.get$animation_core_release(i5), targetValue.get$animation_core_release(i5), easedTimeFromIndex));
                i5++;
            }
            V v7 = this.valueVector;
            if (v7 != null) {
                return v7;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        float easedTime = getEasedTime(clampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
            arcSpline = null;
        }
        float[] fArr = this.posArray;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posArray");
            fArr = null;
        }
        arcSpline.getPos(easedTime, fArr);
        float[] fArr2 = this.posArray;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posArray");
            fArr2 = null;
        }
        int length = fArr2.length;
        while (i5 < length) {
            V v8 = this.valueVector;
            if (v8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v8 = null;
            }
            float[] fArr3 = this.posArray;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr3 = null;
            }
            v8.set$animation_core_release(i5, fArr3[i5]);
            i5++;
        }
        V v9 = this.valueVector;
        if (v9 != null) {
            return v9;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / 1000000);
        if (clampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        int i5 = 0;
        if (this.arcSpline == null) {
            AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime - 1, initialValue, targetValue, initialVelocity);
            AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime, initialValue, targetValue, initialVelocity);
            int size = valueFromMillis.getSize();
            while (i5 < size) {
                V v5 = this.velocityVector;
                if (v5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v5 = null;
                }
                v5.set$animation_core_release(i5, (valueFromMillis.get$animation_core_release(i5) - valueFromMillis2.get$animation_core_release(i5)) * 1000.0f);
                i5++;
            }
            V v6 = this.velocityVector;
            if (v6 != null) {
                return v6;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        float easedTime = getEasedTime((int) clampPlayTime);
        ArcSpline arcSpline = this.arcSpline;
        if (arcSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
            arcSpline = null;
        }
        float[] fArr = this.slopeArray;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
            fArr = null;
        }
        arcSpline.getSlope(easedTime, fArr);
        float[] fArr2 = this.slopeArray;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
            fArr2 = null;
        }
        int length = fArr2.length;
        while (i5 < length) {
            V v7 = this.velocityVector;
            if (v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v7 = null;
            }
            float[] fArr3 = this.slopeArray;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr3 = null;
            }
            v7.set$animation_core_release(i5, fArr3[i5]);
            i5++;
        }
        V v8 = this.velocityVector;
        if (v8 != null) {
            return v8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i5, int i6, Easing easing, int i7) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i5;
        this.delayMillis = i6;
        this.defaultEasing = easing;
        this.initialArcMode = i7;
    }
}
