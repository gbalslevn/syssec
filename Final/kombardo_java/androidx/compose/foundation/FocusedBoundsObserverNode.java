package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u001d\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR0\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", BuildConfig.FLAVOR, "onPositioned", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "focusedBounds", "onFocusBoundsChanged", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Lkotlin/jvm/functions/Function1;", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "setOnPositioned", BuildConfig.FLAVOR, "traverseKey", "Ljava/lang/Object;", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusedBoundsObserverNode extends Modifier.Node implements TraversableNode {
    private Function1<? super LayoutCoordinates, Unit> onPositioned;
    private final Object traverseKey = INSTANCE;

    /* renamed from: TraverseKey, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode$TraverseKey;", BuildConfig.FLAVOR, "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.FocusedBoundsObserverNode$TraverseKey, reason: from kotlin metadata */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FocusedBoundsObserverNode(Function1<? super LayoutCoordinates, Unit> function1) {
        this.onPositioned = function1;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates focusedBounds) {
        this.onPositioned.invoke(focusedBounds);
        FocusedBoundsObserverNode focusedBoundsObserverNode = (FocusedBoundsObserverNode) TraversableNodeKt.findNearestAncestor(this);
        if (focusedBoundsObserverNode != null) {
            focusedBoundsObserverNode.onFocusBoundsChanged(focusedBounds);
        }
    }
}
