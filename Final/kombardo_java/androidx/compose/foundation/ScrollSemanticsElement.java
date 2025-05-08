package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\t\u0010\"R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\n\u0010\"¨\u0006&"}, d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "Landroidx/compose/foundation/ScrollState;", "state", BuildConfig.FLAVOR, "reverseScrolling", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "isScrollable", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "create", "()Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "node", BuildConfig.FLAVOR, "update", "(Landroidx/compose/foundation/ScrollSemanticsModifierNode;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/ScrollState;", "getState", "()Landroidx/compose/foundation/ScrollState;", "Z", "getReverseScrolling", "()Z", "Landroidx/compose/foundation/gestures/FlingBehavior;", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class ScrollSemanticsElement extends ModifierNodeElement<ScrollSemanticsModifierNode> {
    private final FlingBehavior flingBehavior;
    private final boolean isScrollable;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final ScrollState state;

    public ScrollSemanticsElement(ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6, boolean z7) {
        this.state = scrollState;
        this.reverseScrolling = z5;
        this.flingBehavior = flingBehavior;
        this.isScrollable = z6;
        this.isVertical = z7;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollSemanticsElement)) {
            return false;
        }
        ScrollSemanticsElement scrollSemanticsElement = (ScrollSemanticsElement) other;
        return Intrinsics.areEqual(this.state, scrollSemanticsElement.state) && this.reverseScrolling == scrollSemanticsElement.reverseScrolling && Intrinsics.areEqual(this.flingBehavior, scrollSemanticsElement.flingBehavior) && this.isScrollable == scrollSemanticsElement.isScrollable && this.isVertical == scrollSemanticsElement.isVertical;
    }

    public int hashCode() {
        int hashCode = ((this.state.hashCode() * 31) + Boolean.hashCode(this.reverseScrolling)) * 31;
        FlingBehavior flingBehavior = this.flingBehavior;
        return ((((hashCode + (flingBehavior == null ? 0 : flingBehavior.hashCode())) * 31) + Boolean.hashCode(this.isScrollable)) * 31) + Boolean.hashCode(this.isVertical);
    }

    public String toString() {
        return "ScrollSemanticsElement(state=" + this.state + ", reverseScrolling=" + this.reverseScrolling + ", flingBehavior=" + this.flingBehavior + ", isScrollable=" + this.isScrollable + ", isVertical=" + this.isVertical + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public ScrollSemanticsModifierNode getNode() {
        return new ScrollSemanticsModifierNode(this.state, this.reverseScrolling, this.flingBehavior, this.isScrollable, this.isVertical);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ScrollSemanticsModifierNode node) {
        node.setState(this.state);
        node.setReverseScrolling(this.reverseScrolling);
        node.setFlingBehavior(this.flingBehavior);
        node.setScrollable(this.isScrollable);
        node.setVertical(this.isVertical);
    }
}
