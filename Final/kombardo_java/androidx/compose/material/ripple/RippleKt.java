package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u001a0\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", BuildConfig.FLAVOR, "createRippleModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createRippleModifierNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "rememberRipple", "Landroidx/compose/foundation/Indication;", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RippleKt {
    private static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec<>(15, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: createRippleModifierNode-TDGSqEk, reason: not valid java name */
    public static final DelegatableNode m759createRippleModifierNodeTDGSqEk(InteractionSource interactionSource, boolean z5, float f5, ColorProducer colorProducer, Function0<RippleAlpha> function0) {
        return Ripple_androidKt.m765createPlatformRippleNodeTDGSqEk(interactionSource, z5, f5, colorProducer, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        if (interaction instanceof HoverInteraction$Enter) {
            return DefaultTweenSpec;
        }
        if (!(interaction instanceof FocusInteraction$Focus) && !(interaction instanceof DragInteraction$Start)) {
            return DefaultTweenSpec;
        }
        return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        if (!(interaction instanceof HoverInteraction$Enter) && !(interaction instanceof FocusInteraction$Focus) && (interaction instanceof DragInteraction$Start)) {
            return new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, null);
        }
        return DefaultTweenSpec;
    }

    @Deprecated
    /* renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final Indication m760rememberRipple9IZ8Weo(boolean z5, float f5, long j5, Composer composer, int i5, int i6) {
        boolean z6 = true;
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if ((i6 & 2) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i6 & 4) != 0) {
            j5 = Color.INSTANCE.m1501getUnspecified0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1635163520, i5, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:146)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(j5), composer, (i5 >> 6) & 14);
        boolean z7 = (((i5 & 14) ^ 6) > 4 && composer.changed(z5)) || (i5 & 6) == 4;
        if ((((i5 & 112) ^ 48) <= 32 || !composer.changed(f5)) && (i5 & 48) != 32) {
            z6 = false;
        }
        boolean z8 = z7 | z6;
        Object rememberedValue = composer.rememberedValue();
        if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new PlatformRipple(z5, f5, rememberUpdatedState, null);
            composer.updateRememberedValue(rememberedValue);
        }
        PlatformRipple platformRipple = (PlatformRipple) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return platformRipple;
    }
}
