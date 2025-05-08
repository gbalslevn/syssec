package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b#\u0010\u001f¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/OffsetPxElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetPxNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "offset", BuildConfig.FLAVOR, "rtlAware", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "<init>", "(Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;)V", "create", "()Landroidx/compose/foundation/layout/OffsetPxNode;", "node", "update", "(Landroidx/compose/foundation/layout/OffsetPxNode;)V", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "Lkotlin/jvm/functions/Function1;", "getOffset", "()Lkotlin/jvm/functions/Function1;", "Z", "getRtlAware", "()Z", "getInspectorInfo", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.OffsetPxElement, reason: from toString */
/* loaded from: classes.dex */
final class OffsetPxModifier extends ModifierNodeElement<OffsetPxNode> {
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final Function1<Density, IntOffset> offset;
    private final boolean rtlAware;

    /* JADX WARN: Multi-variable type inference failed */
    public OffsetPxModifier(Function1<? super Density, IntOffset> function1, boolean z5, Function1<? super InspectorInfo, Unit> function12) {
        this.offset = function1;
        this.rtlAware = z5;
        this.inspectorInfo = function12;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        OffsetPxModifier offsetPxModifier = other instanceof OffsetPxModifier ? (OffsetPxModifier) other : null;
        if (offsetPxModifier == null) {
            return false;
        }
        return this.offset == offsetPxModifier.offset && this.rtlAware == offsetPxModifier.rtlAware;
    }

    public int hashCode() {
        return (this.offset.hashCode() * 31) + Boolean.hashCode(this.rtlAware);
    }

    public String toString() {
        return "OffsetPxModifier(offset=" + this.offset + ", rtlAware=" + this.rtlAware + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public OffsetPxNode getNode() {
        return new OffsetPxNode(this.offset, this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(OffsetPxNode node) {
        node.setOffset(this.offset);
        node.setRtlAware(this.rtlAware);
    }
}
