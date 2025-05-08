package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R(\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/PaddingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/unit/Dp;", "start", "top", "end", "bottom", BuildConfig.FLAVOR, "rtlAware", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "F", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "Z", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    private float bottom;
    private float end;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingNode(float f5, float f6, float f7, float f8, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, z5);
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
        int mo206roundToPx0680j_4 = measureScope.mo206roundToPx0680j_4(this.start) + measureScope.mo206roundToPx0680j_4(this.end);
        int mo206roundToPx0680j_42 = measureScope.mo206roundToPx0680j_4(this.top) + measureScope.mo206roundToPx0680j_4(this.bottom);
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(ConstraintsKt.m2595offsetNN6EwU(j5, -mo206roundToPx0680j_4, -mo206roundToPx0680j_42));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m2593constrainWidthK40F9xA(j5, mo1946measureBRTryo0.getWidth() + mo206roundToPx0680j_4), ConstraintsKt.m2592constrainHeightK40F9xA(j5, mo1946measureBRTryo0.getHeight() + mo206roundToPx0680j_42), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingNode$measure$1
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
                if (PaddingNode.this.getRtlAware()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo0, measureScope.mo206roundToPx0680j_4(PaddingNode.this.getStart()), measureScope.mo206roundToPx0680j_4(PaddingNode.this.getTop()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.place$default(placementScope, mo1946measureBRTryo0, measureScope.mo206roundToPx0680j_4(PaddingNode.this.getStart()), measureScope.mo206roundToPx0680j_4(PaddingNode.this.getTop()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    /* renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m318setBottom0680j_4(float f5) {
        this.bottom = f5;
    }

    /* renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m319setEnd0680j_4(float f5) {
        this.end = f5;
    }

    public final void setRtlAware(boolean z5) {
        this.rtlAware = z5;
    }

    /* renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m320setStart0680j_4(float f5) {
        this.start = f5;
    }

    /* renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m321setTop0680j_4(float f5) {
        this.top = f5;
    }

    private PaddingNode(float f5, float f6, float f7, float f8, boolean z5) {
        this.start = f5;
        this.top = f6;
        this.end = f7;
        this.bottom = f8;
        this.rtlAware = z5;
    }
}
