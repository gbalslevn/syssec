package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u00020\u00118\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material/SwipeableDefaults;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "anchors", "factorAtMin", "factorAtMax", "Landroidx/compose/material/ResistanceConfig;", "resistanceConfig", "(Ljava/util/Set;FF)Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/animation/core/SpringSpec;", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/unit/Dp;", "VelocityThreshold", "F", "getVelocityThreshold-D9Ej5fM", "()F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeableDefaults {
    public static final SwipeableDefaults INSTANCE = new SwipeableDefaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, null, 7, null);
    private static final float VelocityThreshold = Dp.m2599constructorimpl(125);

    private SwipeableDefaults() {
    }

    public static /* synthetic */ ResistanceConfig resistanceConfig$default(SwipeableDefaults swipeableDefaults, Set set, float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f5 = 10.0f;
        }
        if ((i5 & 4) != 0) {
            f6 = 10.0f;
        }
        return swipeableDefaults.resistanceConfig(set, f5, f6);
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    /* renamed from: getVelocityThreshold-D9Ej5fM */
    public final float m743getVelocityThresholdD9Ej5fM() {
        return VelocityThreshold;
    }

    public final ResistanceConfig resistanceConfig(Set<Float> anchors, float factorAtMin, float factorAtMax) {
        if (anchors.size() <= 1) {
            return null;
        }
        Set<Float> set = anchors;
        Float maxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) set);
        Intrinsics.checkNotNull(maxOrNull);
        float floatValue = maxOrNull.floatValue();
        Float minOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) set);
        Intrinsics.checkNotNull(minOrNull);
        return new ResistanceConfig(floatValue - minOrNull.floatValue(), factorAtMin, factorAtMax);
    }
}
