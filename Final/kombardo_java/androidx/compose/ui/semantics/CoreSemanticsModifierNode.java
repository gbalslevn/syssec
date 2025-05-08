package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\b*\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0013\u0010\u0012R.\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", BuildConfig.FLAVOR, "mergeDescendants", "isClearingSemantics", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", BuildConfig.FLAVOR, "properties", "<init>", "(ZZLkotlin/jvm/functions/Function1;)V", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Z", "getMergeDescendants", "()Z", "setMergeDescendants", "(Z)V", "setClearingSemantics", "Lkotlin/jvm/functions/Function1;", "getProperties", "()Lkotlin/jvm/functions/Function1;", "setProperties", "(Lkotlin/jvm/functions/Function1;)V", "getShouldClearDescendantSemantics", "shouldClearDescendantSemantics", "getShouldMergeDescendantSemantics", "shouldMergeDescendantSemantics", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean isClearingSemantics;
    private boolean mergeDescendants;
    private Function1<? super SemanticsPropertyReceiver, Unit> properties;

    public CoreSemanticsModifierNode(boolean z5, boolean z6, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        this.mergeDescendants = z5;
        this.isClearingSemantics = z6;
        this.properties = function1;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.properties.invoke(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* renamed from: getShouldClearDescendantSemantics, reason: from getter */
    public boolean getIsClearingSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* renamed from: getShouldMergeDescendantSemantics, reason: from getter */
    public boolean getMergeDescendants() {
        return this.mergeDescendants;
    }

    public final void setMergeDescendants(boolean z5) {
        this.mergeDescendants = z5;
    }

    public final void setProperties(Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        this.properties = function1;
    }
}
