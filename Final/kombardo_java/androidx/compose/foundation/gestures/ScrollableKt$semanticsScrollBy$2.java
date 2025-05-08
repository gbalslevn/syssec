package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2", f = "Scrollable.kt", l = {967}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref$FloatRef $previousValue;
    final /* synthetic */ ScrollingLogic $this_semanticsScrollBy;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(ScrollingLogic scrollingLogic, long j5, Ref$FloatRef ref$FloatRef, Continuation<? super ScrollableKt$semanticsScrollBy$2> continuation) {
        super(2, continuation);
        this.$this_semanticsScrollBy = scrollingLogic;
        this.$offset = j5;
        this.$previousValue = ref$FloatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(this.$this_semanticsScrollBy, this.$offset, this.$previousValue, continuation);
        scrollableKt$semanticsScrollBy$2.L$0 = obj;
        return scrollableKt$semanticsScrollBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollableKt$semanticsScrollBy$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            float m234toFloatk4lQ0M = this.$this_semanticsScrollBy.m234toFloatk4lQ0M(this.$offset);
            final Ref$FloatRef ref$FloatRef = this.$previousValue;
            final ScrollingLogic scrollingLogic = this.$this_semanticsScrollBy;
            Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Float f5, Float f6) {
                    invoke(f5.floatValue(), f6.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f5, float f6) {
                    float f7 = f5 - Ref$FloatRef.this.element;
                    ScrollingLogic scrollingLogic2 = scrollingLogic;
                    Ref$FloatRef.this.element += scrollingLogic2.reverseIfNeeded(scrollingLogic2.m234toFloatk4lQ0M(nestedScrollScope.mo204scrollByOzD1aCk(scrollingLogic2.m235toOffsettuRUvjQ(scrollingLogic2.reverseIfNeeded(f7)), NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI())));
                }
            };
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, m234toFloatk4lQ0M, 0.0f, null, function2, this, 12, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
