package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/ContentTransform;", BuildConfig.FLAVOR, "Landroidx/compose/animation/EnterTransition;", "targetContentEnter", "Landroidx/compose/animation/ExitTransition;", "initialContentExit", BuildConfig.FLAVOR, "targetContentZIndex", "Landroidx/compose/animation/SizeTransform;", "sizeTransform", "<init>", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;FLandroidx/compose/animation/SizeTransform;)V", "Landroidx/compose/animation/EnterTransition;", "getTargetContentEnter", "()Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "getInitialContentExit", "()Landroidx/compose/animation/ExitTransition;", "<set-?>", "targetContentZIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getTargetContentZIndex", "()F", "setTargetContentZIndex", "(F)V", "Landroidx/compose/animation/SizeTransform;", "getSizeTransform", "()Landroidx/compose/animation/SizeTransform;", "setSizeTransform$animation_release", "(Landroidx/compose/animation/SizeTransform;)V", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentTransform {
    private final ExitTransition initialContentExit;
    private SizeTransform sizeTransform;
    private final EnterTransition targetContentEnter;

    /* renamed from: targetContentZIndex$delegate, reason: from kotlin metadata */
    private final MutableFloatState targetContentZIndex;

    public ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f5, SizeTransform sizeTransform) {
        this.targetContentEnter = enterTransition;
        this.initialContentExit = exitTransition;
        this.targetContentZIndex = PrimitiveSnapshotStateKt.mutableFloatStateOf(f5);
        this.sizeTransform = sizeTransform;
    }

    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    public final float getTargetContentZIndex() {
        return this.targetContentZIndex.getFloatValue();
    }

    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f5, SizeTransform sizeTransform, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterTransition, exitTransition, (i5 & 4) != 0 ? 0.0f : f5, (i5 & 8) != 0 ? AnimatedContentKt.SizeTransform$default(false, null, 3, null) : sizeTransform);
    }
}
