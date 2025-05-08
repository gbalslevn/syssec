package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", BuildConfig.FLAVOR, "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "initialOffset", BuildConfig.FLAVOR, "initialSize", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "sizeAnim", "onAttach", BuildConfig.FLAVOR, "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private boolean checked;
    private float initialOffset = Float.NaN;
    private float initialSize = Float.NaN;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable<Float, AnimationVector1D> offsetAnim;
    private Animatable<Float, AnimationVector1D> sizeAnim;

    public ThumbNode(InteractionSource interactionSource, boolean z5) {
        this.interactionSource = interactionSource;
        this.checked = z5;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        float f5;
        float f6;
        float f7;
        float mo212toPx0680j_4 = measureScope.mo212toPx0680j_4(this.isPressed ? SwitchTokens.INSTANCE.m1154getPressedHandleWidthD9Ej5fM() : ((measurable.maxIntrinsicHeight(Constraints.m2578getMaxWidthimpl(j5)) != 0 && measurable.maxIntrinsicWidth(Constraints.m2577getMaxHeightimpl(j5)) != 0) || this.checked) ? SwitchKt.getThumbDiameter() : SwitchKt.getUncheckedThumbDiameter());
        Animatable<Float, AnimationVector1D> animatable = this.sizeAnim;
        int floatValue = (int) (animatable != null ? animatable.getValue().floatValue() : mo212toPx0680j_4);
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.INSTANCE.m2587fixedJhjzzOo(floatValue, floatValue));
        f5 = SwitchKt.SwitchHeight;
        final float mo212toPx0680j_42 = measureScope.mo212toPx0680j_4(Dp.m2599constructorimpl(Dp.m2599constructorimpl(f5 - measureScope.mo208toDpu2uoSUM(mo212toPx0680j_4)) / 2.0f));
        f6 = SwitchKt.SwitchWidth;
        float m2599constructorimpl = Dp.m2599constructorimpl(f6 - SwitchKt.getThumbDiameter());
        f7 = SwitchKt.ThumbPadding;
        float mo212toPx0680j_43 = measureScope.mo212toPx0680j_4(Dp.m2599constructorimpl(m2599constructorimpl - f7));
        boolean z5 = this.isPressed;
        if (z5 && this.checked) {
            mo212toPx0680j_42 = mo212toPx0680j_43 - measureScope.mo212toPx0680j_4(SwitchTokens.INSTANCE.m1158getTrackOutlineWidthD9Ej5fM());
        } else if (z5 && !this.checked) {
            mo212toPx0680j_42 = measureScope.mo212toPx0680j_4(SwitchTokens.INSTANCE.m1158getTrackOutlineWidthD9Ej5fM());
        } else if (this.checked) {
            mo212toPx0680j_42 = mo212toPx0680j_43;
        }
        Animatable<Float, AnimationVector1D> animatable2 = this.sizeAnim;
        if (!Intrinsics.areEqual(animatable2 != null ? animatable2.getTargetValue() : null, mo212toPx0680j_4)) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, mo212toPx0680j_4, null), 3, null);
        }
        Animatable<Float, AnimationVector1D> animatable3 = this.offsetAnim;
        if (!Intrinsics.areEqual(animatable3 != null ? animatable3.getTargetValue() : null, mo212toPx0680j_42)) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$2(this, mo212toPx0680j_42, null), 3, null);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = mo212toPx0680j_4;
            this.initialOffset = mo212toPx0680j_42;
        }
        return MeasureScope.layout$default(measureScope, floatValue, floatValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ThumbNode$measure$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Animatable animatable4;
                Placeable placeable = Placeable.this;
                animatable4 = this.offsetAnim;
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (int) (animatable4 != null ? ((Number) animatable4.getValue()).floatValue() : mo212toPx0680j_42), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$onAttach$1(this, null), 3, null);
    }

    public final void setChecked(boolean z5) {
        this.checked = z5;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        this.interactionSource = interactionSource;
    }

    public final void update() {
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, 0.0f, 2, null);
        }
        if (this.offsetAnim != null || Float.isNaN(this.initialOffset)) {
            return;
        }
        this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, 0.0f, 2, null);
    }
}
