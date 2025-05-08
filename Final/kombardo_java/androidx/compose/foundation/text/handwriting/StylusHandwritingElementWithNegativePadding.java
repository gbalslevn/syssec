package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElementWithNegativePadding;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onHandwritingSlopExceeded", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "create", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "node", BuildConfig.FLAVOR, "update", "(Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function0;", "getOnHandwritingSlopExceeded", "()Lkotlin/jvm/functions/Function0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class StylusHandwritingElementWithNegativePadding extends ModifierNodeElement<StylusHandwritingNodeWithNegativePadding> {
    private final Function0<Boolean> onHandwritingSlopExceeded;

    public StylusHandwritingElementWithNegativePadding(Function0<Boolean> function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StylusHandwritingElementWithNegativePadding) && Intrinsics.areEqual(this.onHandwritingSlopExceeded, ((StylusHandwritingElementWithNegativePadding) other).onHandwritingSlopExceeded);
    }

    public int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    public String toString() {
        return "StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded=" + this.onHandwritingSlopExceeded + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public StylusHandwritingNodeWithNegativePadding getNode() {
        return new StylusHandwritingNodeWithNegativePadding(this.onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(StylusHandwritingNodeWithNegativePadding node) {
        node.setOnHandwritingSlopExceeded(this.onHandwritingSlopExceeded);
    }
}
