package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\tJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0006`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSet;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extraAssertions", "<init>", "(Z)V", "Landroidx/compose/ui/node/LayoutNode;", "node", "contains", "(Landroidx/compose/ui/node/LayoutNode;)Z", BuildConfig.FLAVOR, "add", "(Landroidx/compose/ui/node/LayoutNode;)V", "remove", "pop", "()Landroidx/compose/ui/node/LayoutNode;", "isEmpty", "()Z", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mapOfOriginalDepth$delegate", "Lkotlin/Lazy;", "getMapOfOriginalDepth", "()Ljava/util/Map;", "mapOfOriginalDepth", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/TreeSet;", "set", "Landroidx/compose/ui/node/TreeSet;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DepthSortedSet {
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;

    /* renamed from: mapOfOriginalDepth$delegate, reason: from kotlin metadata */
    private final Lazy mapOfOriginalDepth = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Map<LayoutNode, Integer>>() { // from class: androidx.compose.ui.node.DepthSortedSet$mapOfOriginalDepth$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<LayoutNode, Integer> invoke() {
            return new LinkedHashMap();
        }
    });
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet(boolean z5) {
        this.extraAssertions = z5;
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(LayoutNode a5, LayoutNode b5) {
                int compare = Intrinsics.compare(a5.getDepth(), b5.getDepth());
                return compare != 0 ? compare : Intrinsics.compare(a5.hashCode(), b5.hashCode());
            }
        };
        this.DepthComparator = comparator;
        this.set = new TreeSet<>(comparator);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth.getValue();
    }

    public final void add(LayoutNode node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        if (this.extraAssertions) {
            Integer num = getMapOfOriginalDepth().get(node);
            if (num == null) {
                getMapOfOriginalDepth().put(node, Integer.valueOf(node.getDepth()));
            } else {
                if (!(num.intValue() == node.getDepth())) {
                    InlineClassHelperKt.throwIllegalStateException("invalid node depth");
                }
            }
        }
        this.set.add(node);
    }

    public final boolean contains(LayoutNode node) {
        boolean contains = this.set.contains(node);
        if (this.extraAssertions) {
            if (!(contains == getMapOfOriginalDepth().containsKey(node))) {
                InlineClassHelperKt.throwIllegalStateException("inconsistency in TreeSet");
            }
        }
        return contains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final LayoutNode pop() {
        LayoutNode first = this.set.first();
        remove(first);
        return first;
    }

    public final boolean remove(LayoutNode node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        boolean remove = this.set.remove(node);
        if (this.extraAssertions) {
            if (!Intrinsics.areEqual(getMapOfOriginalDepth().remove(node), remove ? Integer.valueOf(node.getDepth()) : null)) {
                InlineClassHelperKt.throwIllegalStateException("invalid node depth");
            }
        }
        return remove;
    }

    public String toString() {
        return this.set.toString();
    }
}
