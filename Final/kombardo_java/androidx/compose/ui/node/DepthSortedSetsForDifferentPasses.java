package androidx.compose.ui.node;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000bJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extraAssertions", "<init>", "(Z)V", "Landroidx/compose/ui/node/LayoutNode;", "node", "affectsLookahead", "contains", "(Landroidx/compose/ui/node/LayoutNode;Z)Z", "(Landroidx/compose/ui/node/LayoutNode;)Z", BuildConfig.FLAVOR, "add", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "remove", "isEmpty", "()Z", "(Z)Z", "isNotEmpty", "Landroidx/compose/ui/node/DepthSortedSet;", "lookaheadSet", "Landroidx/compose/ui/node/DepthSortedSet;", "set", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DepthSortedSetsForDifferentPasses {
    private final DepthSortedSet lookaheadSet;
    private final DepthSortedSet set;

    public DepthSortedSetsForDifferentPasses(boolean z5) {
        this.lookaheadSet = new DepthSortedSet(z5);
        this.set = new DepthSortedSet(z5);
    }

    public final void add(LayoutNode node, boolean affectsLookahead) {
        if (affectsLookahead) {
            this.lookaheadSet.add(node);
            this.set.add(node);
        } else {
            if (this.lookaheadSet.contains(node)) {
                return;
            }
            this.set.add(node);
        }
    }

    public final boolean contains(LayoutNode node, boolean affectsLookahead) {
        boolean contains = this.lookaheadSet.contains(node);
        return affectsLookahead ? contains : contains || this.set.contains(node);
    }

    public final boolean isEmpty() {
        return this.set.isEmpty() && this.lookaheadSet.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final boolean remove(LayoutNode node) {
        return this.set.remove(node) || this.lookaheadSet.remove(node);
    }

    public final boolean isEmpty(boolean affectsLookahead) {
        return (affectsLookahead ? this.lookaheadSet : this.set).isEmpty();
    }

    public final boolean contains(LayoutNode node) {
        return this.lookaheadSet.contains(node) || this.set.contains(node);
    }
}
