package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", BuildConfig.FLAVOR, "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "createNestedPrefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", BuildConfig.FLAVOR, "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrefetch-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrefetchHandleProvider {
    private final PrefetchScheduler executor;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final SubcomposeLayoutState subcomposeLayoutState;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\f\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015H\u0002J\b\u0010 \u001a\u00020!H\u0016J\f\u0010\"\u001a\u00020\f*\u00020#H\u0016J\u0014\u0010$\u001a\u00020\f*\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\f\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", BuildConfig.FLAVOR, "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "hasResolvedNestedPrefetches", BuildConfig.FLAVOR, "isCanceled", "isComposed", "()Z", "isMeasured", "isUrgent", "isValid", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "cancel", BuildConfig.FLAVOR, "markAsUrgent", "performComposition", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", BuildConfig.FLAVOR, "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "shouldExecute", "average", BuildConfig.FLAVOR, "NestedPrefetchController", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest {
        private final long constraints;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private NestedPrefetchController nestedPrefetchController;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\r\u001a\u00020\u000e*\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00030\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", BuildConfig.FLAVOR, "states", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestIndex", BuildConfig.FLAVOR, "requestsByState", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "executeNestedPrefetches", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public final class NestedPrefetchController {
            private int requestIndex;
            private final List<PrefetchRequest>[] requestsByState;
            private int stateIndex;
            private final List<LazyLayoutPrefetchState> states;

            public NestedPrefetchController(List<LazyLayoutPrefetchState> list) {
                this.states = list;
                this.requestsByState = new List[list.size()];
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
                }
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope prefetchRequestScope) {
                if (this.stateIndex >= this.states.size()) {
                    return false;
                }
                if (HandleAndRequestImpl.this.isCanceled) {
                    throw new IllegalStateException("Should not execute nested prefetch on canceled request");
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.stateIndex < this.states.size()) {
                    try {
                        if (this.requestsByState[this.stateIndex] == null) {
                            if (prefetchRequestScope.availableTimeNanos() <= 0) {
                                Trace.endSection();
                                return true;
                            }
                            List<PrefetchRequest>[] listArr = this.requestsByState;
                            int i5 = this.stateIndex;
                            listArr[i5] = this.states.get(i5).collectNestedPrefetchRequests$foundation_release();
                        }
                        List<PrefetchRequest> list = this.requestsByState[this.stateIndex];
                        Intrinsics.checkNotNull(list);
                        while (this.requestIndex < list.size()) {
                            if (list.get(this.requestIndex).execute(prefetchRequestScope)) {
                                Trace.endSection();
                                return true;
                            }
                            this.requestIndex++;
                        }
                        this.requestIndex = 0;
                        this.stateIndex++;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return false;
            }
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i5, long j5, PrefetchMetrics prefetchMetrics, DefaultConstructorMarker defaultConstructorMarker) {
            this(i5, j5, prefetchMetrics);
        }

        private final boolean isComposed() {
            return this.precomposeHandle != null;
        }

        private final boolean isValid() {
            if (!this.isCanceled) {
                int itemCount = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke().getItemCount();
                int i5 = this.index;
                if (i5 >= 0 && i5 < itemCount) {
                    return true;
                }
            }
            return false;
        }

        private final void performComposition() {
            if (!isValid()) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()");
            }
            if (this.precomposeHandle != null) {
                throw new IllegalArgumentException("Request was already composed!");
            }
            LazyLayoutItemProvider invoke = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke();
            Object key = invoke.getKey(this.index);
            this.precomposeHandle = PrefetchHandleProvider.this.subcomposeLayoutState.precompose(key, PrefetchHandleProvider.this.itemContentFactory.getContent(this.index, key, invoke.getContentType(this.index)));
        }

        /* renamed from: performMeasure-BRTryo0, reason: not valid java name */
        private final void m431performMeasureBRTryo0(long constraints) {
            if (this.isCanceled) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
            }
            if (this.isMeasured) {
                throw new IllegalArgumentException("Request was already measured!");
            }
            this.isMeasured = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle == null) {
                throw new IllegalArgumentException("performComposition() must be called before performMeasure()");
            }
            int placeablesCount = precomposedSlotHandle.getPlaceablesCount();
            for (int i5 = 0; i5 < placeablesCount; i5++) {
                precomposedSlotHandle.mo1957premeasure0kLqBqw(i5, constraints);
            }
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle == null) {
                throw new IllegalArgumentException("Should precompose before resolving nested prefetch states");
            }
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            precomposedSlotHandle.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new Function1<TraversableNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(TraversableNode traversableNode) {
                    T t5;
                    Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
                    LazyLayoutPrefetchState prefetchState = ((TraversablePrefetchStateNode) traversableNode).getPrefetchState();
                    Ref$ObjectRef<List<LazyLayoutPrefetchState>> ref$ObjectRef2 = ref$ObjectRef;
                    List<LazyLayoutPrefetchState> list = ref$ObjectRef2.element;
                    if (list != null) {
                        list.add(prefetchState);
                        t5 = list;
                    } else {
                        t5 = CollectionsKt.mutableListOf(prefetchState);
                    }
                    ref$ObjectRef2.element = t5;
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
            });
            List list = (List) ref$ObjectRef.element;
            if (list != null) {
                return new NestedPrefetchController(list);
            }
            return null;
        }

        private final boolean shouldExecute(PrefetchRequestScope prefetchRequestScope, long j5) {
            long availableTimeNanos = prefetchRequestScope.availableTimeNanos();
            return (this.isUrgent && availableTimeNanos > 0) || j5 < availableTimeNanos;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                precomposedSlotHandle.dispose();
            }
            this.precomposeHandle = null;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean execute(PrefetchRequestScope prefetchRequestScope) {
            if (!isValid()) {
                return false;
            }
            Object contentType = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke().getContentType(this.index);
            if (!isComposed()) {
                if (!shouldExecute(prefetchRequestScope, (contentType == null || !this.prefetchMetrics.getAverageCompositionTimeNanosByContentType().contains(contentType)) ? this.prefetchMetrics.getAverageCompositionTimeNanos() : this.prefetchMetrics.getAverageCompositionTimeNanosByContentType().get(contentType))) {
                    return true;
                }
                PrefetchMetrics prefetchMetrics = this.prefetchMetrics;
                long nanoTime = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:compose");
                try {
                    performComposition();
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    if (contentType != null) {
                        prefetchMetrics.getAverageCompositionTimeNanosByContentType().set(contentType, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics, nanoTime2, prefetchMetrics.getAverageCompositionTimeNanosByContentType().getOrDefault(contentType, 0L)));
                    }
                    PrefetchMetrics.access$setAverageCompositionTimeNanos$p(prefetchMetrics, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics, nanoTime2, prefetchMetrics.getAverageCompositionTimeNanos()));
                } finally {
                }
            }
            if (!this.isUrgent) {
                if (!this.hasResolvedNestedPrefetches) {
                    if (prefetchRequestScope.availableTimeNanos() <= 0) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                    try {
                        this.nestedPrefetchController = resolveNestedPrefetchStates();
                        this.hasResolvedNestedPrefetches = true;
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                    }
                }
                NestedPrefetchController nestedPrefetchController = this.nestedPrefetchController;
                if (nestedPrefetchController != null ? nestedPrefetchController.executeNestedPrefetches(prefetchRequestScope) : false) {
                    return true;
                }
            }
            if (!this.isMeasured && !Constraints.m2582isZeroimpl(this.constraints)) {
                if (!shouldExecute(prefetchRequestScope, (contentType == null || !this.prefetchMetrics.getAverageMeasureTimeNanosByContentType().contains(contentType)) ? this.prefetchMetrics.getAverageMeasureTimeNanos() : this.prefetchMetrics.getAverageMeasureTimeNanosByContentType().get(contentType))) {
                    return true;
                }
                PrefetchMetrics prefetchMetrics2 = this.prefetchMetrics;
                long nanoTime3 = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:measure");
                try {
                    m431performMeasureBRTryo0(this.constraints);
                    Unit unit3 = Unit.INSTANCE;
                    Trace.endSection();
                    long nanoTime4 = System.nanoTime() - nanoTime3;
                    if (contentType != null) {
                        prefetchMetrics2.getAverageMeasureTimeNanosByContentType().set(contentType, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics2, nanoTime4, prefetchMetrics2.getAverageMeasureTimeNanosByContentType().getOrDefault(contentType, 0L)));
                    }
                    PrefetchMetrics.access$setAverageMeasureTimeNanos$p(prefetchMetrics2, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics2, nanoTime4, prefetchMetrics2.getAverageMeasureTimeNanos()));
                } finally {
                }
            }
            return false;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void markAsUrgent() {
            this.isUrgent = true;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.index + ", constraints = " + ((Object) Constraints.m2583toStringimpl(this.constraints)) + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        private HandleAndRequestImpl(int i5, long j5, PrefetchMetrics prefetchMetrics) {
            this.index = i5;
            this.constraints = j5;
            this.prefetchMetrics = prefetchMetrics;
        }
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeLayoutState = subcomposeLayoutState;
        this.executor = prefetchScheduler;
    }

    /* renamed from: createNestedPrefetchRequest-VKLhPVY, reason: not valid java name */
    public final PrefetchRequest m429createNestedPrefetchRequestVKLhPVY(int index, long constraints, PrefetchMetrics prefetchMetrics) {
        return new HandleAndRequestImpl(this, index, constraints, prefetchMetrics, null);
    }

    /* renamed from: schedulePrefetch-VKLhPVY, reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m430schedulePrefetchVKLhPVY(int index, long constraints, PrefetchMetrics prefetchMetrics) {
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, index, constraints, prefetchMetrics, null);
        this.executor.schedulePrefetch(handleAndRequestImpl);
        return handleAndRequestImpl;
    }
}
