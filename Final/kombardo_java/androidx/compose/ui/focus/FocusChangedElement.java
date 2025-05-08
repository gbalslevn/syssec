package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/focus/FocusChangedElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusChangedNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", BuildConfig.FLAVOR, "onFocusChanged", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "create", "()Landroidx/compose/ui/focus/FocusChangedNode;", "node", "update", "(Landroidx/compose/ui/focus/FocusChangedNode;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function1;", "getOnFocusChanged", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class FocusChangedElement extends ModifierNodeElement<FocusChangedNode> {
    private final Function1<FocusState, Unit> onFocusChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusChangedElement(Function1<? super FocusState, Unit> function1) {
        this.onFocusChanged = function1;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FocusChangedElement) && Intrinsics.areEqual(this.onFocusChanged, ((FocusChangedElement) other).onFocusChanged);
    }

    public int hashCode() {
        return this.onFocusChanged.hashCode();
    }

    public String toString() {
        return "FocusChangedElement(onFocusChanged=" + this.onFocusChanged + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create, reason: avoid collision after fix types in other method */
    public FocusChangedNode getNode() {
        return new FocusChangedNode(this.onFocusChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(FocusChangedNode node) {
        node.setOnFocusChanged(this.onFocusChanged);
    }
}
