package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002%&B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "prefetchScheduler", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", BuildConfig.FLAVOR, "onNestedPrefetch", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "index", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrefetch", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "()Ljava/util/List;", "collectNestedPrefetchRequests", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "NestedPrefetchScopeImpl", "PrefetchHandle", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    private final Function1<NestedPrefetchScope, Unit> onNestedPrefetch;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;
    private final PrefetchScheduler prefetchScheduler;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "_requests", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "requests", BuildConfig.FLAVOR, "getRequests", "()Ljava/util/List;", "schedulePrefetch", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class NestedPrefetchScopeImpl implements NestedPrefetchScope {
        private final List<PrefetchRequest> _requests = new ArrayList();

        public NestedPrefetchScopeImpl() {
        }

        public final List<PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrefetch(int index) {
            m424schedulePrefetch0kLqBqw(index, LazyLayoutPrefetchStateKt.access$getZeroConstraints$p());
        }

        /* renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        public void m424schedulePrefetch0kLqBqw(int index, long constraints) {
            PrefetchHandleProvider prefetchHandleProvider = LazyLayoutPrefetchState.this.getPrefetchHandleProvider();
            if (prefetchHandleProvider == null) {
                return;
            }
            this._requests.add(prefetchHandleProvider.m429createNestedPrefetchRequestVKLhPVY(index, constraints, LazyLayoutPrefetchState.this.prefetchMetrics));
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", BuildConfig.FLAVOR, "cancel", BuildConfig.FLAVOR, "markAsUrgent", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1<? super NestedPrefetchScope, Unit> function1) {
        this.prefetchScheduler = prefetchScheduler;
        this.onNestedPrefetch = function1;
        this.prefetchMetrics = new PrefetchMetrics();
    }

    public final List<PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1<NestedPrefetchScope, Unit> function1 = this.onNestedPrefetch;
        if (function1 == null) {
            return CollectionsKt.emptyList();
        }
        NestedPrefetchScopeImpl nestedPrefetchScopeImpl = new NestedPrefetchScopeImpl();
        function1.invoke(nestedPrefetchScopeImpl);
        return nestedPrefetchScopeImpl.getRequests();
    }

    /* renamed from: getPrefetchHandleProvider$foundation_release, reason: from getter */
    public final PrefetchHandleProvider getPrefetchHandleProvider() {
        return this.prefetchHandleProvider;
    }

    /* renamed from: getPrefetchScheduler$foundation_release, reason: from getter */
    public final PrefetchScheduler getPrefetchScheduler() {
        return this.prefetchScheduler;
    }

    /* renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m423schedulePrefetch0kLqBqw(int index, long constraints) {
        PrefetchHandle m430schedulePrefetchVKLhPVY;
        PrefetchHandleProvider prefetchHandleProvider = this.prefetchHandleProvider;
        return (prefetchHandleProvider == null || (m430schedulePrefetchVKLhPVY = prefetchHandleProvider.m430schedulePrefetchVKLhPVY(index, constraints, this.prefetchMetrics)) == null) ? DummyHandle.INSTANCE : m430schedulePrefetchVKLhPVY;
    }

    public final void setPrefetchHandleProvider$foundation_release(PrefetchHandleProvider prefetchHandleProvider) {
        this.prefetchHandleProvider = prefetchHandleProvider;
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1 function1, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : prefetchScheduler, (i5 & 2) != 0 ? null : function1);
    }
}
