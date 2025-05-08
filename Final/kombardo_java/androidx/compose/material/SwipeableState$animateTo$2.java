package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableFloatState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "anchors", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeableState$animateTo$2<T> implements FlowCollector {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SwipeableState$animateTo$2(T t5, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t5;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
        int i5;
        SwipeableState$animateTo$2<T> swipeableState$animateTo$2;
        Float offset;
        Object animateInternalToOffset;
        MutableFloatState mutableFloatState;
        Object firstOrNull;
        MutableFloatState mutableFloatState2;
        Object firstOrNull2;
        if (continuation instanceof SwipeableState$animateTo$2$emit$1) {
            swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) continuation;
            int i6 = swipeableState$animateTo$2$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                swipeableState$animateTo$2$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = swipeableState$animateTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = swipeableState$animateTo$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        offset = SwipeableKt.getOffset(map, this.$targetValue);
                        if (offset != null) {
                            SwipeableState<T> swipeableState = this.this$0;
                            float floatValue = offset.floatValue();
                            AnimationSpec<Float> animationSpec = this.$anim;
                            swipeableState$animateTo$2$emit$1.L$0 = this;
                            swipeableState$animateTo$2$emit$1.L$1 = map;
                            swipeableState$animateTo$2$emit$1.label = 1;
                            animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, animationSpec, swipeableState$animateTo$2$emit$1);
                            if (animateInternalToOffset == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            swipeableState$animateTo$2 = this;
                        } else {
                            throw new IllegalArgumentException("The target value must have an associated anchor.");
                        }
                    } catch (Throwable th) {
                        th = th;
                        swipeableState$animateTo$2 = this;
                        mutableFloatState = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
                        float floatValue2 = mutableFloatState.getFloatValue();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        while (r7.hasNext()) {
                        }
                        firstOrNull = CollectionsKt.firstOrNull(linkedHashMap.values());
                        if (firstOrNull == null) {
                        }
                        swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull);
                        throw th;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) swipeableState$animateTo$2$emit$1.L$1;
                    swipeableState$animateTo$2 = (SwipeableState$animateTo$2) swipeableState$animateTo$2$emit$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        mutableFloatState = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
                        float floatValue22 = mutableFloatState.getFloatValue();
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                            if (Math.abs(entry.getKey().floatValue() - floatValue22) < 0.5f) {
                                linkedHashMap2.put(entry.getKey(), entry.getValue());
                            }
                        }
                        firstOrNull = CollectionsKt.firstOrNull(linkedHashMap2.values());
                        if (firstOrNull == null) {
                            firstOrNull = swipeableState$animateTo$2.this$0.getCurrentValue();
                        }
                        swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull);
                        throw th;
                    }
                }
                mutableFloatState2 = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
                float floatValue3 = mutableFloatState2.getFloatValue();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                    if (Math.abs(entry2.getKey().floatValue() - floatValue3) < 0.5f) {
                        linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                    }
                }
                firstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap3.values());
                if (firstOrNull2 == null) {
                    firstOrNull2 = swipeableState$animateTo$2.this$0.getCurrentValue();
                }
                swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull2);
                return Unit.INSTANCE;
            }
        }
        swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
        Object obj2 = swipeableState$animateTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = swipeableState$animateTo$2$emit$1.label;
        if (i5 != 0) {
        }
        mutableFloatState2 = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
        float floatValue32 = mutableFloatState2.getFloatValue();
        LinkedHashMap linkedHashMap32 = new LinkedHashMap();
        while (r7.hasNext()) {
        }
        firstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap32.values());
        if (firstOrNull2 == null) {
        }
        swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull2);
        return Unit.INSTANCE;
    }
}
