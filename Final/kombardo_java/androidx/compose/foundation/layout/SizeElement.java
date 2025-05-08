package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", "maxWidth", "maxHeight", BuildConfig.FLAVOR, "enforceIncoming", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "()Landroidx/compose/foundation/layout/SizeNode;", "node", "update", "(Landroidx/compose/foundation/layout/SizeNode;)V", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "F", "Z", "Lkotlin/jvm/functions/Function1;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float f5, float f6, float f7, float f8, boolean z5, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, z5, function1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) other;
        return Dp.m2601equalsimpl0(this.minWidth, sizeElement.minWidth) && Dp.m2601equalsimpl0(this.minHeight, sizeElement.minHeight) && Dp.m2601equalsimpl0(this.maxWidth, sizeElement.maxWidth) && Dp.m2601equalsimpl0(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming;
    }

    public int hashCode() {
        return (((((((Dp.m2602hashCodeimpl(this.minWidth) * 31) + Dp.m2602hashCodeimpl(this.minHeight)) * 31) + Dp.m2602hashCodeimpl(this.maxWidth)) * 31) + Dp.m2602hashCodeimpl(this.maxHeight)) * 31) + Boolean.hashCode(this.enforceIncoming);
    }

    public /* synthetic */ SizeElement(float f5, float f6, float f7, float f8, boolean z5, Function1 function1, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f5, (i5 & 2) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f6, (i5 & 4) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f7, (i5 & 8) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f8, z5, function1, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SizeNode getNode() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SizeNode node) {
        node.m343setMinWidth0680j_4(this.minWidth);
        node.m342setMinHeight0680j_4(this.minHeight);
        node.m341setMaxWidth0680j_4(this.maxWidth);
        node.m340setMaxHeight0680j_4(this.maxHeight);
        node.setEnforceIncoming(this.enforceIncoming);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SizeElement(float f5, float f6, float f7, float f8, boolean z5, Function1<? super InspectorInfo, Unit> function1) {
        this.minWidth = f5;
        this.minHeight = f6;
        this.maxWidth = f7;
        this.maxHeight = f8;
        this.enforceIncoming = z5;
        this.inspectorInfo = function1;
    }
}
