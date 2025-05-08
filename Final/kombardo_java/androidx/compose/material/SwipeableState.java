package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 k*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001kB5\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u001b\u001a\u00020\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0013H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00028\u00002\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0005H\u0086@¢\u0006\u0004\b!\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R+\u0010/\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u00101\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010*RC\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010*\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0016R&\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00130A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IRO\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050M2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050M8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010*\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR+\u0010W\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bT\u00107\u001a\u0004\bU\u0010G\"\u0004\bV\u0010IR/\u0010^\u001a\u0004\u0018\u00010X2\b\u0010(\u001a\u0004\u0018\u00010X8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010`\u001a\u00020_8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050d8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u001a\u0010\u001c\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bi\u0010j\u001a\u0004\bh\u0010,¨\u0006l"}, d2 = {"Landroidx/compose/material/SwipeableState;", "T", BuildConfig.FLAVOR, "initialValue", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animationSpec", "Lkotlin/Function1;", BuildConfig.FLAVOR, "confirmStateChange", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "target", BuildConfig.FLAVOR, "snapInternalToOffset", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spec", "animateInternalToOffset", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "newAnchors", "ensureInit$material_release", "(Ljava/util/Map;)V", "ensureInit", "oldAnchors", "processNewAnchors$material_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "targetValue", "anim", "animateTo", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "performFling", "Landroidx/compose/animation/core/AnimationSpec;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "Lkotlin/jvm/functions/Function1;", "getConfirmStateChange$material_release", "()Lkotlin/jvm/functions/Function1;", "<set-?>", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue", "isAnimationRunning$delegate", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "Landroidx/compose/runtime/MutableFloatState;", "offsetState", "Landroidx/compose/runtime/MutableFloatState;", "overflowState", "absoluteOffset", "Landroidx/compose/runtime/MutableState;", "animationTarget", "anchors$delegate", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "anchors", "Lkotlinx/coroutines/flow/Flow;", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "minBound", "F", "getMinBound$material_release", "()F", "setMinBound$material_release", "(F)V", "maxBound", "getMaxBound$material_release", "setMaxBound$material_release", "Lkotlin/Function2;", "thresholds$delegate", "getThresholds$material_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds", "velocityThreshold$delegate", "getVelocityThreshold$material_release", "setVelocityThreshold$material_release", "velocityThreshold", "Landroidx/compose/material/ResistanceConfig;", "resistance$delegate", "getResistance$material_release", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material_release", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance", "Landroidx/compose/foundation/gestures/DraggableState;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "offset", "getTargetValue", "getTargetValue$annotations", "()V", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SwipeableState<T> {
    private final MutableFloatState absoluteOffset;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DraggableState draggableState;

    /* renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    private final MutableState isAnimationRunning;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;

    /* renamed from: resistance$delegate, reason: from kotlin metadata */
    private final MutableState resistance;

    /* renamed from: thresholds$delegate, reason: from kotlin metadata */
    private final MutableState thresholds;

    /* renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    private final MutableFloatState velocityThreshold;

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T t5, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState<Float> mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
        this.currentValue = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isAnimationRunning = mutableStateOf$default2;
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        this.anchors = mutableStateOf$default4;
        final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$material_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new Flow<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", l = {223}, m = "emit")
                /* renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (!((Map) obj).isEmpty()) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableState$thresholds$2
            public final Float invoke(float f5, float f6) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Float f5, Float f6) {
                return invoke(f5.floatValue(), f6.floatValue());
            }
        }, null, 2, null);
        this.thresholds = mutableStateOf$default5;
        this.velocityThreshold = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.resistance = mutableStateOf$default6;
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableState$draggableState$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                invoke(f5.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f5) {
                MutableFloatState mutableFloatState;
                MutableFloatState mutableFloatState2;
                MutableFloatState mutableFloatState3;
                MutableFloatState mutableFloatState4;
                mutableFloatState = ((SwipeableState) this.this$0).absoluteOffset;
                float floatValue = mutableFloatState.getFloatValue() + f5;
                float coerceIn = RangesKt.coerceIn(floatValue, this.this$0.getMinBound(), this.this$0.getMaxBound());
                float f6 = floatValue - coerceIn;
                ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
                float computeResistance = resistance$material_release != null ? resistance$material_release.computeResistance(f6) : 0.0f;
                mutableFloatState2 = ((SwipeableState) this.this$0).offsetState;
                mutableFloatState2.setFloatValue(coerceIn + computeResistance);
                mutableFloatState3 = ((SwipeableState) this.this$0).overflowState;
                mutableFloatState3.setFloatValue(f6);
                mutableFloatState4 = ((SwipeableState) this.this$0).absoluteOffset;
                mutableFloatState4.setFloatValue(floatValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f5, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(this.draggableState, null, new SwipeableState$animateInternalToOffset$2(this, f5, animationSpec, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i5 & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo(obj, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z5) {
        this.isAnimationRunning.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t5) {
        this.currentValue.setValue(t5);
    }

    private final Object snapInternalToOffset(float f5, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(this.draggableState, null, new SwipeableState$snapInternalToOffset$2(f5, this, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    public final Object animateTo(T t5, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$animateTo$2(t5, this, animationSpec), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void ensureInit$material_release(Map<Float, ? extends T> newAnchors) {
        Float offset;
        if (getAnchors$material_release().isEmpty()) {
            offset = SwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.");
            }
            this.offsetState.setFloatValue(offset.floatValue());
            this.absoluteOffset.setFloatValue(offset.floatValue());
        }
    }

    public final Map<Float, T> getAnchors$material_release() {
        return (Map) this.anchors.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    /* renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    /* renamed from: getMaxBound$material_release, reason: from getter */
    public final float getMaxBound() {
        return this.maxBound;
    }

    /* renamed from: getMinBound$material_release, reason: from getter */
    public final float getMinBound() {
        return this.minBound;
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final ResistanceConfig getResistance$material_release() {
        return (ResistanceConfig) this.resistance.getValue();
    }

    public final T getTargetValue() {
        Float offset;
        float computeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            computeTarget = value.floatValue();
        } else {
            float floatValue = getOffset().getValue().floatValue();
            offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
            computeTarget = SwipeableKt.computeTarget(floatValue, offset != null ? offset.floatValue() : getOffset().getValue().floatValue(), getAnchors$material_release().keySet(), getThresholds$material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t5 = getAnchors$material_release().get(Float.valueOf(computeTarget));
        return t5 == null ? getCurrentValue() : t5;
    }

    public final Function2<Float, Float, Float> getThresholds$material_release() {
        return (Function2) this.thresholds.getValue();
    }

    public final float getVelocityThreshold$material_release() {
        return this.velocityThreshold.getFloatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning.getValue()).booleanValue();
    }

    public final Object performFling(final float f5, Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new FlowCollector(this) { // from class: androidx.compose.material.SwipeableState$performFling$2
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Map) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation2) {
                Float offset;
                float computeTarget;
                Object animateInternalToOffset;
                offset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                Intrinsics.checkNotNull(offset);
                float floatValue = offset.floatValue();
                computeTarget = SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), floatValue, map.keySet(), this.this$0.getThresholds$material_release(), f5, this.this$0.getVelocityThreshold$material_release());
                T t5 = map.get(Boxing.boxFloat(computeTarget));
                if (t5 != null && this.this$0.getConfirmStateChange$material_release().invoke(t5).booleanValue()) {
                    Object animateTo$default = SwipeableState.animateTo$default(this.this$0, t5, null, continuation2, 2, null);
                    return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
                }
                SwipeableState<T> swipeableState = this.this$0;
                animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, swipeableState.getAnimationSpec$material_release(), continuation2);
                return animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateInternalToOffset : Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final java.lang.Object processNewAnchors$material_release(java.util.Map<java.lang.Float, ? extends T> r10, java.util.Map<java.lang.Float, ? extends T> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.processNewAnchors$material_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setAnchors$material_release(Map<Float, ? extends T> map) {
        this.anchors.setValue(map);
    }

    public final void setResistance$material_release(ResistanceConfig resistanceConfig) {
        this.resistance.setValue(resistanceConfig);
    }

    public final void setThresholds$material_release(Function2<? super Float, ? super Float, Float> function2) {
        this.thresholds.setValue(function2);
    }

    public final void setVelocityThreshold$material_release(float f5) {
        this.velocityThreshold.setFloatValue(f5);
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i5 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i5 & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t5) {
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                return invoke((AnonymousClass1) obj2);
            }
        } : function1);
    }
}
