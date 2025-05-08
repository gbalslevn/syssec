package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\u0018\"\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/foundation/ScrollState;", "state", BuildConfig.FLAVOR, "reverseScrolling", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "isScrollable", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", BuildConfig.FLAVOR, "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Landroidx/compose/foundation/ScrollState;", "getState", "()Landroidx/compose/foundation/ScrollState;", "setState", "(Landroidx/compose/foundation/ScrollState;)V", "Z", "getReverseScrolling", "()Z", "setReverseScrolling", "(Z)V", "Landroidx/compose/foundation/gestures/FlingBehavior;", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "setScrollable", "setVertical", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private FlingBehavior flingBehavior;
    private boolean isScrollable;
    private boolean isVertical;
    private boolean reverseScrolling;
    private ScrollState state;

    public ScrollSemanticsModifierNode(ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6, boolean z7) {
        this.state = scrollState;
        this.reverseScrolling = z5;
        this.flingBehavior = flingBehavior;
        this.isScrollable = z6;
        this.isVertical = z7;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(ScrollSemanticsModifierNode.this.getState().getValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(ScrollSemanticsModifierNode.this.getState().getMaxValue());
            }
        }, this.reverseScrolling);
        if (this.isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        }
    }

    public final ScrollState getState() {
        return this.state;
    }

    public final void setFlingBehavior(FlingBehavior flingBehavior) {
        this.flingBehavior = flingBehavior;
    }

    public final void setReverseScrolling(boolean z5) {
        this.reverseScrolling = z5;
    }

    public final void setScrollable(boolean z5) {
        this.isScrollable = z5;
    }

    public final void setState(ScrollState scrollState) {
        this.state = scrollState;
    }

    public final void setVertical(boolean z5) {
        this.isVertical = z5;
    }
}
