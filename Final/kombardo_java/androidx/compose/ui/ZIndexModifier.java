package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/ZIndexNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "zIndex", BuildConfig.FLAVOR, "(F)V", "getZIndex", "()F", "setZIndex", "toString", BuildConfig.FLAVOR, "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.ui.ZIndexNode, reason: from toString */
/* loaded from: classes.dex */
public final class ZIndexModifier extends Modifier.Node implements LayoutModifierNode {
    private float zIndex;

    public ZIndexModifier(float f5) {
        this.zIndex = f5;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.ZIndexNode$measure$1
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
                placementScope.place(Placeable.this, 0, 0, this.getZIndex());
            }
        }, 4, null);
    }

    public final void setZIndex(float f5) {
        this.zIndex = f5;
    }

    public String toString() {
        return "ZIndexModifier(zIndex=" + this.zIndex + ')';
    }
}
