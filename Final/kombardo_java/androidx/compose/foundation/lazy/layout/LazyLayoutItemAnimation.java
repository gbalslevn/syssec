package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 32\u00020\u0001:\u00013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004R$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R+\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0017R+\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0017R(\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u000f\u001a\u0004\u0018\u00010'8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R1\u0010/\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00058F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R(\u00100\u001a\u00020\u00058\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "cancelPlacementAnimation", "()V", "Landroidx/compose/ui/unit/IntOffset;", "delta", BuildConfig.FLAVOR, "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animatePlacementDelta", "animateAppearance", "animateDisappearance", "release", "<set-?>", "isRunningMovingAwayAnimation", "Z", "()Z", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationFinished$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "rawOffset", "J", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placementDelta$delegate", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyLayoutItemAnimation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", BuildConfig.FLAVOR, "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m416getNotInitializednOccac() {
            return LazyLayoutItemAnimation.NotInitialized;
        }

        private Companion() {
        }
    }

    public abstract void animateAppearance();

    public abstract void animateDisappearance();

    /* renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public abstract void m408animatePlacementDeltaar5cAso(long delta, boolean isMovingAway);

    public abstract void cancelPlacementAnimation();

    /* renamed from: getFinalOffset-nOcc-ac, reason: not valid java name */
    public abstract long m409getFinalOffsetnOccac();

    public abstract GraphicsLayer getLayer();

    /* renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name */
    public abstract long m410getLookaheadOffsetnOccac();

    /* renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public abstract long m411getPlacementDeltanOccac();

    /* renamed from: getRawOffset-nOcc-ac, reason: not valid java name */
    public abstract long m412getRawOffsetnOccac();

    public abstract boolean isDisappearanceAnimationFinished();

    public abstract boolean isDisappearanceAnimationInProgress();

    public abstract boolean isPlacementAnimationInProgress();

    public abstract boolean isRunningMovingAwayAnimation();

    public abstract void release();

    /* renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public abstract void m413setFinalOffsetgyyYBs(long j5);

    /* renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public abstract void m414setLookaheadOffsetgyyYBs(long j5);

    /* renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public abstract void m415setRawOffsetgyyYBs(long j5);
}
