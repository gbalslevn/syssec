package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.foundation.ScrollState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Point;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreenKt$Content$1$2$1", f = "FerryFloorSectionsScreen.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class FerryFloorSectionsScreenKt$Content$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Point $focusPoint;
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerryFloorSectionsScreenKt$Content$1$2$1(Point point, ScrollState scrollState, Continuation<? super FerryFloorSectionsScreenKt$Content$1$2$1> continuation) {
        super(2, continuation);
        this.$focusPoint = point;
        this.$scrollState = scrollState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerryFloorSectionsScreenKt$Content$1$2$1(this.$focusPoint, this.$scrollState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Point point = this.$focusPoint;
            if (point != null) {
                ScrollState scrollState = this.$scrollState;
                int y5 = (int) (point.getY() * scrollState.getMaxValue());
                this.label = 1;
                if (ScrollState.animateScrollTo$default(scrollState, y5, null, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerryFloorSectionsScreenKt$Content$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
