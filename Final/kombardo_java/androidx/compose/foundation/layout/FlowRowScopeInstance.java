package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0097\u0001¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u0005*\u00020\u0005H\u0097\u0001¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\r\u001a\u00020\u0005*\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0097\u0001¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "<init>", "()V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/Alignment$Vertical;", "alignment", "align", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/ui/Modifier;", "alignByBaseline", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "fill", "(Landroidx/compose/ui/Modifier;FZ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowRowScopeInstance implements RowScope, FlowRowScope {
    public static final FlowRowScopeInstance INSTANCE = new FlowRowScopeInstance();
    private final /* synthetic */ RowScopeInstance $$delegate_0 = RowScopeInstance.INSTANCE;

    private FlowRowScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier modifier, Alignment.Vertical vertical) {
        return this.$$delegate_0.align(modifier, vertical);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier modifier) {
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier modifier, float f5, boolean z5) {
        return this.$$delegate_0.weight(modifier, f5, z5);
    }
}
