package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\".\u0010\t\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00000\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\u0011\u001a\u00020\u000e*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0013*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0014\"\u0015\u0010\u0011\u001a\u00020\u0016*\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0017\"\u0015\u0010\u0011\u001a\u00020\u0019*\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001a\"\u0015\u0010\u0011\u001a\u00020\u001c*\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001d\"\u0015\u0010\u0011\u001a\u00020\u001f*\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010 \"\u0015\u0010\u0011\u001a\u00020\u0004*\u00020!8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\"¨\u0006#"}, d2 = {BuildConfig.FLAVOR, "DpVisibilityThreshold", "F", "PxVisibilityThreshold", "Landroidx/compose/ui/geometry/Rect;", "rectVisibilityThreshold", "Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThresholdMap", "Ljava/util/Map;", "getVisibilityThresholdMap", "()Ljava/util/Map;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "Landroidx/compose/ui/unit/IntOffset;", "getVisibilityThreshold", "(Landroidx/compose/ui/unit/IntOffset$Companion;)J", "VisibilityThreshold", "Landroidx/compose/ui/geometry/Offset$Companion;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/geometry/Offset$Companion;)J", "Lkotlin/Int$Companion;", BuildConfig.FLAVOR, "(Lkotlin/jvm/internal/IntCompanionObject;)I", "Landroidx/compose/ui/unit/Dp$Companion;", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/ui/unit/Dp$Companion;)F", "Landroidx/compose/ui/geometry/Size$Companion;", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Size$Companion;)J", "Landroidx/compose/ui/unit/IntSize$Companion;", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/unit/IntSize$Companion;)J", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/ui/geometry/Rect;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class VisibilityThresholdsKt {
    private static final float DpVisibilityThreshold = 0.1f;
    private static final float PxVisibilityThreshold = 0.5f;
    private static final Rect rectVisibilityThreshold;
    private static final Map<TwoWayConverter<?, ?>, Float> visibilityThresholdMap;

    static {
        Float valueOf = Float.valueOf(PxVisibilityThreshold);
        rectVisibilityThreshold = new Rect(PxVisibilityThreshold, PxVisibilityThreshold, PxVisibilityThreshold, PxVisibilityThreshold);
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(vectorConverter, valueOf2);
        Pair pair2 = TuplesKt.to(VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), valueOf2);
        Pair pair3 = TuplesKt.to(VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), valueOf2);
        Pair pair4 = TuplesKt.to(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(0.01f));
        Pair pair5 = TuplesKt.to(VectorConvertersKt.getVectorConverter(Rect.INSTANCE), valueOf);
        Pair pair6 = TuplesKt.to(VectorConvertersKt.getVectorConverter(Size.INSTANCE), valueOf);
        Pair pair7 = TuplesKt.to(VectorConvertersKt.getVectorConverter(Offset.INSTANCE), valueOf);
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
        Float valueOf3 = Float.valueOf(DpVisibilityThreshold);
        visibilityThresholdMap = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, TuplesKt.to(vectorConverter2, valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(DpOffset.INSTANCE), valueOf3));
    }

    public static final int getVisibilityThreshold(IntCompanionObject intCompanionObject) {
        return 1;
    }

    public static final Map<TwoWayConverter<?, ?>, Float> getVisibilityThresholdMap() {
        return visibilityThresholdMap;
    }

    public static final long getVisibilityThreshold(IntOffset.Companion companion) {
        return IntOffsetKt.IntOffset(1, 1);
    }

    public static final long getVisibilityThreshold(Offset.Companion companion) {
        return OffsetKt.Offset(PxVisibilityThreshold, PxVisibilityThreshold);
    }

    public static final long getVisibilityThreshold(Size.Companion companion) {
        return SizeKt.Size(PxVisibilityThreshold, PxVisibilityThreshold);
    }

    public static final long getVisibilityThreshold(IntSize.Companion companion) {
        return IntSizeKt.IntSize(1, 1);
    }

    public static final Rect getVisibilityThreshold(Rect.Companion companion) {
        return rectVisibilityThreshold;
    }

    public static final float getVisibilityThreshold(Dp.Companion companion) {
        return Dp.m2599constructorimpl(DpVisibilityThreshold);
    }
}
