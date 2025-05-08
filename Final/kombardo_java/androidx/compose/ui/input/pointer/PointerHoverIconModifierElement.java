package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "icon", BuildConfig.FLAVOR, "overrideDescendants", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "create", "()Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "node", BuildConfig.FLAVOR, "update", "(Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "Z", "getOverrideDescendants", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PointerHoverIconModifierElement extends ModifierNodeElement<PointerHoverIconModifierNode> {
    private final PointerIcon icon;
    private final boolean overrideDescendants;

    public PointerHoverIconModifierElement(PointerIcon pointerIcon, boolean z5) {
        this.icon = pointerIcon;
        this.overrideDescendants = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerHoverIconModifierElement)) {
            return false;
        }
        PointerHoverIconModifierElement pointerHoverIconModifierElement = (PointerHoverIconModifierElement) other;
        return Intrinsics.areEqual(this.icon, pointerHoverIconModifierElement.icon) && this.overrideDescendants == pointerHoverIconModifierElement.overrideDescendants;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + Boolean.hashCode(this.overrideDescendants);
    }

    public String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create, reason: avoid collision after fix types in other method */
    public PointerHoverIconModifierNode getNode() {
        return new PointerHoverIconModifierNode(this.icon, this.overrideDescendants);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(PointerHoverIconModifierNode node) {
        node.setIcon(this.icon);
        node.setOverrideDescendants(this.overrideDescendants);
    }
}
