package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {574, 585}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
        synchronized (recomposer.stateLock) {
            try {
                list.clear();
                list2.clear();
                int size = list3.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ControlledComposition controlledComposition = list3.get(i5);
                    controlledComposition.abandonChanges();
                    recomposer.recordFailedCompositionLocked(controlledComposition);
                }
                list3.clear();
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                long j5 = -9187201950435737472L;
                if (length >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j6 = jArr[i6];
                        long[] jArr2 = jArr;
                        if ((((~j6) << 7) & j6 & j5) != j5) {
                            int i7 = 8 - ((~(i6 - length)) >>> 31);
                            for (int i8 = 0; i8 < i7; i8++) {
                                if ((j6 & 255) < 128) {
                                    ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i6 << 3) + i8];
                                    controlledComposition2.abandonChanges();
                                    recomposer.recordFailedCompositionLocked(controlledComposition2);
                                }
                                j6 >>= 8;
                            }
                            if (i7 != 8) {
                                break;
                            }
                        }
                        if (i6 == length) {
                            break;
                        }
                        i6++;
                        jArr = jArr2;
                        j5 = -9187201950435737472L;
                    }
                }
                mutableScatterSet.clear();
                Object[] objArr2 = mutableScatterSet2.elements;
                long[] jArr3 = mutableScatterSet2.metadata;
                int length2 = jArr3.length - 2;
                if (length2 >= 0) {
                    int i9 = 0;
                    while (true) {
                        long j7 = jArr3[i9];
                        if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                            for (int i11 = 0; i11 < i10; i11++) {
                                if ((j7 & 255) < 128) {
                                    ((ControlledComposition) objArr2[(i9 << 3) + i11]).changesApplied();
                                }
                                j7 >>= 8;
                            }
                            if (i10 != 8) {
                                break;
                            }
                        }
                        if (i9 == length2) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                }
                mutableScatterSet2.clear();
                mutableScatterSet3.clear();
                Object[] objArr3 = mutableScatterSet4.elements;
                long[] jArr4 = mutableScatterSet4.metadata;
                int length3 = jArr4.length - 2;
                if (length3 >= 0) {
                    int i12 = 0;
                    while (true) {
                        long j8 = jArr4[i12];
                        if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i13 = 8 - ((~(i12 - length3)) >>> 31);
                            for (int i14 = 0; i14 < i13; i14++) {
                                if ((j8 & 255) < 128) {
                                    ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i12 << 3) + i14];
                                    controlledComposition3.abandonChanges();
                                    recomposer.recordFailedCompositionLocked(controlledComposition3);
                                }
                                j8 >>= 8;
                            }
                            if (i13 != 8) {
                                break;
                            }
                        }
                        if (i12 == length3) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                mutableScatterSet4.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        List list2;
        List list3;
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                list2 = recomposer.compositionValuesAwaitingInsert;
                int size = list2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list.add((MovableContentStateReference) list2.get(i5));
                }
                list3 = recomposer.compositionValuesAwaitingInsert;
                list3.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0166  */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0139 -> B:6:0x0142). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0151 -> B:7:0x014d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MonotonicFrameClock monotonicFrameClock;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MutableScatterSet mutableScatterSetOf;
        MutableScatterSet mutableScatterSetOf2;
        MutableScatterSet mutableScatterSet;
        Set wrapIntoSet;
        MutableScatterSet mutableScatterSetOf3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        MutableScatterSet mutableScatterSet2;
        MutableScatterSet mutableScatterSet3;
        Set set;
        MutableScatterSet mutableScatterSet4;
        boolean recordComposerModifications;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        char c5 = 2;
        int i6 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSet = new MutableScatterSet(0, 1, null);
            wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
            mutableScatterSetOf3 = ScatterSetKt.mutableScatterSetOf();
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
            }
        } else if (i5 == 1) {
            MutableScatterSet mutableScatterSet5 = (MutableScatterSet) this.L$8;
            Set set2 = (Set) this.L$7;
            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) this.L$6;
            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) this.L$5;
            MutableScatterSet mutableScatterSet8 = (MutableScatterSet) this.L$4;
            ?? r9 = (List) this.L$3;
            ?? r10 = (List) this.L$2;
            ?? r11 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            arrayList6 = r9;
            arrayList5 = r10;
            arrayList4 = r11;
            set = set2;
            mutableScatterSet = mutableScatterSet6;
            mutableScatterSet3 = mutableScatterSet7;
            mutableScatterSet4 = mutableScatterSet5;
            monotonicFrameClock = monotonicFrameClock2;
            mutableScatterSet2 = mutableScatterSet8;
            recordComposerModifications = this.this$0.recordComposerModifications();
            if (recordComposerModifications) {
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableScatterSet mutableScatterSet9 = (MutableScatterSet) this.L$8;
            Set set3 = (Set) this.L$7;
            MutableScatterSet mutableScatterSet10 = (MutableScatterSet) this.L$6;
            MutableScatterSet mutableScatterSet11 = (MutableScatterSet) this.L$5;
            MutableScatterSet mutableScatterSet12 = (MutableScatterSet) this.L$4;
            ?? r92 = (List) this.L$3;
            ?? r102 = (List) this.L$2;
            ?? r112 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object obj2 = coroutine_suspended;
            MutableScatterSet mutableScatterSet13 = mutableScatterSet12;
            char c6 = 2;
            MutableScatterSet mutableScatterSet14 = mutableScatterSet10;
            arrayList2 = r102;
            mutableScatterSetOf3 = mutableScatterSet9;
            monotonicFrameClock = monotonicFrameClock3;
            wrapIntoSet = set3;
            arrayList = r112;
            mutableScatterSetOf2 = mutableScatterSet11;
            arrayList3 = r92;
            this.this$0.discardUnusedValues();
            i6 = 1;
            char c7 = c6;
            mutableScatterSetOf = mutableScatterSet13;
            coroutine_suspended = obj2;
            mutableScatterSet = mutableScatterSet14;
            c5 = c7;
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                Recomposer recomposer = this.this$0;
                this.L$0 = monotonicFrameClock;
                this.L$1 = arrayList;
                this.L$2 = arrayList2;
                this.L$3 = arrayList3;
                this.L$4 = mutableScatterSetOf;
                this.L$5 = mutableScatterSetOf2;
                this.L$6 = mutableScatterSet;
                this.L$7 = wrapIntoSet;
                this.L$8 = mutableScatterSetOf3;
                this.label = i6;
                awaitWorkAvailable = recomposer.awaitWorkAvailable(this);
                if (awaitWorkAvailable == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList4 = arrayList;
                arrayList5 = arrayList2;
                arrayList6 = arrayList3;
                mutableScatterSet4 = mutableScatterSetOf3;
                mutableScatterSet2 = mutableScatterSetOf;
                Set set4 = wrapIntoSet;
                mutableScatterSet3 = mutableScatterSetOf2;
                set = set4;
                recordComposerModifications = this.this$0.recordComposerModifications();
                if (recordComposerModifications) {
                    MutableScatterSet mutableScatterSet15 = mutableScatterSet;
                    Object obj3 = coroutine_suspended;
                    MutableScatterSet mutableScatterSet16 = mutableScatterSet2;
                    mutableScatterSetOf3 = mutableScatterSet4;
                    MutableScatterSet mutableScatterSet17 = mutableScatterSet3;
                    wrapIntoSet = set;
                    mutableScatterSetOf2 = mutableScatterSet17;
                    arrayList = arrayList4;
                    arrayList3 = arrayList6;
                    i6 = 1;
                    c7 = c5;
                    mutableScatterSetOf = mutableScatterSet16;
                    coroutine_suspended = obj3;
                    mutableScatterSet = mutableScatterSet15;
                    arrayList2 = arrayList5;
                    c5 = c7;
                    shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                    }
                } else {
                    final Recomposer recomposer2 = this.this$0;
                    final MutableScatterSet mutableScatterSet18 = mutableScatterSet4;
                    final MutableScatterSet mutableScatterSet19 = mutableScatterSet;
                    final Set set5 = set;
                    final ArrayList arrayList7 = arrayList4;
                    MutableScatterSet mutableScatterSet20 = mutableScatterSet;
                    final ArrayList arrayList8 = arrayList5;
                    final MutableScatterSet mutableScatterSet21 = mutableScatterSet3;
                    final MutableScatterSet mutableScatterSet22 = mutableScatterSet2;
                    Object obj4 = coroutine_suspended;
                    mutableScatterSet13 = mutableScatterSet2;
                    final ArrayList arrayList9 = arrayList6;
                    ArrayList arrayList10 = arrayList6;
                    ArrayList arrayList11 = arrayList5;
                    Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                            invoke(l5.longValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:172:0x031f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:184:0x033b A[SYNTHETIC] */
                        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object] */
                        /* JADX WARN: Type inference failed for: r7v1 */
                        /* JADX WARN: Type inference failed for: r7v13 */
                        /* JADX WARN: Type inference failed for: r7v2 */
                        /* JADX WARN: Type inference failed for: r7v33 */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(long j5) {
                            boolean hasBroadcastFrameClockAwaiters;
                            MutableVector mutableVector;
                            MutableVector mutableVector2;
                            List knownCompositions;
                            MutableVector mutableVector3;
                            Set<? extends Object> set6;
                            Set<? extends Object> set7;
                            List performInsertValues;
                            MutableVector mutableVector4;
                            ControlledComposition performRecompose;
                            Recomposer recomposer3;
                            Object[] objArr;
                            Object[] objArr2;
                            BroadcastFrameClock broadcastFrameClock;
                            AnonymousClass1 anonymousClass1 = this;
                            hasBroadcastFrameClockAwaiters = Recomposer.this.getHasBroadcastFrameClockAwaiters();
                            if (hasBroadcastFrameClockAwaiters) {
                                Recomposer recomposer4 = Recomposer.this;
                                Trace trace = Trace.INSTANCE;
                                Object beginSection = trace.beginSection("Recomposer:animation");
                                try {
                                    broadcastFrameClock = recomposer4.broadcastFrameClock;
                                    broadcastFrameClock.sendFrame(j5);
                                    Snapshot.INSTANCE.sendApplyNotifications();
                                    Unit unit = Unit.INSTANCE;
                                    trace.endSection(beginSection);
                                } catch (Throwable th) {
                                    Trace.INSTANCE.endSection(beginSection);
                                    throw th;
                                }
                            }
                            Recomposer recomposer5 = Recomposer.this;
                            MutableScatterSet<Object> mutableScatterSet23 = mutableScatterSet19;
                            MutableScatterSet<ControlledComposition> mutableScatterSet24 = mutableScatterSet18;
                            List<ControlledComposition> list = arrayList7;
                            List<MovableContentStateReference> list2 = arrayList8;
                            MutableScatterSet<ControlledComposition> mutableScatterSet25 = mutableScatterSet22;
                            List<ControlledComposition> list3 = arrayList9;
                            MutableScatterSet<ControlledComposition> mutableScatterSet26 = mutableScatterSet21;
                            Set<? extends Object> set8 = set5;
                            ?? beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
                            try {
                                recomposer5.recordComposerModifications();
                                synchronized (recomposer5.stateLock) {
                                    try {
                                        try {
                                            mutableVector = recomposer5.compositionInvalidations;
                                            int size = mutableVector.getSize();
                                            if (size > 0) {
                                                Object[] content = mutableVector.getContent();
                                                int i7 = 0;
                                                while (true) {
                                                    Object[] objArr3 = content;
                                                    list.add((ControlledComposition) content[i7]);
                                                    i7++;
                                                    if (i7 >= size) {
                                                        break;
                                                    } else {
                                                        content = objArr3;
                                                    }
                                                }
                                            }
                                            mutableVector2 = recomposer5.compositionInvalidations;
                                            mutableVector2.clear();
                                            Unit unit2 = Unit.INSTANCE;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            Trace.INSTANCE.endSection(anonymousClass1);
                                            throw th;
                                        }
                                    } finally {
                                    }
                                }
                                mutableScatterSet23.clear();
                                mutableScatterSet24.clear();
                                beginSection2 = beginSection2;
                                while (true) {
                                    if (list.isEmpty() && list2.isEmpty()) {
                                        break;
                                    }
                                    anonymousClass1 = beginSection2;
                                    try {
                                        try {
                                            int size2 = list.size();
                                            for (int i8 = 0; i8 < size2; i8++) {
                                                ControlledComposition controlledComposition = list.get(i8);
                                                performRecompose = recomposer5.performRecompose(controlledComposition, mutableScatterSet23);
                                                if (performRecompose != null) {
                                                    list3.add(performRecompose);
                                                    Unit unit3 = Unit.INSTANCE;
                                                }
                                                mutableScatterSet24.add(controlledComposition);
                                            }
                                            list.clear();
                                            if (!mutableScatterSet23.isNotEmpty()) {
                                                mutableVector4 = recomposer5.compositionInvalidations;
                                                if (!mutableVector4.isNotEmpty()) {
                                                    set6 = set8;
                                                    if (!list.isEmpty()) {
                                                        try {
                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer5);
                                                            while (!list2.isEmpty()) {
                                                                performInsertValues = recomposer5.performInsertValues(list2, mutableScatterSet23);
                                                                mutableScatterSet25.plusAssign(performInsertValues);
                                                                Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer5);
                                                            }
                                                        } catch (Exception e5) {
                                                            Recomposer.processCompositionError$default(recomposer5, e5, null, true, 2, null);
                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer5, list, list2, list3, mutableScatterSet25, mutableScatterSet26, mutableScatterSet23, mutableScatterSet24);
                                                            Trace.INSTANCE.endSection(anonymousClass1);
                                                            return;
                                                        }
                                                    }
                                                    beginSection2 = anonymousClass1;
                                                    set8 = set6;
                                                    anonymousClass1 = this;
                                                }
                                            }
                                            synchronized (recomposer5.stateLock) {
                                                try {
                                                    knownCompositions = recomposer5.getKnownCompositions();
                                                    int size3 = knownCompositions.size();
                                                    for (int i9 = 0; i9 < size3; i9++) {
                                                        ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositions.get(i9);
                                                        if (!mutableScatterSet24.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set8)) {
                                                            list.add(controlledComposition2);
                                                        }
                                                    }
                                                    mutableVector3 = recomposer5.compositionInvalidations;
                                                    int size4 = mutableVector3.getSize();
                                                    int i10 = 0;
                                                    int i11 = 0;
                                                    while (i10 < size4) {
                                                        ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector3.getContent()[i10];
                                                        if (mutableScatterSet24.contains(controlledComposition3) || list.contains(controlledComposition3)) {
                                                            set7 = set8;
                                                            if (i11 > 0) {
                                                                mutableVector3.getContent()[i10 - i11] = mutableVector3.getContent()[i10];
                                                            }
                                                        } else {
                                                            set7 = set8;
                                                            list.add(controlledComposition3);
                                                            i11++;
                                                        }
                                                        i10++;
                                                        set8 = set7;
                                                    }
                                                    set6 = set8;
                                                    int i12 = size4 - i11;
                                                    ArraysKt.fill(mutableVector3.getContent(), (Object) null, i12, size4);
                                                    mutableVector3.setSize(i12);
                                                    Unit unit4 = Unit.INSTANCE;
                                                } finally {
                                                }
                                            }
                                            if (!list.isEmpty()) {
                                            }
                                            beginSection2 = anonymousClass1;
                                            set8 = set6;
                                            anonymousClass1 = this;
                                        } catch (Exception e6) {
                                            Recomposer.processCompositionError$default(recomposer5, e6, null, true, 2, null);
                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer5, list, list2, list3, mutableScatterSet25, mutableScatterSet26, mutableScatterSet23, mutableScatterSet24);
                                            list.clear();
                                            Trace.INSTANCE.endSection(anonymousClass1);
                                            return;
                                        }
                                    } finally {
                                        list.clear();
                                    }
                                }
                                if (!list3.isEmpty()) {
                                    recomposer5.changeCount = recomposer5.getChangeCount() + 1;
                                    try {
                                        int size5 = list3.size();
                                        for (int i13 = 0; i13 < size5; i13++) {
                                            mutableScatterSet26.add(list3.get(i13));
                                        }
                                        int size6 = list3.size();
                                        for (int i14 = 0; i14 < size6; i14++) {
                                            list3.get(i14).applyChanges();
                                        }
                                        list3.clear();
                                    } catch (Exception e7) {
                                        anonymousClass1 = beginSection2;
                                        try {
                                            Recomposer.processCompositionError$default(recomposer5, e7, null, false, 6, null);
                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer5, list, list2, list3, mutableScatterSet25, mutableScatterSet26, mutableScatterSet23, mutableScatterSet24);
                                            list3.clear();
                                            Trace.INSTANCE.endSection(anonymousClass1);
                                            return;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            list3.clear();
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        list3.clear();
                                        throw th;
                                    }
                                }
                                anonymousClass1 = beginSection2;
                                if (mutableScatterSet25.isNotEmpty()) {
                                    try {
                                        try {
                                            mutableScatterSet26.plusAssign(mutableScatterSet25);
                                            Object[] objArr4 = mutableScatterSet25.elements;
                                            long[] jArr = mutableScatterSet25.metadata;
                                            int length = jArr.length - 2;
                                            if (length >= 0) {
                                                int i15 = 0;
                                                while (true) {
                                                    long j6 = jArr[i15];
                                                    recomposer3 = recomposer5;
                                                    if ((j6 & ((~j6) << 7) & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i16 = 8 - ((~(i15 - length)) >>> 31);
                                                        int i17 = 0;
                                                        while (i17 < i16) {
                                                            if ((j6 & 255) < 128) {
                                                                try {
                                                                    ((ControlledComposition) objArr4[(i15 << 3) + i17]).applyLateChanges();
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    Recomposer.processCompositionError$default(recomposer3, e, null, false, 6, null);
                                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer3, list, list2, list3, mutableScatterSet25, mutableScatterSet26, mutableScatterSet23, mutableScatterSet24);
                                                                    mutableScatterSet25.clear();
                                                                    Trace.INSTANCE.endSection(anonymousClass1);
                                                                    return;
                                                                }
                                                            }
                                                            j6 >>= 8;
                                                            i17++;
                                                            objArr4 = objArr4;
                                                        }
                                                        objArr = objArr4;
                                                        if (i16 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        objArr = objArr4;
                                                    }
                                                    if (i15 == length) {
                                                        break;
                                                    }
                                                    i15++;
                                                    recomposer5 = recomposer3;
                                                    objArr4 = objArr;
                                                }
                                            } else {
                                                recomposer3 = recomposer5;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            recomposer3 = recomposer5;
                                        }
                                    } finally {
                                        mutableScatterSet25.clear();
                                    }
                                } else {
                                    recomposer3 = recomposer5;
                                }
                                if (mutableScatterSet26.isNotEmpty()) {
                                    try {
                                        try {
                                            Object[] objArr5 = mutableScatterSet26.elements;
                                            long[] jArr2 = mutableScatterSet26.metadata;
                                            int length2 = jArr2.length - 2;
                                            if (length2 >= 0) {
                                                int i18 = 0;
                                                while (true) {
                                                    long j7 = jArr2[i18];
                                                    if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                                        int i20 = 0;
                                                        while (i20 < i19) {
                                                            if ((j7 & 255) < 128) {
                                                                ((ControlledComposition) objArr5[(i18 << 3) + i20]).changesApplied();
                                                            }
                                                            j7 >>= 8;
                                                            i20++;
                                                            objArr5 = objArr5;
                                                        }
                                                        objArr2 = objArr5;
                                                        if (i19 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        objArr2 = objArr5;
                                                    }
                                                    if (i18 == length2) {
                                                        break;
                                                    }
                                                    i18++;
                                                    objArr5 = objArr2;
                                                }
                                            }
                                        } catch (Exception e10) {
                                            Recomposer.processCompositionError$default(recomposer3, e10, null, false, 6, null);
                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer3, list, list2, list3, mutableScatterSet25, mutableScatterSet26, mutableScatterSet23, mutableScatterSet24);
                                            mutableScatterSet26.clear();
                                            Trace.INSTANCE.endSection(anonymousClass1);
                                            return;
                                        }
                                    } finally {
                                        mutableScatterSet26.clear();
                                    }
                                }
                                synchronized (recomposer3.stateLock) {
                                    recomposer3.deriveStateLocked();
                                }
                                Snapshot.INSTANCE.notifyObjectsInitialized();
                                mutableScatterSet24.clear();
                                mutableScatterSet23.clear();
                                recomposer3.compositionsRemoved = null;
                                Unit unit5 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(anonymousClass1);
                            } catch (Throwable th5) {
                                th = th5;
                                anonymousClass1 = beginSection2;
                            }
                        }
                    };
                    this.L$0 = monotonicFrameClock;
                    this.L$1 = arrayList4;
                    this.L$2 = arrayList11;
                    this.L$3 = arrayList10;
                    this.L$4 = mutableScatterSet13;
                    this.L$5 = mutableScatterSet21;
                    this.L$6 = mutableScatterSet20;
                    this.L$7 = set5;
                    mutableScatterSetOf3 = mutableScatterSet18;
                    this.L$8 = mutableScatterSetOf3;
                    c6 = 2;
                    this.label = 2;
                    obj2 = obj4;
                    if (monotonicFrameClock.withFrameNanos(function1, this) == obj2) {
                        return obj2;
                    }
                    wrapIntoSet = set5;
                    mutableScatterSetOf2 = mutableScatterSet21;
                    arrayList = arrayList4;
                    arrayList3 = arrayList10;
                    arrayList2 = arrayList11;
                    mutableScatterSet14 = mutableScatterSet20;
                    this.this$0.discardUnusedValues();
                    i6 = 1;
                    char c72 = c6;
                    mutableScatterSetOf = mutableScatterSet13;
                    coroutine_suspended = obj2;
                    mutableScatterSet = mutableScatterSet14;
                    c5 = c72;
                    shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }
}
