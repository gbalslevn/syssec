package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J$\u0010\u0016\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", BuildConfig.FLAVOR, "bounded", BuildConfig.FLAVOR, "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", BuildConfig.FLAVOR, "handleInteraction", BuildConfig.FLAVOR, "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final Function0<RippleAlpha> rippleAlpha;
    private final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List<Interaction> interactions = new ArrayList();

    public StateLayer(boolean z5, Function0<RippleAlpha> function0) {
        this.bounded = z5;
        this.rippleAlpha = function0;
    }

    /* renamed from: drawStateLayer-mxwnekA, reason: not valid java name */
    public final void m766drawStateLayermxwnekA(DrawScope drawScope, float f5, long j5) {
        long j6;
        float floatValue = this.animatedAlpha.getValue().floatValue();
        if (floatValue <= 0.0f) {
            return;
        }
        long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(j5, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.bounded) {
            DrawScope.m1690drawCircleVaOC9Bg$default(drawScope, m1485copywmQWz5c$default, f5, 0L, 0.0f, null, null, 0, 124, null);
            return;
        }
        float m1377getWidthimpl = Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc());
        float m1375getHeightimpl = Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc());
        int m1480getIntersectrtfAjoo = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo1685clipRectN_I0leg(0.0f, 0.0f, m1377getWidthimpl, m1375getHeightimpl, m1480getIntersectrtfAjoo);
            j6 = mo1682getSizeNHjbRc;
            try {
                DrawScope.m1690drawCircleVaOC9Bg$default(drawScope, m1485copywmQWz5c$default, f5, 0L, 0.0f, null, null, 0, 124, null);
                drawContext.getCanvas().restore();
                drawContext.mo1683setSizeuvyYCjk(j6);
            } catch (Throwable th) {
                th = th;
                drawContext.getCanvas().restore();
                drawContext.mo1683setSizeuvyYCjk(j6);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j6 = mo1682getSizeNHjbRc;
        }
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, CoroutineScope scope) {
        AnimationSpec outgoingStateLayerAnimationSpecFor;
        AnimationSpec incomingStateLayerAnimationSpecFor;
        boolean z5 = interaction instanceof HoverInteraction$Enter;
        if (z5) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction$Exit) {
            this.interactions.remove(((HoverInteraction$Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction$Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction$Unfocus) {
            this.interactions.remove(((FocusInteraction$Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction$Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction$Stop) {
            this.interactions.remove(((DragInteraction$Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction$Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction$Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull((List) this.interactions);
        if (Intrinsics.areEqual(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            RippleAlpha invoke = this.rippleAlpha.invoke();
            float hoveredAlpha = z5 ? invoke.getHoveredAlpha() : interaction instanceof FocusInteraction$Focus ? invoke.getFocusedAlpha() : interaction instanceof DragInteraction$Start ? invoke.getDraggedAlpha() : 0.0f;
            incomingStateLayerAnimationSpecFor = RippleKt.incomingStateLayerAnimationSpecFor(interaction2);
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(this, hoveredAlpha, incomingStateLayerAnimationSpecFor, null), 3, null);
        } else {
            outgoingStateLayerAnimationSpecFor = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$2(this, outgoingStateLayerAnimationSpecFor, null), 3, null);
        }
        this.currentInteraction = interaction2;
    }
}
