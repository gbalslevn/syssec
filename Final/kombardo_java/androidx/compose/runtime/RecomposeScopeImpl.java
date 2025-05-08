package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\b\u0000\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\u00072\u0018\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J)\u0010\u001e\u001a\u00020\u00102\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0010¢\u0006\u0004\b#\u0010\u0018J\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u00020\u00102\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b*\u0010&J\r\u0010+\u001a\u00020\u0010¢\u0006\u0004\b+\u0010\u0018J#\u0010.\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0010\u0018\u00010,2\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010:R\u001e\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\u0018R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00101R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR*\u0010C\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010I\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010L\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8@@BX\u0080\u000e¢\u0006\f\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\u0011\u0010N\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bM\u0010FR\u0011\u0010P\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bO\u0010FR$\u0010S\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010F\"\u0004\bR\u0010HR$\u0010V\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010F\"\u0004\bU\u0010HR$\u0010Y\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010F\"\u0004\bX\u0010HR$\u0010\\\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010F\"\u0004\b[\u0010HR$\u0010_\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010F\"\u0004\b^\u0010HR\u0011\u0010`\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b`\u0010F¨\u0006b"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "owner", "<init>", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "Landroidx/compose/runtime/DerivedState;", "Landroidx/collection/MutableScatterMap;", BuildConfig.FLAVOR, "dependencies", BuildConfig.FLAVOR, "checkDerivedStateChanged", "(Landroidx/compose/runtime/DerivedState;Landroidx/collection/MutableScatterMap;)Z", "Landroidx/compose/runtime/Composer;", "composer", BuildConfig.FLAVOR, "compose", "(Landroidx/compose/runtime/Composer;)V", "value", "Landroidx/compose/runtime/InvalidationResult;", "invalidateForResult", "(Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "release", "()V", "adoptedBy", "invalidate", "Lkotlin/Function2;", BuildConfig.FLAVOR, "block", "updateScope", "(Lkotlin/jvm/functions/Function2;)V", "token", "start", "(I)V", "scopeSkipped", "instance", "recordRead", "(Ljava/lang/Object;)Z", "recordDerivedStateValue", "(Landroidx/compose/runtime/DerivedState;Ljava/lang/Object;)V", "instances", "isInvalidFor", "rereadTrackedInstances", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "end", "(I)Lkotlin/jvm/functions/Function1;", "flags", "I", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/Anchor;", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "Lkotlin/jvm/functions/Function2;", "Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "observer", "Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "getObserver$annotations", "currentToken", "Landroidx/collection/MutableObjectIntMap;", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "getRereading", "()Z", "setRereading", "(Z)V", "rereading", "getSkipped$runtime_release", "setSkipped", "skipped", "getValid", "valid", "getCanRecompose", "canRecompose", "getUsed", "setUsed", "used", "getDefaultsInScope", "setDefaultsInScope", "defaultsInScope", "getDefaultsInvalid", "setDefaultsInvalid", "defaultsInvalid", "getRequiresRecompose", "setRequiresRecompose", "requiresRecompose", "getForcedRecompose", "setForcedRecompose", "forcedRecompose", "isConditional", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeObserver observer;
    private RecomposeScopeOwner owner;
    private MutableScatterMap<DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/runtime/SlotWriter;", "slots", BuildConfig.FLAVOR, "Landroidx/compose/runtime/Anchor;", "anchors", "Landroidx/compose/runtime/RecomposeScopeOwner;", "newOwner", BuildConfig.FLAVOR, "adoptAnchoredScopes$runtime_release", "(Landroidx/compose/runtime/SlotWriter;Ljava/util/List;Landroidx/compose/runtime/RecomposeScopeOwner;)V", "adoptAnchoredScopes", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slots, List<Anchor> anchors, RecomposeScopeOwner newOwner) {
            if (anchors.isEmpty()) {
                return;
            }
            int size = anchors.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object slot = slots.slot(anchors.get(i5), 0);
                RecomposeScopeImpl recomposeScopeImpl = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(newOwner);
                }
            }
        }

        private Companion() {
        }
    }

    public RecomposeScopeImpl(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    private final boolean checkDerivedStateChanged(DerivedState<?> derivedState, MutableScatterMap<DerivedState<?>, Object> mutableScatterMap) {
        Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
        if (policy == null) {
            policy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return !policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), mutableScatterMap.get(derivedState));
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z5) {
        if (z5) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z5) {
        if (z5) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void adoptedBy(RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    public final void compose(Composer composer) {
        Unit unit;
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope");
        }
    }

    public final Function1<Composition, Unit> end(final int token) {
        final MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        if (mutableObjectIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        Object[] objArr = mutableObjectIntMap.keys;
        int[] iArr = mutableObjectIntMap.values;
        long[] jArr = mutableObjectIntMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        Object obj = objArr[i8];
                        if (iArr[i8] != token) {
                            return new Function1<Composition, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Composition composition) {
                                    invoke2(composition);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Composition composition) {
                                    int i9;
                                    MutableObjectIntMap mutableObjectIntMap2;
                                    int i10;
                                    MutableScatterMap mutableScatterMap;
                                    i9 = RecomposeScopeImpl.this.currentToken;
                                    if (i9 != token) {
                                        return;
                                    }
                                    MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableObjectIntMap;
                                    mutableObjectIntMap2 = RecomposeScopeImpl.this.trackedInstances;
                                    if (!Intrinsics.areEqual(mutableObjectIntMap3, mutableObjectIntMap2) || !(composition instanceof CompositionImpl)) {
                                        return;
                                    }
                                    MutableObjectIntMap<Object> mutableObjectIntMap4 = mutableObjectIntMap;
                                    int i11 = token;
                                    RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                                    long[] jArr2 = mutableObjectIntMap4.metadata;
                                    int length2 = jArr2.length - 2;
                                    if (length2 < 0) {
                                        return;
                                    }
                                    int i12 = 0;
                                    while (true) {
                                        long j6 = jArr2[i12];
                                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i13 = 8;
                                            int i14 = 8 - ((~(i12 - length2)) >>> 31);
                                            int i15 = 0;
                                            while (i15 < i14) {
                                                if ((255 & j6) < 128) {
                                                    int i16 = (i12 << 3) + i15;
                                                    Object obj2 = mutableObjectIntMap4.keys[i16];
                                                    boolean z5 = mutableObjectIntMap4.values[i16] != i11;
                                                    if (z5) {
                                                        CompositionImpl compositionImpl = (CompositionImpl) composition;
                                                        compositionImpl.removeObservation$runtime_release(obj2, recomposeScopeImpl);
                                                        if (obj2 instanceof DerivedState) {
                                                            compositionImpl.removeDerivedStateObservation$runtime_release((DerivedState) obj2);
                                                            mutableScatterMap = recomposeScopeImpl.trackedDependencies;
                                                            if (mutableScatterMap != null) {
                                                                mutableScatterMap.remove(obj2);
                                                            }
                                                        }
                                                    }
                                                    if (z5) {
                                                        mutableObjectIntMap4.removeValueAt(i16);
                                                    }
                                                    i10 = 8;
                                                } else {
                                                    i10 = i13;
                                                }
                                                j6 >>= i10;
                                                i15++;
                                                i13 = i10;
                                            }
                                            if (i14 != i13) {
                                                return;
                                            }
                                        }
                                        if (i12 == length2) {
                                            return;
                                        } else {
                                            i12++;
                                        }
                                    }
                                }
                            };
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return null;
                }
            }
            if (i5 == length) {
                return null;
            }
            i5++;
        }
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getForcedRecompose() {
        return (this.flags & 64) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.owner == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    public final InvalidationResult invalidateForResult(Object value) {
        InvalidationResult invalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidate = recomposeScopeOwner.invalidate(this, value)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    public final boolean isInvalidFor(Object instances) {
        MutableScatterMap<DerivedState<?>, Object> mutableScatterMap;
        if (instances == null || (mutableScatterMap = this.trackedDependencies) == null) {
            return true;
        }
        if (instances instanceof DerivedState) {
            return checkDerivedStateChanged((DerivedState) instances, mutableScatterMap);
        }
        if (!(instances instanceof ScatterSet)) {
            return true;
        }
        ScatterSet scatterSet = (ScatterSet) instances;
        if (scatterSet.isNotEmpty()) {
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                Object obj = objArr[(i5 << 3) + i7];
                                if (!(obj instanceof DerivedState) || checkDerivedStateChanged((DerivedState) obj, mutableScatterMap)) {
                                    return true;
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return false;
    }

    public final void recordDerivedStateValue(DerivedState<?> instance, Object value) {
        MutableScatterMap<DerivedState<?>, Object> mutableScatterMap = this.trackedDependencies;
        if (mutableScatterMap == null) {
            mutableScatterMap = new MutableScatterMap<>(0, 1, null);
            this.trackedDependencies = mutableScatterMap;
        }
        mutableScatterMap.set(instance, value);
    }

    public final boolean recordRead(Object instance) {
        if (getRereading()) {
            return false;
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        if (mutableObjectIntMap == null) {
            mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
            this.trackedInstances = mutableObjectIntMap;
        }
        return mutableObjectIntMap.put(instance, this.currentToken, -1) == this.currentToken;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void rereadTrackedInstances() {
        MutableObjectIntMap<Object> mutableObjectIntMap;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner == null || (mutableObjectIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                int i8 = (i5 << 3) + i7;
                                Object obj = objArr[i8];
                                int i9 = iArr[i8];
                                recomposeScopeOwner.recordReadOf(obj);
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        } finally {
            setRereading(false);
        }
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final void setDefaultsInScope(boolean z5) {
        if (z5) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z5) {
        if (z5) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setForcedRecompose(boolean z5) {
        if (z5) {
            this.flags |= 64;
        } else {
            this.flags &= -65;
        }
    }

    public final void setRequiresRecompose(boolean z5) {
        if (z5) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z5) {
        if (z5) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> block) {
        this.block = block;
    }
}
