package dk.molslinjen.ui.views.global.navigation.bottomsheet;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1", f = "BottomSheetDismissHandler.kt", l = {41}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BottomSheetDismissHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1(BottomSheetDismissHandler bottomSheetDismissHandler, Continuation<? super BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1> continuation) {
        super(2, continuation);
        this.this$0 = bottomSheetDismissHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
            this.label = 1;
            if (DelayKt.m3760delayVtjQ1oo(duration, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.forceDismissBottomSheetsAllowed = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
