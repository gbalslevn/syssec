package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\f\u0010\u001d\u001a\u00020\u0013*\u00020\u001eH\u0016R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/material/ripple/CommonRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripples", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", BuildConfig.FLAVOR, "interaction", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", BuildConfig.FLAVOR, "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "onDetach", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CommonRippleNode extends RippleNode {
    private final MutableScatterMap<PressInteraction.Press, RippleAnimation> ripples;

    public /* synthetic */ CommonRippleNode(InteractionSource interactionSource, boolean z5, float f5, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z5, f5, colorProducer, function0);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    /* renamed from: addRipple-12SF9DM */
    public void mo750addRipple12SF9DM(PressInteraction.Press interaction, long size, float targetRadius) {
        MutableScatterMap<PressInteraction.Press, RippleAnimation> mutableScatterMap = this.ripples;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            ((RippleAnimation) objArr2[i8]).finish();
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        RippleAnimation rippleAnimation = new RippleAnimation(getBounded() ? Offset.m1328boximpl(interaction.getPressPosition()) : null, targetRadius, getBounded(), null);
        this.ripples.set(interaction, rippleAnimation);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CommonRippleNode$addRipple$2(rippleAnimation, this, interaction, null), 3, null);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope drawScope) {
        float f5;
        float f6;
        int i5;
        int i6;
        int i7;
        float pressedAlpha = getRippleAlpha().invoke().getPressedAlpha();
        if (pressedAlpha == 0.0f) {
            return;
        }
        MutableScatterMap<PressInteraction.Press, RippleAnimation> mutableScatterMap = this.ripples;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i8 = 0;
        while (true) {
            long j5 = jArr[i8];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i9 = 8;
                int i10 = 8 - ((~(i8 - length)) >>> 31);
                long j6 = j5;
                int i11 = 0;
                while (i11 < i10) {
                    if ((j6 & 255) < 128) {
                        int i12 = (i8 << 3) + i11;
                        float f7 = pressedAlpha;
                        i5 = i11;
                        i6 = i10;
                        f6 = pressedAlpha;
                        i7 = i9;
                        ((RippleAnimation) objArr2[i12]).m753draw4WTKRHQ(drawScope, Color.m1485copywmQWz5c$default(m761getRippleColor0d7_KjU(), f7, 0.0f, 0.0f, 0.0f, 14, null));
                    } else {
                        f6 = pressedAlpha;
                        i5 = i11;
                        i6 = i10;
                        i7 = i9;
                    }
                    j6 >>= i7;
                    i11 = i5 + 1;
                    i9 = i7;
                    pressedAlpha = f6;
                    i10 = i6;
                }
                f5 = pressedAlpha;
                if (i10 != i9) {
                    return;
                }
            } else {
                f5 = pressedAlpha;
            }
            if (i8 == length) {
                return;
            }
            i8++;
            pressedAlpha = f5;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.ripples.clear();
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press interaction) {
        RippleAnimation rippleAnimation = this.ripples.get(interaction);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }

    private CommonRippleNode(InteractionSource interactionSource, boolean z5, float f5, ColorProducer colorProducer, Function0<RippleAlpha> function0) {
        super(interactionSource, z5, f5, colorProducer, function0, null);
        this.ripples = new MutableScatterMap<>(0, 1, null);
    }
}
