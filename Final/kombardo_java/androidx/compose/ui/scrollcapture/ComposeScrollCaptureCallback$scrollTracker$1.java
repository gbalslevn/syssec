package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "delta"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$scrollTracker$1", f = "ComposeScrollCaptureCallback.android.kt", l = {85}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ComposeScrollCaptureCallback$scrollTracker$1 extends SuspendLambda implements Function2<Float, Continuation<? super Float>, Object> {
    /* synthetic */ float F$0;
    boolean Z$0;
    int label;
    final /* synthetic */ ComposeScrollCaptureCallback this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeScrollCaptureCallback$scrollTracker$1(ComposeScrollCaptureCallback composeScrollCaptureCallback, Continuation<? super ComposeScrollCaptureCallback$scrollTracker$1> continuation) {
        super(2, continuation);
        this.this$0 = composeScrollCaptureCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ComposeScrollCaptureCallback$scrollTracker$1 composeScrollCaptureCallback$scrollTracker$1 = new ComposeScrollCaptureCallback$scrollTracker$1(this.this$0, continuation);
        composeScrollCaptureCallback$scrollTracker$1.F$0 = ((Number) obj).floatValue();
        return composeScrollCaptureCallback$scrollTracker$1;
    }

    public final Object invoke(float f5, Continuation<? super Float> continuation) {
        return ((ComposeScrollCaptureCallback$scrollTracker$1) create(Float.valueOf(f5), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SemanticsNode semanticsNode;
        SemanticsNode semanticsNode2;
        boolean z5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            float f5 = this.F$0;
            semanticsNode = this.this$0.node;
            Function2<Offset, Continuation<? super Offset>, Object> scrollCaptureScrollByAction = ScrollCapture_androidKt.getScrollCaptureScrollByAction(semanticsNode);
            if (scrollCaptureScrollByAction == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                throw new KotlinNothingValueException();
            }
            semanticsNode2 = this.this$0.node;
            boolean reverseScrolling = ((ScrollAxisRange) semanticsNode2.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())).getReverseScrolling();
            if (reverseScrolling) {
                f5 = -f5;
            }
            Offset m1328boximpl = Offset.m1328boximpl(OffsetKt.Offset(0.0f, f5));
            this.Z$0 = reverseScrolling;
            this.label = 1;
            obj = scrollCaptureScrollByAction.invoke(m1328boximpl, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            z5 = reverseScrolling;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z5 = this.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        float m1338getYimpl = Offset.m1338getYimpl(((Offset) obj).getPackedValue());
        if (z5) {
            m1338getYimpl = -m1338getYimpl;
        }
        return Boxing.boxFloat(m1338getYimpl);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float f5, Continuation<? super Float> continuation) {
        return invoke(f5.floatValue(), continuation);
    }
}
