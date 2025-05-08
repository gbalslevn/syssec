package androidx.compose.material.ripple;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H&ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020*H\u0016J\u001a\u00103\u001a\u00020*2\u0006\u0010-\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020*2\u0006\u0010+\u001a\u00020,H&J\u0018\u00108\u001a\u00020*2\u0006\u0010+\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\f\u0010<\u001a\u00020**\u00020=H\u0016J\f\u0010>\u001a\u00020**\u00020?H&R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u001b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR&\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b!\u0010\u001dR\u0014\u0010#\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBounded", "()Z", "hasValidSize", "pendingInteractions", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/interaction/PressInteraction;", "F", "getRippleAlpha", "()Lkotlin/jvm/functions/Function0;", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "getRippleColor-0d7_KjU", "()J", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "rippleSize", "getRippleSize-NH-jbRc", "J", "shouldAutoInvalidate", "getShouldAutoInvalidate", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "targetRadius", BuildConfig.FLAVOR, "addRipple", BuildConfig.FLAVOR, "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "handlePressInteraction", "pressInteraction", "onAttach", "onRemeasured", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    private final boolean bounded;
    private final ColorProducer color;
    private boolean hasValidSize;
    private final InteractionSource interactionSource;
    private final MutableObjectList<PressInteraction> pendingInteractions;
    private final float radius;
    private final Function0<RippleAlpha> rippleAlpha;
    private long rippleSize;
    private final boolean shouldAutoInvalidate;
    private StateLayer stateLayer;
    private float targetRadius;

    public /* synthetic */ RippleNode(InteractionSource interactionSource, boolean z5, float f5, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z5, f5, colorProducer, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePressInteraction(PressInteraction pressInteraction) {
        if (pressInteraction instanceof PressInteraction.Press) {
            mo750addRipple12SF9DM((PressInteraction.Press) pressInteraction, this.rippleSize, this.targetRadius);
        } else if (pressInteraction instanceof PressInteraction.Release) {
            removeRipple(((PressInteraction.Release) pressInteraction).getPress());
        } else if (pressInteraction instanceof PressInteraction.Cancel) {
            removeRipple(((PressInteraction.Cancel) pressInteraction).getPress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStateLayer(Interaction interaction, CoroutineScope scope) {
        StateLayer stateLayer = this.stateLayer;
        if (stateLayer == null) {
            stateLayer = new StateLayer(this.bounded, this.rippleAlpha);
            DrawModifierNodeKt.invalidateDraw(this);
            this.stateLayer = stateLayer;
        }
        stateLayer.handleInteraction$material_ripple_release(interaction, scope);
    }

    /* renamed from: addRipple-12SF9DM */
    public abstract void mo750addRipple12SF9DM(PressInteraction.Press interaction, long size, float targetRadius);

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        StateLayer stateLayer = this.stateLayer;
        if (stateLayer != null) {
            stateLayer.m766drawStateLayermxwnekA(contentDrawScope, this.targetRadius, m761getRippleColor0d7_KjU());
        }
        drawRipples(contentDrawScope);
    }

    public abstract void drawRipples(DrawScope drawScope);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getBounded() {
        return this.bounded;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function0<RippleAlpha> getRippleAlpha() {
        return this.rippleAlpha;
    }

    /* renamed from: getRippleColor-0d7_KjU, reason: not valid java name */
    public final long m761getRippleColor0d7_KjU() {
        return this.color.mo687invoke0d7_KjU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getRippleSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getRippleSize() {
        return this.rippleSize;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new RippleNode$onAttach$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo177onRemeasuredozmzZPI(long size) {
        this.hasValidSize = true;
        Density requireDensity = DelegatableNodeKt.requireDensity(this);
        this.rippleSize = IntSizeKt.m2668toSizeozmzZPI(size);
        this.targetRadius = Float.isNaN(this.radius) ? RippleAnimationKt.m754getRippleEndRadiuscSwnlzA(requireDensity, this.bounded, this.rippleSize) : requireDensity.mo212toPx0680j_4(this.radius);
        MutableObjectList<PressInteraction> mutableObjectList = this.pendingInteractions;
        Object[] objArr = mutableObjectList.content;
        int i5 = mutableObjectList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            handlePressInteraction((PressInteraction) objArr[i6]);
        }
        this.pendingInteractions.clear();
    }

    public abstract void removeRipple(PressInteraction.Press interaction);

    private RippleNode(InteractionSource interactionSource, boolean z5, float f5, ColorProducer colorProducer, Function0<RippleAlpha> function0) {
        this.interactionSource = interactionSource;
        this.bounded = z5;
        this.radius = f5;
        this.color = colorProducer;
        this.rippleAlpha = function0;
        this.rippleSize = Size.INSTANCE.m1384getZeroNHjbRc();
        this.pendingInteractions = new MutableObjectList<>(0, 1, null);
    }
}
